package leetcode.everyday.commit2023.january;

import java.util.*;

/**
 * 1819. 序列中不同最大公约数的数目
 */
public class Solution_202230117_1814 {
    final static int MOD = (int) (1e9 + 7);
    public int countNicePairs(int[] nums) {
        long total = 0;
        Map<Integer, Long> map = new HashMap<>();
        for (int num : nums) {
            int key = num - rev(num);
            map.put(key, map.getOrDefault(key, 0L) + 1);
        }
        for (long val : map.values()) total += val * (val - 1) / 2;
        return (int)(total % MOD);
    }

    private int rev(int num) {
        int revNum = 0;
        while (num > 0) {
            revNum = (revNum * 10 + num % 10);
            num /= 10;
        }
        return revNum;
    }
}
