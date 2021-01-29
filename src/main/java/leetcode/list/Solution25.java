package leetcode.list;

import java.util.Stack;

/**
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 */


public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<2){
            return head;
        }

        ListNode hair =new ListNode(0);
        hair.next=head;

        ListNode pre=hair;
        ListNode end=hair;




    }



    public static void main(String[] args) {

        ListNode listNode11 = new ListNode(2);
        ListNode listNode12 = new ListNode(4);
        ListNode listNode13 = new ListNode(3);
        listNode11.next=listNode12;
        listNode12.next=listNode13;



    }
}
