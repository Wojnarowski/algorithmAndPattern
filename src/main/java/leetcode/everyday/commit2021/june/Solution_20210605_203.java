package leetcode.everyday.commit2021.june;

import leetcode.everyday.ListNode;
import org.springframework.util.Assert;

/**
 *q 203 移除链表元素
 *
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 列表中的节点在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= k <= 50
 * 通过次数176,451提交次数356,501
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 */
public class Solution_20210605_203 {

    public static  ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        for(ListNode tmp = dummy.next,prev=dummy;tmp!=null;tmp=tmp.next){
            if (tmp.val == val) {
                prev.next = tmp.next;
            } else {
                prev = tmp;
            }
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        ListNode  listNodeA1= new ListNode(1);
        ListNode  listNodeA2= new ListNode(2);
        ListNode  listNodeA3= new ListNode(6);
        ListNode  listNodeA4= new ListNode(3);
        ListNode  listNodeA5= new ListNode(4);
        ListNode  listNodeA6= new ListNode(6);

        listNodeA1.next=listNodeA2;
        listNodeA2.next=listNodeA3;
        listNodeA3.next=listNodeA4;
        listNodeA4.next=listNodeA5;
        listNodeA5.next=listNodeA6;






        Assert.isTrue(removeElements(listNodeA1,6)==null,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
