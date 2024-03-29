package leetcode.everyday.commit2021.april;

import org.springframework.util.Assert;

import java.util.Arrays;

/**
 *q 213  打家劫舍 II
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 *  示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 *
 *
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 *
 */
public class Solution_20210415_213 {

    public static int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        /**
         * 偷第1家了就不能偷最后一家，否则第二家到最后一家
         */
        return Math.max(robInner(Arrays.copyOfRange(nums,0,nums.length-1)),robInner(Arrays.copyOfRange(nums,1,nums.length)));


    }

    private static int robInner(int[] nums) {
        int []dp = new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<nums.length+1;i++){
            dp[i]=Math.max(dp[i-2]+nums[i-1],dp[i-1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(rob(new int[]{2,3,2})==3,"程序异常");
        Assert.isTrue(rob(new int[]{1,2,3,1})==4,"程序异常");
        Assert.isTrue(rob(new int[]{0})==0,"程序异常");

        System.out.println("-------------运行通过-------------");
    }
}
