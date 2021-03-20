package leetcode.github.slidwindow;

import org.springframework.util.Assert;

/**
 *q_209. 长度最小的子数组
 *给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 *
 *  
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 *
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *  
 *
 * 进阶：
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 *
 */
public class Solution209 {

    /**
     * 滑动窗口
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        // window [start...end]
        int start=0;
        int sum=0;
        int end =0;
        int result =Integer.MAX_VALUE;
        while(end<nums.length){
            sum+=nums[end];
            while(sum>=target){
                result=Math.min(result,end-start+1);
                sum-=nums[start];
                start++;
            }
            end++;
        }
        return result==Integer.MAX_VALUE?0:result;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(minSubArrayLen(7,new int[]{2,3,1,2,4,3})==2,"程序异常");
        Assert.isTrue(minSubArrayLen(4,new int[]{1,4,4})==1,"程序异常");
        Assert.isTrue(minSubArrayLen(11,new int[]{1,1,1,1,1,1,1,1})==0,"程序异常");

        System.out.println("-------------运行通过-------------");
    }
}
