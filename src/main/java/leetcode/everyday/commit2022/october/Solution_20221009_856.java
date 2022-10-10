package leetcode.everyday.commit2022.october;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 856. 括号的分数
 *
 *
 */
public class Solution_20221009_856 {

    public int scoreOfParentheses(String s) {
        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(0);
        for (char c : s.toCharArray()) {
            if (c == '(') d.addLast(0);
            else {
                int cur = d.pollLast();
                d.addLast(d.pollLast() + Math.max(cur * 2 , 1));
            }
        }
        return d.peekLast();
    }
}
