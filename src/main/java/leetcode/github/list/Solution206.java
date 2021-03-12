package leetcode.github.list;

/**
 *
 *反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 图文讲解
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-a7rx/
 *
 */


public class Solution206 {



    public static ListNode reverse(ListNode head){
//        ListNode pre =null;
//        ListNode cur = head;
//        while(cur!=null){
//            ListNode next = cur.next;
//            cur.next=pre;
//            pre=cur;
//            cur=next;
//        }
//        return pre;
        ListNode pre =null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;

    }



    public static void main(String[] args) {

        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(3);
        ListNode listNode14 = new ListNode(4);
        ListNode listNode15 = new ListNode(5);
        listNode11.next=listNode12;
        listNode12.next=listNode13;
        listNode13.next=listNode14;
        listNode14.next=listNode15;
        System.out.println(reverse(listNode11));


    }
}
