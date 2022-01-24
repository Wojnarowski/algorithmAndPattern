package leetcode.everyday.commit2022.january;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 2045  到达目的地的第二短时间
 *
 * 城市用一个 双向连通 图表示，图中有 n 个节点，从 1 到 n 编号（包含 1 和 n）。图中的边用一个二维整数数组 edges 表示，其中每个 edges[i] = [ui, vi] 表示一条节点 ui 和节点 vi 之间的双向连通边。每组节点对由 最多一条 边连通，顶点不存在连接到自身的边。穿过任意一条边的时间是 time 分钟。
 *
 * 每个节点都有一个交通信号灯，每 change 分钟改变一次，从绿色变成红色，再由红色变成绿色，循环往复。所有信号灯都 同时 改变。你可以在 任何时候 进入某个节点，但是 只能 在节点 信号灯是绿色时 才能离开。如果信号灯是  绿色 ，你 不能 在节点等待，必须离开。
 *
 * 第二小的值 是 严格大于 最小值的所有值中最小的值。
 *
 * 例如，[2, 3, 4] 中第二小的值是 3 ，而 [2, 2, 4] 中第二小的值是 4 。
 * 给你 n、edges、time 和 change ，返回从节点 1 到节点 n 需要的 第二短时间 。
 *
 * 注意：
 *
 * 你可以 任意次 穿过任意顶点，包括 1 和 n 。
 * 你可以假设在 启程时 ，所有信号灯刚刚变成 绿色 。
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 5, edges = [[1,2],[1,3],[1,4],[3,4],[4,5]], time = 3, change = 5
 * 输出：13
 * 解释：
 * 上面的左图展现了给出的城市交通图。
 * 右图中的蓝色路径是最短时间路径。
 * 花费的时间是：
 * - 从节点 1 开始，总花费时间=0
 * - 1 -> 4：3 分钟，总花费时间=3
 * - 4 -> 5：3 分钟，总花费时间=6
 * 因此需要的最小时间是 6 分钟。
 *
 * 右图中的红色路径是第二短时间路径。
 * - 从节点 1 开始，总花费时间=0
 * - 1 -> 3：3 分钟，总花费时间=3
 * - 3 -> 4：3 分钟，总花费时间=6
 * - 在节点 4 等待 4 分钟，总花费时间=10
 * - 4 -> 5：3 分钟，总花费时间=13
 * 因此第二短时间是 13 分钟。
 * 示例 2：
 *
 *
 *
 * 输入：n = 2, edges = [[1,2]], time = 3, change = 2
 * 输出：11
 * 解释：
 * 最短时间路径是 1 -> 2 ，总花费时间 = 3 分钟
 * 最短时间路径是 1 -> 2 -> 1 -> 2 ，总花费时间 = 11 分钟
 *  
 *
 * 提示：
 *
 * 2 <= n <= 104
 * n - 1 <= edges.length <= min(2 * 104, n * (n - 1) / 2)
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * ui != vi
 * 不含重复边
 * 每个节点都可以从其他节点直接或者间接到达
 * 1 <= time, change <= 103
 * 通过次数12,601提交次数23,733
 * 请问您在哪类招聘中遇到此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-time-to-reach-destination
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Solution_20220124_2045 {

    static int N = 10010, M = 4 * N, INF = 0x3f3f3f3f, idx = 0;
    static int[] he = new int[N], e = new int[M], ne = new int[M];
    static int[] dist1 = new int[N], dist2 = new int[N];
    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        idx++;
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Arrays.fill(dist1, INF);
        Arrays.fill(dist2, INF);
        Arrays.fill(he, -1);
        idx = 0;
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            add(u, v); add(v, u);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->a[1]-b[1]);
        q.add(new int[]{1, 0});
        dist1[1] = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int u = poll[0], step = poll[1];
            for (int i = he[u]; i != -1; i = ne[i]) {
                int j = e[i];
                int a = step / change, b = step % change;
                int wait = a % 2 == 0 ? 0 : change - b;
                int dist = step + time + wait;
                if (dist1[j] > dist) {
                    dist2[j] = dist1[j];
                    dist1[j] = dist;
                    q.add(new int[]{j, dist1[j]});
                    q.add(new int[]{j, dist2[j]});
                } else if (dist1[j] < dist && dist < dist2[j]) {
                    dist2[j] = dist;
                    q.add(new int[]{j, dist2[j]});
                }
            }
        }
        return dist2[n];

    }
    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
