package leetcode.everyday.commit2022.september;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 1709. 第 k 个数
 *
 *
 *
 */
public class Solution_20220929_0909 {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

}
