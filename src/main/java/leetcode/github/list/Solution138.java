package leetcode.github.list;

/**
 *给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 *
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 *
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 *
 * 返回复制链表的头节点。
 *
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 *
 *
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 *
 *
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 *
 * 提示：
 *
 * 0 <= n <= 1000
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 *
 *
 * TODO 题目意思
 * 把原来链表复制一份,在不更改原链表的情况下返回拷贝链表
 *
 * 浅拷贝： 返回地址一样的链表。 深拷贝： 返回地址不一样，但关系一致的链表。
 * 所以不能直接简单粗暴的遍历复
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Solution138 {


    /**
     * 思路
     * 解法一
     * 这题的最大难点就在于复制随机指针，比如下图中
     *
     * 节点1的随机指针指向节点3
     * 节点3的随机指针指向节点2
     * 节点2的随机指针指向空
     *
     * 我们可以用三步走来搞定这个问题
     * 第一步，根据遍历到的原节点创建对应的新节点，每个新创建的节点是在原节点后面，比如下图中原节点1不再指向原原节点2，而是指向新节点1
     *
     *
     * 第二步是最关键的一步，用来设置新链表的随机指针
     *
     * 上图中，我们可以观察到这么一个规律
     *
     * 原节点1的随机指针指向原节点3，新节点1的随机指针指向的是原节点3的next
     * 原节点3的随机指针指向原节点2，新节点3的随机指针指向的是原节点2的next
     * 也就是，原节点i的随机指针(如果有的话)，指向的是原节点j
     * 那么新节点i的随机指针，指向的是原节点j的next
     *
     * 第三步就简单了，只要将两个链表分离开，再返回新链表就可以了
     *
     *
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head) {
        if(head ==null){
            return null;
        }

        Node p=head;
        //在每个原节点后面创建一个新节点
        //1->1'->2->2'->3->3'
        while(p!=null){
            Node newNode = new Node(p.val);
            newNode.next=p.next;
            p.next=newNode;
            p=newNode.next;
        }
        p = head;
        //第二步，设置新节点的随机节点
        while(p!=null){
            if(p.random!=null){
                p.next.random=p.random.next;
            }
            p=p.next.next;
        }
        Node dummy = new Node(-1);
        p = head;
        Node cur = dummy;

        //第三步，将两个链表分离
        while(p!=null) {
            cur.next = p.next;
            cur = cur.next;
            p.next = cur.next;
            p = p.next;
        }
        return dummy.next;

    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }



    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next=node2;
        System.out.println(copyRandomList(node1));

    }
}
