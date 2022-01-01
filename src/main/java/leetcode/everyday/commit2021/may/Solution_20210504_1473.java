package leetcode.everyday.commit2021.may;

/**
 *q 1473 员粉刷房子 III
 *
 * 在一个小城市里，有 m 个房子排成一排，你需要给每个房子涂上 n 种颜色之一（颜色编号为 1 到 n ）。有的房子去年夏天已经涂过颜色了，所以这些房子不需要被重新涂色。
 *
 * 我们将连续相同颜色尽可能多的房子称为一个街区。（比方说 houses = [1,2,2,3,3,2,1,1] ，它包含 5 个街区  [{1}, {2,2}, {3,3}, {2}, {1,1}] 。）
 *
 * 给你一个数组 houses ，一个 m * n 的矩阵 cost 和一个整数 target ，其中：
 *
 * houses[i]：是第 i 个房子的颜色，0 表示这个房子还没有被涂色。
 * cost[i][j]：是将第 i 个房子涂成颜色 j+1 的花费。
 * 请你返回房子涂色方案的最小总花费，使得每个房子都被涂色后，恰好组成 target 个街区。如果没有可用的涂色方案，请返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
 * 输出：9
 * 解释：房子涂色方案为 [1,2,2,1,1]
 * 此方案包含 target = 3 个街区，分别是 [{1}, {2,2}, {1,1}]。
 * 涂色的总花费为 (1 + 1 + 1 + 1 + 5) = 9。
 * 示例 2：
 *
 * 输入：houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
 * 输出：11
 * 解释：有的房子已经被涂色了，在此基础上涂色方案为 [2,2,1,2,2]
 * 此方案包含 target = 3 个街区，分别是 [{2,2}, {1}, {2,2}]。
 * 给第一个和最后一个房子涂色的花费为 (10 + 1) = 11。
 * 示例 3：
 *
 * 输入：houses = [0,0,0,0,0], cost = [[1,10],[10,1],[1,10],[10,1],[1,10]], m = 5, n = 2, target = 5
 * 输出：5
 * 示例 4：
 *
 * 输入：houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4, n = 3, target = 3
 * 输出：-1
 * 解释：房子已经被涂色并组成了 4 个街区，分别是 [{3},{1},{2},{3}] ，无法形成 target = 3 个街区。
 *  
 *
 * 提示：
 *
 * m == houses.length == cost.length
 * n == cost[i].length
 * 1 <= m <= 100
 * 1 <= n <= 20
 * 1 <= target <= m
 * 0 <= houses[i] <= n
 * 1 <= cost[i][j] <= 10^4
 * 通过次数3,172提交次数5,789
 * 请问您在哪类招聘中遇到此题？
 *
 *
 *
 *  
 */
public class Solution_20210504_1473 {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {

        //第i个房子，街区数为j,颜色为k,的最小花费
        int[][][] dp = new int[m + 1][target + 1][n];

        for (int i = 1; i <= m; i++) {
            int color = houses[i - 1] - 1;
            boolean colored = color >= 0;

            for (int j = 1; j <= target && j <= i; j++) {
                for (int k = 0; k < n; k++) {
                    if (colored && k != color) {
                        dp[i][j][k] = -1;
                        continue;
                    }
                    int costt = (colored && k == color) ? 0 : cost[i - 1][k];
                    if (j == 1) {
                        if (dp[i - 1][j][k] < 0) {
                            dp[i][j][k] = -1;
                        } else {
                            dp[i][j][k] = dp[i - 1][j][k] + costt;
                        }

                    } else {
                        int minCost = Integer.MAX_VALUE;
                        for (int k2 = 0; k2 < n; k2++) {
                            if (k2 != k) {
                                if (dp[i - 1][j - 1][k2] >= 0) {
                                    minCost = Math.min(dp[i - 1][j - 1][k2], minCost);
                                }
                            } else if (j <= i - 1) {
                                if (dp[i - 1][j][k2] >= 0) {
                                    minCost = Math.min(dp[i - 1][j][k2], minCost);
                                }
                            }
                        }
                        if (minCost == Integer.MAX_VALUE) {
                            dp[i][j][k] = -1;
                        } else {
                            dp[i][j][k] = minCost + costt;
                        }
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            if (dp[m][target][k] >= 0) {
                ans = Math.min(dp[m][target][k], ans);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;


    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(judgeSquareSum(5)==true,"程序异常");
        System.out.println(2^2);
        System.out.println("-------------运行通过-------------");
    }
}
