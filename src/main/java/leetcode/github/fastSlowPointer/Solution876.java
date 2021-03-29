package leetcode.github.fastSlowPointer;

import leetcode.everyday.ListNode;
import org.springframework.util.Assert;

/**
 *q_876 链表的中间结点
 *
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *  
 *
 * 示例 1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 *
 *
 *
 * 示例 2：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *  
 *
 * 提示：
 *
 * 给定链表的结点数介于 1 和 100 之间。
 *
 *
 */
public class Solution876 {

    public  static ListNode middleNode(ListNode head) {
        if(head ==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast!=null && fast.next!=null ){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        Assert.isTrue(middleNode(listNode1).val==3,"程序异常");
        System.out.println("------------------------");
//        ListNode listNode11 = new ListNode(1);
//        ListNode listNode12 = new ListNode(2);
//        ListNode listNode13 = new ListNode(3);
//        ListNode listNode14 = new ListNode(4);
//        ListNode listNode15 = new ListNode(5);
//        ListNode listNode16 = new ListNode(6);
//        listNode11.next=listNode12;
//        listNode12.next=listNode13;
//        listNode13.next=listNode14;
//        listNode14.next=listNode15;
//        listNode15.next=listNode16;
//        Assert.isTrue(middleNode(listNode11).val==4,"程序异常");


        System.out.println("-------------运行通过-------------");

    }
}
