package leetcode.everyday.commit;

import leetcode.everyday.ListNode;

/**
 * 24  交换链表两个节点
 *
 */


public class Solution_20220519_141 {


    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode slow =head;
        ListNode fast =head;
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            if(fast.next != null) {
                fast=fast.next;
            }else{
                break;
            }
            if(fast==slow){
                return true;
            }
        }
        return false;




    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
