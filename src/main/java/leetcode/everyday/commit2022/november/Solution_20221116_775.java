package leetcode.everyday.commit2022.november;

import java.util.Arrays;

/**
 * 775. 全局倒置与局部倒置
 *
 */
public class Solution_20221116_775 {
    public boolean isIdealPermutation(int[] nums) {
        int max = nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < max) return false;
            max = Math.max(max, nums[i - 1]);
        }
        return true;
    }
}
