package leetcode.everyday.commit2022.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 310  最小高度树
 *
 * 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 *
 * 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 *
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 *
 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 *
 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：n = 4, edges = [[1,0],[1,2],[1,3]]
 * 输出：[1]
 * 解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。
 * 示例 2：
 *
 *
 * 输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * 输出：[3,4]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 2 * 104
 * edges.length == n - 1
 * 0 <= ai, bi < n
 * ai != bi
 * 所有 (ai, bi) 互不相同
 * 给定的输入 保证 是一棵树，并且 不会有重复的边
 * 通过次数29,159提交次数74,907
 *
 *
 */
public class Solution_20220406_310 {

    int N = 20010, M = N * 2, idx = 0;
    int[] he = new int[N], e = new int[M], ne = new int[M];
    int[] f1 = new int[N], f2 = new int[N], g = new int[N], p = new int[N];
    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Arrays.fill(he, -1);
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            add(a, b); add(b, a);
        }
        List<Integer> ans = new ArrayList<>();
        dfs1(0, -1);
        dfs2(0, -1);
        int min = n;
        for (int i = 0; i < n; i++) {
            int cur = Math.max(g[i], f1[i]);
            if (cur < min) {
                ans.clear();
                ans.add(i);
                min = cur;
            } else if (min == cur) {
                ans.add(i);
            }
        }
        return ans;

    }

    int dfs1(int u, int fa) {
        for (int i = he[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == fa) continue;
            int sub = dfs1(j, u) + 1;
            if (f1[u] < sub) {
                f2[u] = f1[u];
                f1[u] = sub;
                p[u] = j;
            } else if (f2[u] < sub) {
                f2[u] = sub;
            }
        }
        return f1[u];
    }
    void dfs2(int u, int fa) {
        for (int i = he[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == fa) continue;
            if (p[u] != j) g[j] = Math.max(g[j], f1[u] + 1);
            else g[j] = Math.max(g[j], f2[u] + 1);
            g[j] = Math.max(g[j], g[u] + 1);
            dfs2(j, u);
        }
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
