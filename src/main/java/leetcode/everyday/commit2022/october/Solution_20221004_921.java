package leetcode.everyday.commit2022.october;

/**
 *921. 使括号有效的最少添加
 *
 *
 */
public class Solution_20221004_921 {

    public int minAddToMakeValid(String s) {
        int score = 0, ans = 0;
        for (char c : s.toCharArray()) {
            score += c == '(' ? 1 : -1;
            if (score < 0) {
                score = 0; ans++;
            }
        }
        return ans + score;

    }
}
