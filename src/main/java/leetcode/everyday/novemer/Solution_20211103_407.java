package leetcode.everyday.novemer;

import java.util.PriorityQueue;

/**接雨水
 *
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 *
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 * 输出: 4
 * 解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。
 * 示例 2:
 *
 *
 *
 * 输入: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
 * 输出: 10
 *  
 *
 * 提示:
 *
 * m == heightMap.length
 * n == heightMap[i].length
 * 1 <= m, n <= 200
 * 0 <= heightMap[i][j] <= 2 * 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Solution_20211103_407 {

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->a[2]-b[2]);
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            q.add(new int[]{0, i, heightMap[0][i]});
            q.add(new int[]{m - 1, i, heightMap[m - 1][i]});
            vis[0][i] = vis[m - 1][i] = true;
        }
        for (int i = 1; i < m - 1; i++) {
            q.add(new int[]{i, 0, heightMap[i][0]});
            q.add(new int[]{i, n - 1, heightMap[i][n - 1]});
            vis[i][0] = vis[i][n - 1] = true;
        }
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int ans = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0], y = poll[1], h = poll[2];
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (vis[nx][ny]) continue;
                if (h > heightMap[nx][ny]) ans += h - heightMap[nx][ny];
                q.add(new int[]{nx, ny, Math.max(heightMap[nx][ny], h)});
                vis[nx][ny] = true;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{1,2,3,1};
        //Assert.isTrue(findPeakElement(array)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
