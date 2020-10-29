package zuo.guide.chapter27palindromeList;

import java.util.Stack;

/**
 * 判断一个链表是不是回文结构
 */
public class Client {

    public static void main(String[] args) {
        Node nodePart1 = new Node(1);
        Node nodePart2 = new Node(2);
        Node nodePart3 = new Node(3);
        Node nodePart4 = new Node(2);
        Node nodePart5 = new Node(2);
        nodePart1.setNext(nodePart2);
        nodePart2.setNext(nodePart3);
        nodePart3.setNext(nodePart4);
        nodePart4.setNext(nodePart5);
        System.out.println(isPalindromeList1(nodePart1));
    }

    /**
     * 用栈来实现
     * @param head
     * @return
     */
    public static boolean isPalindromeList1(Node  head){
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while(cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        while(head!=null){
            if(head.value!=stack.pop().getValue()){
                throw new RuntimeException("当前链表不是回文链表");
            }
            head=head.next;
        }
        return true;
    }

}
