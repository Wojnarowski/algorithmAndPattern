package leetcode.everyday.commit;

import leetcode.everyday.ListNode;

/**
 * 24  交换链表两个节点
 *
 */


public class Solution_20220517_24 {


    /**
     * 1.返回值：交换完成的子链表
     * 2.调用单元：设需要交换的两个点为 head 和 next，head 连接后面交换完成的子链表，next 连接 head，完成交换
     * 3.终止条件：head 为空指针或者 next 为空指针，也就是当前无节点或者只有一个节点，无法进行交换
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        // 如果当前结点为null或当前结点下一个结点为null
        // 则递归终止
        if (head == null || head.next == null){
            return head;
        }
        // subResult是head.next.next之后的结点两两交换后的头结点
        ListNode subResult = swapPairs(head.next.next);
        ListNode headNext = head.next;
        headNext.next = head;
        head.next = subResult;
        return headNext;

    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
