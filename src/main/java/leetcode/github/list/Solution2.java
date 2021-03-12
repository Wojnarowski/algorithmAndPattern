package leetcode.github.list;

/**
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 *
 *
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 *
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 *
 */

public class Solution2 {

    /**
     * 思路
     *  两次遍历
     *  第一次遍历：两个链表对应每个节点分别取和，若含有空节点则空节点取0，产生一个新链表。
     *  第二次遍历：对取完和的新链表遍历，判断当前的val是否大于等于10，大于或等于则其自身-10其next加1，若next为空则新建0节点。
     * @param l1
     * @param l2
     * @return
     */
    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //新建结果链表头节点
        ListNode rs = new ListNode(l1.val+l2.val);
        //链表指针下移
        l1=l1.next;
        l2=l2.next;
        ListNode temp =rs;
        while(l1!=null || l2!=null){
            int a =0;
            int b=0;
            if(l1 != null){
                a=l1.val;
            }
            if(l2 != null){
                b=l2.val;
            }
            int t = a+b;
            temp.next = new ListNode(t);
            temp = temp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        temp = rs;

        while (temp != null) {
            if (temp.val >= 10) {
                temp.val = temp.val - 10;
                if (temp.next == null) {
                    temp.next = new ListNode(0);
                }
                temp.next.val = temp.next.val + 1;
            }
            temp = temp.next;
        }

        return rs;

    }

    public static void main(String[] args) {

        ListNode listNode11 = new ListNode(2);
        ListNode listNode12 = new ListNode(4);
        ListNode listNode13 = new ListNode(3);
        listNode11.next=listNode12;
        listNode12.next=listNode13;

        ListNode listNode21 = new ListNode(5);
        ListNode listNode22 = new ListNode(6);
        ListNode listNode23 = new ListNode(4);
        listNode21.next=listNode22;
        listNode22.next=listNode23;


        ListNode result =addTwoNumbers(listNode11,listNode21);
        System.out.println(result.val);


    }
}
