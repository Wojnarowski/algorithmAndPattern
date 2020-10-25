package zuo.guide.chapter24ReverseList;

/**
 * 分别实现翻转单向链表和双向链表的函数
 * 要求时间复杂度为 O(N),额外空间复杂度为O(1)
 */
public class Client {

    public Node reverseList(Node head){
        Node pre = null;
        Node next= null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

}