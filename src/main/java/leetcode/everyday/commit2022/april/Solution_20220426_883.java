package leetcode.everyday.commit2022.april;

import java.util.Random;

/**
 * 883   三维形体投影面积
 *
 * 在 n x n 的网格 grid 中，我们放置了一些与 x，y，z 三轴对齐的 1 x 1 x 1 立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 *
 * 现在，我们查看这些立方体在 xy 、yz 和 zx 平面上的投影。
 *
 * 投影 就像影子，将 三维 形体映射到一个 二维 平面上。从顶部、前面和侧面看立方体时，我们会看到“影子”。
 *
 * 返回 所有三个投影的总面积 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[1,2],[3,4]]
 * 输出：17
 * 解释：这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。
 * 示例 2:
 *
 * 输入：grid = [[2]]
 * 输出：5
 * 示例 3：
 *
 * 输入：[[1,0],[0,2]]
 * 输出：8
 *  
 *
 * 提示：
 *
 * n == grid.length == grid[i].length
 * 1 <= n <= 50
 * 0 <= grid[i][j] <= 50
 * 通过次数37,644提交次数49,350
 * 请问您在哪类招聘中遇到此题？
 *
 *
 *
 */
public class Solution_20220426_883 {
    public int projectionArea(int[][] grid) {
        int ans1 = 0, ans2 = 0, ans3 = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int a = 0, b = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) ans1++;
                a = Math.max(a, grid[i][j]);
                b = Math.max(b, grid[j][i]);
            }
            ans2 += a; ans3 += b;
        }
        return ans1 + ans2 + ans3;

    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
