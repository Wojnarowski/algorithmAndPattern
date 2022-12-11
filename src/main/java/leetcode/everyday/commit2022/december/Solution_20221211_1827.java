package leetcode.everyday.commit2022.december;

import java.util.Arrays;

/**
 * 1827. 最少操作使数组递增
 *
 */
public class Solution_20221211_1827 {

    public int minOperations(int[] nums) {
        int pre = nums[0], ans = 0;
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + 1);
            ans += pre - nums[i];
        }
        return ans;
    }
}
