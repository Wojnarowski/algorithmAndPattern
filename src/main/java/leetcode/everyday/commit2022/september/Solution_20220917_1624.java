package leetcode.everyday.commit2022.september;

import java.util.Arrays;

/**
 * 1624     两个相同字符之间的最长子字符串
 *
 *
 *
 */
public class Solution_20220917_1624 {

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] idxs = new int[26];
        Arrays.fill(idxs, 310);
        int n = s.length(), ans = -1;
        for (int i = 0; i < n; i++) {
            int u = s.charAt(i) - 'a';
            idxs[u] = Math.min(idxs[u], i);
            ans = Math.max(ans, i - idxs[u] - 1);
        }
        return ans;
    }
}
