package leetcode.everyday.commit2023.january;

import leetcode.everyday.ListNode;

/**
 * 1669. 合并两个链表
 */
public class Solution_202230130_1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0, list1);
        ListNode pre = dummy, cur = list1;
        // 获取下标`a`的前一个节点pre
        for (int i = 0; i < a; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        ListNode nxt = cur.next;
        // 获取下标`b`的后一个节点**nxt**
        for (int i = 0; i < b - a; i++) nxt = nxt.next;
        // 获取list2的尾结点
        cur = list2;
        while (cur.next != null) cur = cur.next;
        // 拼凑两个链表
        pre.next = list2;
        cur.next = nxt;
        return dummy.next;
    }
}
