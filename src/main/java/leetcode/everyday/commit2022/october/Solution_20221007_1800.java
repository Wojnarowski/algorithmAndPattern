package leetcode.everyday.commit2022.october;

/**
 * 1800. 最大升序子数组和
 *
 *
 */
public class Solution_20221007_1800 {

    public int maxAscendingSum(int[] nums) {
        int n = nums.length, ans = nums[0];
        for (int i = 1, cur = nums[0]; i < n; i++) {
            if (nums[i] > nums[i - 1]) cur += nums[i];
            else cur = nums[i];
            ans = Math.max(ans, cur);
        }
        return ans;

    }
}
