package zuo.guide.chapter24ReverseList;

/**
 * 分别实现翻转单向链表和双向链表的函数
 * 要求时间复杂度为 O(N),额外空间复杂度为O(1)
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
        System.out.println(nodePart1);
        System.out.println("------------------");
        Node node = reverseList(nodePart1);
        System.out.println(node);
    }

    public static Node reverseList(Node head){
        Node pre = null;
        Node next= null;
        Node cur = head;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;

        }
        return pre;
    }

}
