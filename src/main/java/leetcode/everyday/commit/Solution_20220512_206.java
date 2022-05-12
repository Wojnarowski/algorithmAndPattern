package leetcode.everyday.commit;

import leetcode.everyday.ListNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 206 翻转链表
 *
 */


public class Solution_20220512_206 {


    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return  head;
        }
        ListNode cur = head.next; // 当前节点
        ListNode pre = head; // 当前节点的前驱节点
        while(cur!=null){
            ListNode next =cur.next;  // 当前节点的后驱节点
            cur.next=head; // 当前节点的后驱节点指向头节点
            pre.next=next;  // 当前节点的前驱节点的后驱节点指向当前节点的后驱节点
            head=cur; // 头节点为当前节点
            cur=next;  // 处理完，当前节点为原节点的后驱节点
        }
        return head;
    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
