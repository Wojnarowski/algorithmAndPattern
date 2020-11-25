package zuo.guide.chapter29;

import java.util.Stack;

/**
 * 两个单链表生成相加链表
 * 假设链表中每一个节点的值都在0～9 之间，那么链表整体就可以代表一个整数。
 * 例如∶ 9->3->7，可以代表整数 937。 
 * 给定两个这种链表的头节点headI 和head2，请生成代表两个整数相加值的结果链表。
 * 例如∶链表1为 9->3->7，链表2为6->3，最后生成新的结果链表为1->0->0->0。
 */
public class Client {

    public class Node{
        private int value;
        private Node next;
        public Node(int data ){
            this.value=data;
        }
    }

    public Node addList(Node head1,Node head2){
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while(head1!=null){
            s1.push(head1.value);
            head1=head1.next;
        }

        while(head2!=null){
            s2.push(head2.value);
            head2=head2.next;
        }



    }
}
