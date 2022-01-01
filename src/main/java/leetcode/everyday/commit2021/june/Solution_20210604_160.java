package leetcode.everyday.commit2021.june;

import leetcode.everyday.ListNode;
import org.springframework.util.Assert;

/**
 *q 160 相交链表
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 *
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 示例 2：
 *
 *
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * 示例 3：
 *
 *
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 *  
 *
 * 提示：
 *
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 0 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
 *  
z *  
 */
public class Solution_20210604_160 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while(headA!=null){
            while(headB!=null){
                if(headA.equals(headB)){
                    return  headA;
                }
                else{
                    headB=headB.next;
                }
            }
            headA=headA.next;
        }
        return null;


//        for (ListNode h1 = a; h1 != null ; h1 = h1.next) {
//            for (ListNode h2 = b; h2 != null ; h2 = h2.next) {
//                if (h1.equals(h2)) return h1;
//            }
//        }
//        return null;

    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        ListNode  listNodeA1= new ListNode(4);
        ListNode  listNodeA2= new ListNode(1);
        ListNode  listNodeA3= new ListNode(8);
        ListNode  listNodeA4= new ListNode(4);
        ListNode  listNodeA5= new ListNode(5);

        listNodeA1.next=listNodeA2;
        listNodeA2.next=listNodeA3;
        listNodeA3.next=listNodeA4;
        listNodeA4.next=listNodeA5;




        ListNode  listNodeB1= new ListNode(5);
        ListNode  listNodeB2= new ListNode(0);
        ListNode  listNodeB3= new ListNode(1);
        ListNode  listNodeB4= new ListNode(8);
        ListNode  listNodeB5= new ListNode(4);
        ListNode  listNodeB6= new ListNode(5);
        listNodeB1.next=listNodeB2;
        listNodeB2.next=listNodeB3;
        listNodeB3.next=listNodeB4;
        listNodeB4.next=listNodeB5;
        listNodeB5.next=listNodeB6;

        Assert.isTrue(getIntersectionNode(listNodeA1,listNodeB1).val==new ListNode(8).val,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
