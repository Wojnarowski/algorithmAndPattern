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

    public static class Node{
        private int value;
        private Node next;
        public Node(int data ){
            this.value=data;
        }
    }

    public static Node addList(Node head1, Node head2){
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
        int ca =0;
        int n1 = 0;
        int n2 = 0 ;
        int n = 0;
        Node node = null;
        Node pre = null;
        while(!s1.isEmpty() || !s2.isEmpty()){
                n1=s1.isEmpty() ? 0 : s1.pop();
                n2=s2.isEmpty() ? 0 : s2.pop();
                n=n1 + n2 + ca;
                pre=node;
                node=new Node(n % 10);
                node.next=pre;
                ca = n / 10;
        }

        if(ca == 1){
            pre=node;
            node = new Node(1);
            node.next=pre;
        }
        return  node;
    }


    public static void main(String[] args) {
        Node node1 = new Node(9);
        Node node12 = new Node(3);
        Node node13 = new Node(7);
        node1.next=node12;
        node12.next=node13;


        Node node2 = new Node(6);
        Node node22 = new Node(3);
        node2.next=node22;

        Node node = addList(node1,node2);
        System.out.println(node);


    }
}
