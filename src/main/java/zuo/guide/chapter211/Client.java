package zuo.guide.chapter211;

/**
 * 给定一个单链表的头节点head，实现一个调整单链表的函数，使得每K个节点之间逆序，
 * 如果最后不够K 个节点一组，则不调整最后几个节点。 
 * 例如∶ 链表∶ 1->2->3->4->5->6->7->8->null，K=3。 
 * 调整后为∶3->2→>1-6->5->4->7->8->null。
 * 其中7、8不调整，因为不够一组。
 */
public class Client {
    public class  Node {
        public int value;
        public Node next;
        public Node(int data){
            this.value=data;
        }
    }
}
