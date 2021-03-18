package leetcode.everyday;

import org.springframework.util.Assert;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 *
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *  
 *
 * 提示：
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *  
 *
 * 进阶： 你可以使用一趟扫描完成反转吗？
 *
 *
 */
public class Solution_20210318_92 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(left>right){
            return null;
        }
        ListNode dummyHead =new ListNode(0);
        dummyHead.next=head;
        ListNode preNode =dummyHead;

        //从dummy出发走left-1 步找到前继节点
        for(int i=0;i<left-1;i++){
            preNode=preNode.next;
        }
        //tail表示已经反转过的节点
        ListNode tail = preNode.next;
        //cur表示即将要反转的节点
        ListNode cur =tail.next;

        //左节点到右节点之间的元素进行翻转(头插，插到前继节点后面),头插的次数为right-left
        for(int i=0;i<right-left;i++){
            ListNode next=cur.next;
            cur.next=preNode.next;
            preNode.next=cur;
            tail.next=next;
            cur=next;
        }

        return dummyHead.next;
    }

    /**
     * 头插法
     * 思路：
     *  先将 curr 的下一个节点记录为 next；
     * 执行操作 ①：把 curr 的下一个节点指向 next 的下一个节点；
     * 执行操作 ②：把 next 的下一个节点指向 pre 的下一个节点；
     * 执行操作 ③：把 pre 的下一个节点指向 next。
     * 如 链表为 1->2->3->4->5   left 为2   right为4   即翻转2,3,4
     *    pre 为 1  cur为 2  next为 3
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        //设置dummy 哑节点
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode pre= dummy;

        //找到要开始翻转节点
        for(int i=0;i<left-1;i++){
            pre=pre.next;
        }

        //第一种写法  先定义好next  此时在循环里要将next赋值
//        ListNode cur=pre.next;
//        ListNode next =cur.next;
//        //left 到 right 间进行翻转
//        for(int i=0;i<right-left;i++){
//            cur.next=next.next;
//            next.next=pre.next;
//            pre.next=next;
//            next=cur.next;
//        }
        //第二种写法,每次循环的时候获取next值
        ListNode cur=pre.next;
        for(int i=0;i<right-left;i++){
            ListNode next =cur.next;
            cur.next=next.next;
            next.next=pre.next;
            pre.next=next;
        }

        return dummy.next;


    }



    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(numDistinct("rabbbit","rabbit")==3,"程序异常");
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        reverseBetween(listNode1,2,4);
        System.out.println("-------------运行通过-------------");


    }
}
