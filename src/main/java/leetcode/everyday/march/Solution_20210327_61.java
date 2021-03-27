package leetcode.everyday.march;

/**
 *给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *https://leetcode-cn.com/problems/rotate-list/
 *  
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 示例 2：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 * 通过次数144,378提交次数348,304
 *
 *
 *
 *
 *
 */
public class Solution_20210327_61 {


    /**
     * 思路 1.先将链表转成环
     *      2.确定环的位置，在新表头前面进行段环操作
     *      3.注意k值可能大于环长
     *
     *
     *      1.计算链表长度
     *      观察发现对链表的操作每len循环一次，计算k % len可有效减少操作链表的次数
     *
     *      2.找到链表尾节点，修改其next指针，将链表连接成循环链表
     *      可以和第一次操作合并，一次循环遍历即可完成
     *
     *      3.从尾节点循环遍历链表，直至找到旋转后链表的尾节点，保存下一个节点，从此处断开循环链表
     *      因为要右移k % len次，所以遍历len - k % len次即可找到旋转后链表的尾节点
     *
     * 作者：Echo__wwW
     * 链接：https://leetcode-cn.com/problems/rotate-list/solution/qing-xi-yi-dong-de-javajie-fa-by-echo__w-82l4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head== null || head.next==null){
            return null;
        }
        ListNode tail =head;
        int length=1;
        while (tail.next!=null){
            tail=tail.next;
            length++;
        }

        tail.next=head;
        k=k%length;
        for(int i=0;i<length-k;i++){
            tail=tail.next;
        }

        head=tail.next;
        tail.next=null;
        return head;


    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        System.out.println("-------------运行通过-------------");
    }
}
