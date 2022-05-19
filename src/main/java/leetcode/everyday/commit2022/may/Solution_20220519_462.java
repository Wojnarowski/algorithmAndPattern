package leetcode.everyday.commit2022.may;

import java.util.Arrays;

/**
 * 462   最少移动次数使数组元素相等 II
 *
 *
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
 *
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：
 * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 示例 2：
 *
 * 输入：nums = [1,10,2,9]
 * 输出：16
 *  
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 通过次数20,763提交次数33,591
 *
 *
 *
 */


public class Solution_20220519_462 {


    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int ans = 0;
        while(left < right) {
            ans += nums[right] - nums[left];
            ++left;
            --right;
        }
        return ans;

    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
