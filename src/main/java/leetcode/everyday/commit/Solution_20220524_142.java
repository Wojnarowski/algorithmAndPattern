package leetcode.everyday.commit;

import leetcode.everyday.ListNode;

/**
 * 142  环形链表 II
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 */


public class Solution_20220524_142 {


    /**
     * 总体思路 因为第一次相遇时，fast总的路程是slow总的路程加上n圈环。
     * 总fast=总slow+n圈环 也就是总fast=总slow+nb,而总fast的路程还是总slow路程的两倍,所以总fast=2总slow,所以两式得出总slow=nb,总fast=2nb。
     * 所以第一次相遇的时候slow就是已经走了nb，在这里n=1
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast =head;ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }


    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
