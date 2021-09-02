package leetcode.everyday.september;

import org.springframework.util.ObjectUtils;

import java.util.Stack;

/**
 *q 22 链表中倒数第k个节点
 *
 *
 *输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 *  
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 * 通过次数221,600提交次数279,918
 *
 *
 */
public class Solution_20210902_22 {



      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


    public ListNode getKthFromEnd(ListNode head, int k) {
          if(ObjectUtils.isEmpty(head)){
              return null;
          }
          Stack<ListNode> stack = new Stack<ListNode>();
          while (head!=null){
              stack.push(head);
              head=head.next;
          }

          ListNode ans = new ListNode(0);
          for(int i=0;i<k;i++){
              ans=stack.pop();
          }
          return  ans;

    }



    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(judgeSquareSum(5)==true,"程序异常");
        System.out.println(2^2);
        System.out.println("-------------运行通过-------------");
    }
}
