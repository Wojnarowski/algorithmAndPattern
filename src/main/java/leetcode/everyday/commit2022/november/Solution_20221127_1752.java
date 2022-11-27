package leetcode.everyday.commit2022.november;

import java.util.Arrays;

/**
 * 1752. 检查数组是否经排序和轮转得到
 *
 */
public class Solution_20221127_1752 {

    public boolean check(int[] nums) {
        int n = nums.length, cnt = 0;
        for (int i = 0, cur = 110; i < n; ) {
            int j = i;
            while (j + 1 < n && nums[j] <= nums[j + 1]) {
                if (nums[j++] > cur) return false;
            }
            if (nums[j] > cur) return false;
            cur = Math.min(cur, nums[i]);
            i = j + 1; cnt++;
        }
        return cnt <= 2;
    }
}
