package leetcode.everyday.march;

/**
 *
 * q_83  删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 *
 *  
 *
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 *
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *  
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 * 通过次数223,982提交次数419,389
 *
 *
 *
 *
 */
public class Solution_20210326_83 {



    public static ListNode deleteDuplicates(ListNode head) {

        if(head.next==null){
            return head;
        }

        ListNode dummy = new ListNode(-1);

        dummy.next=head;

        ListNode cur=head;
        while(cur.next!=null){
           int x = cur.val;
           if(x ==cur.next.val){
               cur.next=cur.next.next;
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
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(3);

        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;



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
