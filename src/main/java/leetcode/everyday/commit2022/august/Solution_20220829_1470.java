package leetcode.everyday.commit2022.august;

import leetcode.everyday.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1470 重新排列数组
 *
 *
 *
 */
public class Solution_20220829_1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0, j = n, k = 0; k < 2 * n; k++) {
            ans[k] = k % 2 == 0 ? nums[i++] : nums[j++];
        }
        return ans;
    }


}
