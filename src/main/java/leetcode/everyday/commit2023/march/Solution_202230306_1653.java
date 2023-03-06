package leetcode.everyday.commit2023.march;

/**
 * 2351. 第一个出现两次的字母
 */
public class Solution_202230306_1653 {

    public int minimumDeletions(String s) {
        int f = 0, cntB = 0;
        for (char c : s.toCharArray())
            if (c == 'b') ++cntB; // f 值不变
            else f = Math.min(f + 1, cntB);
        return f;
    }
}
