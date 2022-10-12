package leetcode.everyday.commit2022.october;

import leetcode.everyday.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. 链表组件
 *
 */
public class Solution_20221012_817 {

    public int numComponents(ListNode head, int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        while (head != null) {
            if (set.contains(head.val)) {
                while (head != null && set.contains(head.val)) head = head.next;
                ans++;
            } else {
                head = head.next;
            }
        }
        return ans;
    }
}
