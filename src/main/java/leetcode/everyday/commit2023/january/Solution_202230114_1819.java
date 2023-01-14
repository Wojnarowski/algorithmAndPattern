package leetcode.everyday.commit2023.january;

import java.util.Arrays;

/**
 * 1819. 序列中不同最大公约数的数目
 */
public class Solution_202230114_1819 {

    public int countDifferentSubsequenceGCDs(int[] nums) {
        int maxVal = Arrays.stream(nums).max().getAsInt();
        boolean[] occurred = new boolean[maxVal + 1];
        for (int num : nums) {
            occurred[num] = true;
        }
        int count = 0;
        for (int i = 1; i <= maxVal; i++) {
            int divisor = 0;
            for (int j = i; j <= maxVal && divisor != i; j += i) {
                if (occurred[j]) {
                    divisor = gcd(divisor, j);
                }
            }
            if (divisor == i) {
                count++;
            }
        }
        return count;

    }
    private int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }

}
