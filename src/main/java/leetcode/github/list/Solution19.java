package leetcode.github.list;

import java.util.Stack;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 */


public class Solution19 {

    /**
     * 思路
     *  1.放入stackA中，挨个弹出放入另一个stackB中(将下标为n-1 的不让入stackB);弹出stackB组成新链表
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        Stack stackA = new Stack();
        Stack stackB = new Stack();
        ListNode result=head;

        while(head!=null){
            stackA.push(head.val);
            head=head.next;
        }

        int count =0;
        while(!stackA.isEmpty()){
            if(count!=n-1){
                int val = (int) stackA.pop();
                stackB.push(val);
            }else{
                stackA.pop();
            }
            count++;
        }

        for(int i=stackB.size()-1;i>=0;i--){
            int val = (int) stackB.get(i);
            head=head==null?new ListNode():head;
            head.val=val;
            if(i==0){
                result=head;
            }
            head.next=new ListNode();
            head=head.next;

        }
//        while (!stackB.isEmpty()){
//            int val = (int) stackB.pop();
//            head=head==null?new ListNode():head;
//            head.val=val;
//            head.next=new ListNode();
//            head=head.next;
//        }

        return result;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;

    }

    /**
     * 快慢指针
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode first = dummy;
        ListNode second= dummy;

        for(int i=0;i<=n;i++){
            first=first.next;
        }
        while (first!=null){
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        return dummy.next;

    }

    public static void main(String[] args) {

        ListNode listNode11 = new ListNode(2);
        ListNode listNode12 = new ListNode(4);
        ListNode listNode13 = new ListNode(3);
        listNode11.next=listNode12;
        listNode12.next=listNode13;




        //ListNode result =removeNthFromEnd1(listNode11,2);
        ListNode result2 =removeNthFromEnd3(listNode11,2);
        System.out.println(result2);


    }
}
