package leetcode.everyday.commit2023.january;

import java.util.*;

/**
 * 1663. 具有给定数值的最小字符串
 */
public class Solution_202230127_2309 {
    public String greatestLetter(String s) {
        Set<Character> ss = new HashSet<>();
        for (char c : s.toCharArray()) {
            ss.add(c);
        }
        for (char a = 'Z'; a >= 'A'; --a) {
            if (ss.contains(a) && ss.contains((char) (a + 32))) {
                return String.valueOf(a);
            }
        }
        return "";
    }

}
