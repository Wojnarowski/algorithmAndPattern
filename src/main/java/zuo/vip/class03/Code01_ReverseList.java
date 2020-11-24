package zuo.vip.class03;

import java.util.ArrayList;

public class Code01_ReverseList {


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        Node node5 = new Node(5);
        node1.next=node2;
//        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;

        Node node = reverseLinkedList(node1);
        System.out.println(node.value);

    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            value = data;
        }
    }

    //  head
    //   a    ->   b    ->  c  ->  null
    //   c    ->   b    ->  a  ->  null

    /**
     * 过程 第一次后
     * b    ->  a     ->  c  ->  null
     * 第一次后
     * c    ->  b    ->  a  ->  null
     * @param head
     * @return
     */
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;  //  将当前头结点指针赋给next
            head.next = pre;   //  将头结点指针指向pre
            pre = head;        // 将head的值赋给pre
            head = next;       // 让head节点来到下一个
        }
        return pre;
    }

    public static DoubleNode reverseDoubleNode(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            head.last=next;
            pre=head;
            head=next;
        }
        return pre;
    }


    public static Node testReverseLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> list = new ArrayList<Node>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        int N = list.size();
        for (int i = 1; i < N; i++) {
            list.get(i).next = list.get(i - 1);
        }
        return list.get(N - 1);
    }


    public static DoubleNode testReverseDoubleList(DoubleNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<DoubleNode> list = new ArrayList<DoubleNode>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        DoubleNode pre = list.get(0);
        int N = list.size();
        for (int i = 1; i < N; i++) {
            DoubleNode cur = list.get(i);
            cur.last = null;
            cur.next = pre;
            pre.last = cur;
            pre = cur;
        }
        return list.get(N - 1);
    }




}
