package leetcode.everyday.commit2022.november;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1678. 设计 Goal 解析器
 *
 */
public class Solution_20221106_1678 {

    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int n = command.length();
        for (int i = 0; i < n; ) {
            if (command.charAt(i) == 'G') {
                sb.append('G'); i++;
            } else if (i + 1 < n && command.charAt(i + 1) == ')') {
                sb.append('o'); i += 2;
            } else {
                sb.append("al"); i += 4;
            }
        }
        return sb.toString();

    }
}
