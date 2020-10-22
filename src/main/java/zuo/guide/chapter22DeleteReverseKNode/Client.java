package zuo.guide.chapter22DeleteReverseKNode;

/**
 * 在单链表或者双向链表中删除倒数第K个节点
 * 分别实现两个函数，一个可以删除单向链表中的倒数第K个节点。
 * 另一个可以删除双向链表中倒数第K个节点
 *
 * 如果链表长度为N，时间复杂度达到O（N） ，额外空间复杂度度到O（1）
 *
 * 解答：
 *  让链表从头走到尾，每走一步就让K值减一
 *      第一种情况
 *          链表1->2->3  k=4 ,不存在倒数第4个节点。
 *          走到的节点 1->2->3   k的变化 3 2 1
 *          链表走到结尾时，如果K值大于0，说明不用调整链表，
 *          因为链表根本没有倒数第K个节点，此时将原链表直接返回即可
 *     第二种情况
 *           链表 链表1->2->3  k=3 链表倒数第三个节点是1 节点
 *           走到的节点 1->2->3   k的变化 2 1 0
 *           链表走到结尾时，如果K值等于0，说明链表倒数第K个节点就是头结点，
 *           此时直接返回head.next，相当于删除了头结点。
 *      第三种情况
 *           链表1->2->3  k=2 链表倒数第二个节点是2节点
 *           走到的节点 1->2->3   k的变化 1 0 -1
 *           k<0 的时候处理方法：
 *              首先先明确一点 如果要删除头结点之后的某个节点，实际上要找到
 *              要删除节点的前一个节点，比如1->2->3 要删除 2 节点 ，则需要找到
 *              1 节点，然后将 1 节点的指向 3 上（1->3）,以此来达到删除节点 2 的
 *              目的。
 *           1.从头节点开始走，每走一步就让k的节点加1.
 *           2.当k等于0时，移动停止，移动到的节点就是要删除节点的前一个节点
 *
 *           链表长度为N,要删除倒数第K个节点，那么倒数第K个节点的前一个结点
 *           就是第N-K个节点。在第一次遍历之后，K的值变为了K-N。
 *           第二次遍历时，K的值不断加1.加到0就停止遍历，
 *           所在的位置就是第N-K个节点的位置。
 */
public class Client {

    public static void main(String[] args) {
        Node nodePart1 = new Node(1);
        Node nodePart2 = new Node(2);
        Node nodePart3 = new Node(3);
        Node nodePart4 = new Node(4);
        Node nodePart5 = new Node(5);
        nodePart1.setNext(nodePart2);
        nodePart2.setNext(nodePart3);
        nodePart3.setNext(nodePart4);
        nodePart4.setNext(nodePart5);
        //1->2->3->4->5

        //Node result = removeLastKthNode(nodePart1,6);
        //Node result = removeLastKthNode(nodePart1,5);
        Node result = removeLastKthNode(nodePart1,2);
        System.out.println(result.getValue());
    }

//    public static Node removeLastKthNode(Node head ,int lastKth){
//        if(head==null || lastKth<1){
//            return head;
//        }
//        Node cur = head;
//        while(cur!=null){
//            cur=cur.next;
//            lastKth--;
//        }
//        if(lastKth>0){
//            return  head;
//        }
//        if(lastKth==0){
//            return head.next;
//        }
//        if(lastKth<0){
//            while(lastKth++!=0){
//                head=head.next;
//            }
//            head.next=head.next.next;
//        }
//
//        return head;
//
//    }



    public static Node removeLastKthNode(Node head ,int lastKth){
        if(head==null || lastKth<1){
            return head;
        }
        Node cur = head;
        while(cur!=null){
            cur=cur.next;
            lastKth--;
        }
//        if(lastKth>0){
//            return  head;
//        }
        if(lastKth==0){
            return head.next;
        }
        if(lastKth<0){
            cur=head;
            while(++lastKth!=0){
                cur=cur.next;
            }
            cur.next=cur.next.next;
        }
        return head;

    }

    public DoubleNode removeLastKthNode(DoubleNode head,int lastKth){
        if(head==null||lastKth<1){
            return head;
        }
        DoubleNode cur =head;
        while(cur!=null){
            cur=cur.next;
            lastKth--;
        }
        if(lastKth==0){
           head=head.next;
           head.last=null;
        }
        if(lastKth<0){
            cur=head;
            while (++lastKth!=0){
                cur=cur.next;
            }
            DoubleNode newNext =cur.next.next;
            cur.next = newNext;
            if (newNext != null) {
                newNext.last = cur;
            }

        }

        return head;
    }
}
