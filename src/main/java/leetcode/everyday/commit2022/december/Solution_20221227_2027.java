package leetcode.everyday.commit2022.december;

/**
 * 2027. 转换字符串的最少操作次数
 *
 */
public class Solution_20221227_2027 {

    public int minimumMoves(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'X') {
                ++ans;
                i += 2;
            }
        }
        return ans;
    }
}

