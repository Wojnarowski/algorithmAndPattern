package leetcode.everyday.commit2022.november;

import java.util.Arrays;

/**
 * 891. 子序列宽度之和
 *
 */
public class Solution_20221118_891 {

    public int sumSubseqWidths(int[] nums) {
        int n = nums.length, et = n - 1, st = 0, mod =(int)(1e9 + 7);
        long[] pow = new long[n + 5];
        long ans = 0, last = 1;
        Arrays.sort(nums);
        for (int i = 0; i <= n; i++) {
            pow[i] = last - 1;
            last = last * 2 % mod;
        }
        for (int i = 0; i < n; i++, st++, et--)  ans = (ans + (pow[st] - pow[et]) * nums[i]) % mod;
        return (int) ans;

    }
}
