package leetcode.everyday.commit2023.january;

import java.util.*;

/**
 * 2351. 第一个出现两次的字母
 */
public class Solution_202230101_2351 {

    public char repeatedCharacter(String s) {
        Set<Character> seen = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!seen.add(ch)) {
                return ch;
            }
        }
        return ' ';
    }
}
