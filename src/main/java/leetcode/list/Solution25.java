package leetcode.list;

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

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k<2){
            return head;
        }

        ListNode hair =new ListNode(0);
        hair.next=head;

        ListNode pre=hair;
        ListNode end=hair;

        while(end.next!=null){
            for(int i=0;i<k&&end!=null;i++){
                end=end.next;
            }
            if(end == null){
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next=null;
            pre.next=reverse(start);
            start.next=next;
            pre=start;
            end =pre;
        }
        return hair.next;

    }

    public static ListNode reverse(ListNode head){
        ListNode pre =null;
        ListNode cur = head;
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

        ListNode result = reverseKGroup(listNode11,2);
        System.out.println(result);

    }
}
