package leetcode.everyday.commit2023.january;

import java.util.Arrays;

/**
 * 1819. 序列中不同最大公约数的数目
 */
public class Solution_202230115_2293 {

    public int minMaxGame(int[] nums) {
        for (int n = nums.length; n > 1;) {
            n >>= 1;
            for (int i = 0; i < n; ++i) {
                int a = nums[i << 1], b = nums[i << 1 | 1];
                nums[i] = i % 2 == 0 ? Math.min(a, b) : Math.max(a, b);
            }
        }
        return nums[0];
    }

}
