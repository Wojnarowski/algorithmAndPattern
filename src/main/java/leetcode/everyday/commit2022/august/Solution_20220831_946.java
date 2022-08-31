package leetcode.everyday.commit2022.august;

import leetcode.everyday.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 946 验证栈序列
 *
 *
 *
 */
public class Solution_20220831_946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> d = new ArrayDeque<>();
        int n = pushed.length;
        for (int i = 0, j = 0; i < n; i++) {
            d.addLast(pushed[i]);
            while (!d.isEmpty() && d.peekLast() == popped[j] && ++j >= 0) d.pollLast();
        }
        return d.isEmpty();

    }
}
