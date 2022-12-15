package leetcode.everyday.commit2022.december;

import java.util.Arrays;

/**
 * 1945. 字符串转化后的各位数字之和
 *
 */
public class Solution_20221215_1945 {
    public int getLucky(String s, int k) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a' + 1;
            while (cur > 0) {
                num += cur % 10;
                cur /= 10;
            }
        }
        while (--k > 0) {
            int cur = 0;
            while (num > 0) {
                cur += num % 10;
                num /= 10;
            }
            num = cur;
        }
        return num;
    }
}

