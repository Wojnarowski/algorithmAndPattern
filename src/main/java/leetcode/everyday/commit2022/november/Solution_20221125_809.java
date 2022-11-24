package leetcode.everyday.commit2022.november;

import java.util.*;

/**
 * 809. 情感丰富的文字
 *
 */
public class Solution_20221125_809 {


    public int expressiveWords(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0) return 0;
        int cnt = 0;
        for (String word : words) {
            if (isStrechy(s, word)) cnt++;
        }
        return cnt;
    }
    // 判断 t 是否可以扩张成 s
    private boolean isStrechy(String s, String t) {
        int n = s.length(), m = t.length();
        if (n < m) return false;
        int i = 0, j = 0;
        while (i < n && j < m) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(j);  // 优化：可以在这之后直接判断字符是否相等。

            // c1几个
            int cnt1 = 0;
            while (i < n && s.charAt(i) == c1) {
                i++;
                cnt1++;
            }

            // c2几个
            int cnt2 = 0;
            while (j < m && t.charAt(j) == c2) {
                j++;
                cnt2++;
            }
            /** 3 种无法扩张的情况
             1. c1, c2 不同
             2. c2, c2 长度不同，而且 c1 长度只有 2，无法被扩张
             3. c2 长度 > c1 长度
             **/
            if (c1 != c2 || cnt1 < cnt2 || cnt1 <= 2 && cnt1 != cnt2) return false;

        }
        // 判断 s, t 都走完了吗？
        return i == s.length() && j == t.length();
    }
}
