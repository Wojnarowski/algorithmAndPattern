package leetcode.everyday.commit2022.december;

/**
 * 1759. 统计同构子字符串的数目
 *
 */
public class Solution_20221226_1759 {
    int mod = (int) 1e9 + 7;

    public int countHomogenous(String s) {
        char[] cs = s.toCharArray();
        long ans = 0;
        int l = 0, r = 0, len = cs.length;
        char c = ' ';
        while (r < len) {
            char cur = cs[r];
            if (cur != c) {
                c = cur;
                l = r;
            }
            ans += r - l + 1;
            ans %= mod;
            r++;
        }
        return (int) ans;
    }
}

