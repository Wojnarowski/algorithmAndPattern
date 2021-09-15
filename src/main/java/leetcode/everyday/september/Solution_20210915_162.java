package leetcode.everyday.september;

import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;

/**
 *q 162   寻找峰值
 *
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2：
 *
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 *
 *
 */
public class Solution_20210915_162 {


    /**
     * 线性O(N)
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            boolean ok = true;
            if (i - 1 >= 0) {
                if (nums[i - 1] >= nums[i]) ok = false;
            }
            if (i + 1 < n) {
                if (nums[i + 1] >= nums[i]) ok = false;
            }
            if (ok) return i;
        }

        return -1;
    }

    /**
     * 快慢指针
     * @param nums
     * @return
     */
    public static int findPeakElement2(int[] nums) {
        int slow=0,fast=slow+1;
        while (fast<nums.length){
            if (nums[fast]>nums[slow]){
                slow++;
                fast++;
            }else {
                return slow;
            }
        }
        return slow;
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{1,2,3,1};
        Assert.isTrue(findPeakElement(array)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
