package leetcode.everyday.commit2022.november;

/**
 * 813. 最大平均值和的分组
 *
 */
public class Solution_20221128_813 {

    public double largestSumOfAverages(int[] nums, int k) {
        double[][] dp = new double[nums.length+1][k+1];
        double [] preSum = new double[nums.length+1];
        for(int i=0;i<nums.length;i++){
            preSum[i+1]= preSum[i]+nums[i];
            dp[i+1][1] = preSum[i+1]/(i+1);//初始化
        }
        for(int i=1;i<=nums.length;i++){
            for(int j=2;j<=Math.min(k, i);j++){
                //dp[i][j]的最大均值 应该是 dp[i'][j-1]的均值+i'-i的均值和  中所有的可能中的最大值
                for(int t = 0;t<i;t++){
                    dp[i][j] = Math.max(dp[i][j], dp[t][j-1]+(preSum[i]-preSum[t])/(i-t));
                }
            }
        }
        return dp[nums.length][k];
    }
}
