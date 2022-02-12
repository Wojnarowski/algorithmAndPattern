package leetcode.everyday.commit2022.february;

import java.util.Arrays;

/**
 * 1020  飞地的数量
 *
 * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 *
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 *
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 * 示例 2：
 *
 *
 * 输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * 输出：0
 * 解释：所有 1 都在边界上或可以到达边界。
 *  
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid[i][j] 的值为 0 或 1
 * 通过次数26,752提交次数44,503
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-enclaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 *
 */
public class Solution_20220212_1020 {

    int N = 550;
    int[] p = new int[N * N];
    int m, n;
    int[][] g;
    int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
    boolean query(int a, int b) {
        return find(a) == find(b);
    }
    void union(int a, int b) {
        p[find(a)] = find(b);
    }
    public int numEnclaves(int[][] grid) {
        g = grid;
        m = g.length; n = g[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                p[getIdx(i, j)] = getIdx(i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (g[i][j] != 1 || query(getIdx(i, j), 0)) continue;
                    dfs(i, j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 1 && !query(getIdx(i, j), 0)) ans++;
            }
        }
        return ans;
    }

    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    void dfs(int x, int y) {
        union(getIdx(x, y), 0);
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (g[nx][ny] != 1 || query(getIdx(nx, ny), 0)) continue;
            dfs(nx, ny);
        }
    }
    int getIdx(int x, int y) {
        return x * n + y + 1;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(reversePrefix("abcd",'z').equals("abcd"),"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
