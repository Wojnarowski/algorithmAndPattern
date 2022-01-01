package leetcode.everyday.commit2021.april;

/**
 *q 363 矩形区域不超过 K 的最大数值和
 *
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 *
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出：2
 * 解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * 示例 2：
 *
 * 输入：matrix = [[2,2,-1]], k = 3
 * 输出：3
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -105 <= k <= 105
 *  
 *
 * 进阶：如果行数远大于列数，该如何设计解决方案？
 *
 */
public class Solution_20210422_363 {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int row = matrix.length;
        int col = matrix[0].length;

        int res = Integer.MIN_VALUE;

        // 固定左右边界
        for (int i = 0; i < col; i++) {// 枚举左边界
            int[] sum = new int[row];
            for (int j = i; j < col; j++) {// 枚举右边界
                // 只针对行进行求和
                for (int r = 0; r < row; r++) {
                    sum[r] += matrix[r][j];
                }

                int dp = 0;
                int max = sum[0];
                for (int n : sum) {
                    // 之前的和都比现在的小了，那还要干嘛
                    dp = Math.max(n, dp + n);
                    // 更新max
                    max = Math.max(dp, max);
                    // 如果发现最大的已经为k了，直接返回k
                    if (max == k)
                        return max;
                }

                if (max < k) {
                    res = Math.max(max, res);
                }
                else {
                    for (int a = 0; a < row; a++) {
                        int currSum = 0;
                        for (int b = a; b < row; b++) {
                            currSum += sum[b];
                            if (currSum <= k)
                                res = Math.max(currSum, res);
                        }
                    }
                    // 如果发现最大的已经为k了，直接返回k
                    if (res == k) return res;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(numDecodings("12")==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
