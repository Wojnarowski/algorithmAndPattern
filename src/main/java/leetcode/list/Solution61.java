package leetcode.list;

/**
 *给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */


public class Solution61 {


    /**
     * 这种方法头节点丢了
     * @param head
     * @param k
     * @return
     */
//    public static ListNode rotateRight(ListNode head, int k) {
//        if(head==null || k<1){
//            return head;
//        }
//        ListNode pre = head;
//        ListNode last=head;
//        while (head.next.next !=null){
//            head=head.next;
//        }
//        pre=head;
//        last=head.next;
//        head.next=null;
//        last.next=pre;
//        return last;
//    }

    /**
     * 思路
     * 1.先形成环
     * 2.尾节点移动 length - k 步  （右移k步 == 左移 length - k 步）
     * 3.找到头节点，断开首位连接
     * @param head
     * @param kz
     * @return
     */
    public static ListNode rotateRight2(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        //1.先找尾节点形成环
        ListNode tail = head;
        int length=1;
        while(tail.next!=null){
            tail=tail.next;
            length++;
        }
        tail.next=head;
        //2.尾节点移动length-k步
        k=k%length;
        for(int i=0;i<length-k;i++){
            tail=tail.next;
        }
        //3.找到头结点,断链
        head=tail.next;
        tail.next=null;
        return head;
    }



    public static void main(String[] args) {
        System.out.println(ListNode.getListHeader().toString());
        System.out.println(rotateRight2(ListNode.getListHeader(),3));


    }
}
