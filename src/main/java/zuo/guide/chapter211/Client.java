package zuo.guide.chapter211;

import java.util.Stack;

/**
 * 给定一个单链表的头节点head，实现一个调整单链表的函数，使得每K个节点之间逆序，
 * 如果最后不够K 个节点一组，则不调整最后几个节点。 
 * 例如∶ 链表∶ 1->2->3->4->5->6->7->8->null，K=3。 
 * 调整后为∶3->2→>1-6->5->4->7->8->null。
 * 其中7、8不调整，因为不够一组。
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
        printNode(nodePart1);
        System.out.println("------------------");
        Node node = reverseKNode1(nodePart1,2);
        printNode(node);
    }


    public static class  Node {
        public int value;
        public Node next;
        public Node(int data){
            this.value=data;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static Node reverseKNode1(Node head, int k){
        if(k<2){
            return head;
        }
        Stack<Node> stack = new Stack<Node>();
        Node newHead = head;
        Node cur = head;
        Node pre = null;
        Node next = null;
        while(cur != null){
            next=cur.next;
            stack.push(cur);
            if(stack.size() == k){
                pre = resign1(stack,pre,next);
                newHead = newHead == head ? cur : newHead;
            }
            cur=next;
        }
        return newHead;
    }

    public static Node resign1(Stack<Node> stack, Node left, Node right) {
        Node cur = stack.pop();
        if(left != null){
            left.next=cur;
        }
        Node next = null;
        while(!stack.isEmpty()){
            next=stack.pop();
            cur.next=next;
            cur=next;
        }
        cur.next=right;
        return cur;
    }

    public static void printNode(Node node){
        while(node != null){
            System.out.println(node.value);
            node=node.next;
        }
    }
}
