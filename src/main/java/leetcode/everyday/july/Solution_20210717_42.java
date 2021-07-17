package leetcode.everyday.july;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 *
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *  
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 *
 *
 *
 */
public class Solution_20210717_42 {

    /**
     * 思路 动态规划
     *  f[i]=max(nums[i],f[i−1]+nums[i])
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        dp[0]=nums[0];
        int ans =dp[0];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(nums[i],dp[n-1]=nums[i]);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(majorityElement(new int[]{1,2,5,9,5,9,5,5,5})==5,"程序异常");
        //Assert.isTrue(majorityElement(new int[]{3,2})==-1,"程序异常");

        System.out.println("-------------运行通过-------------");
    }
}
