package leetcode.everyday.commit2021.march;

import org.springframework.util.Assert;

/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 *
 *
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 *  
 *
 * 示例：
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *  
 *
 * 提示：
 *
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。
 * 通过次数42,998提交次数81,092
 *
 */


public class Solution_20210302_304 {

    /**
     * 思路一 纯遍历
     */
    static class NumMatrix {

        int[][] matrix=new int[][]{};
        public NumMatrix(int[][] matrix) {
            this.matrix=matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum =0;
            for(int i=row1;i<=row2;i++){
                for(int j=col1;j<=col2;j++){
                    sum+=matrix[i][j];
                }
            }
            return sum;
        }
    }

    /**
     * 思路二:二位数组前缀和
     */
    static class NumMatrix2 {

        int[][] sums=new int[][]{};
        public NumMatrix2(int[][] matrix) {
            int m=matrix.length;
            if(m>0){
                int n = matrix[0].length;
                sums = new int[m + 1][n + 1];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
        }
    }

    public static void main(String[] args) {
        int A[][] = new int[][] {{3, 0, 1, 4, 2},
                                {5, 6, 3, 2, 1},
                                {1, 2, 0, 1, 5},
                                {4, 1, 0, 1, 7},
                                {1, 0, 3, 0, 5}};
        System.out.println("-------------开始执行-------------");
        NumMatrix obj = new NumMatrix(A);
         int param_1 = obj.sumRegion(2, 1, 4, 3);
        Assert.isTrue(param_1==8,"程序异常");
        int param_2 = obj.sumRegion(1, 1, 2, 2);
        Assert.isTrue(param_2==11,"程序异常");
        int param_3 = obj.sumRegion(1, 2, 2, 4);
        Assert.isTrue(param_3==12,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
