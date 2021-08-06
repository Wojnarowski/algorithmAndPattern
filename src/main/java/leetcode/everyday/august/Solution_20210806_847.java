package leetcode.everyday.august;

import java.util.*;


/**
 * 847 访问所有节点的最短路径
 *
 * 存在一个由 n 个节点组成的无向连通图，图中的节点按从 0 到 n - 1 编号。
 *
 * 给你一个数组 graph 表示这个图。其中，graph[i] 是一个列表，由所有与节点 i 直接相连的节点组成。
 *
 * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：graph = [[1,2,3],[0],[0],[0]]
 * 输出：4
 * 解释：一种可能的路径为 [1,0,2,0,3]
 * 示例 2：
 *
 *
 *
 * 输入：graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
 * 输出：4
 * 解释：一种可能的路径为 [0,1,4,2,3]
 *  
 *
 * 提示：
 *
 * n == graph.length
 * 1 <= n <= 12
 * 0 <= graph[i].length < n
 * graph[i] 不包含 i
 * 如果 graph[a] 包含 b ，那么 graph[b] 也包含 a
 * 输入的图总是连通图
 * 通过次数11,001提交次数17,000
 *
 *
 */


public class Solution_20210806_847 {

    int INF = 0x3f3f3f3f;
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int mask = 1 << n;

        // 初始化所有的 (state, u) 距离为正无穷
        int[][] dist = new int[mask][n];
        for (int i = 0; i < mask; i++) Arrays.fill(dist[i], INF);

        // 因为可以从任意起点出发，先将起始的起点状态入队，并设起点距离为 0
        Deque<int[]> d = new ArrayDeque<>(); // state, u
        for (int i = 0; i < n; i++) {
            dist[1 << i][i] = 0;
            d.addLast(new int[]{1 << i, i});
        }

        // BFS 过程，如果从点 u 能够到达点 i，则更新距离并进行入队
        while (!d.isEmpty()) {
            int[] poll = d.pollFirst();
            int state = poll[0], u = poll[1], step = dist[state][u];
            if (state == mask - 1) return step;
            for (int i : graph[u]) {
                if (dist[state | (1 << i)][i] == INF) {
                    dist[state | (1 << i)][i] = step + 1;
                    d.addLast(new int[]{state | (1 << i), i});
                }
            }
        }
        return -1; // never
    }
    public static void main(String[] args) {
        int [] arr = new int[]{2,2,3,4};

        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(triangleNumber1(arr)==3,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
