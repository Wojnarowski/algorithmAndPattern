package leetcode.everyday.march;

import java.util.List;
import java.util.Stack;

/**
 *
 * q_82  删除排序链表中的重复元素 II
 *存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 *
 *
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *  
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 *
 *
 */
public class Solution_20210325_82 {



      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }

          @Override
          public String toString() {
              return "ListNode{" +
                      "val=" + val +
                      ", next=" + next +
                      '}';
          }
      }

    public static ListNode deleteDuplicates(ListNode head) {

          if(head==null){
              return null;
          }
          ListNode dummy =new ListNode(-1);
          dummy.next=head;


          ListNode cur =dummy;
          while(cur.next!=null && cur.next.next!=null){
              if(cur.next.val==cur.next.next.val){
                  int x = cur.next.val;
                  while (cur.next != null && cur.next.val == x) {
                      cur.next = cur.next.next;
                  }

              }
              else{
                  cur=cur.next;
              }
          }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"})==22,"程序异常");
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(6);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        listNode5.next=listNode6;
        listNode6.next=listNode7;

//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(1);
//        ListNode listNode3 = new ListNode(1);
//        ListNode listNode4 = new ListNode(2);
//        ListNode listNode5 = new ListNode(3);
//        listNode1.next=listNode2;
//        listNode2.next=listNode3;
//        listNode3.next=listNode4;
//        listNode4.next=listNode5;
        ListNode result = deleteDuplicates(listNode1);
        System.out.println(result.toString());
        System.out.println("-------------运行通过-------------");
    }
}
