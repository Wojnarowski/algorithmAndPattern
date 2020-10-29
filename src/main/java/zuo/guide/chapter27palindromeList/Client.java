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
        Node nodePart4 = new Node(4);
        Node nodePart5 = new Node(5);
        Node nodePart6 = new Node(6);
        Node nodePart7 = new Node(7);
        Node nodePart8 = new Node(8);
        Node nodePart9 = new Node(9);
        nodePart1.setNext(nodePart2);
        nodePart2.setNext(nodePart3);
        nodePart3.setNext(nodePart4);
        nodePart4.setNext(nodePart5);
        nodePart5.setNext(nodePart6);
        nodePart6.setNext(nodePart7);
        nodePart7.setNext(nodePart8);
        nodePart8.setNext(nodePart9);
        //System.out.println(isPalindromeList1(nodePart1));
        System.out.println(isPalindromeList2(nodePart1));
    }

    /**
     * 用栈来实现 整个一个栈
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


    /**
     * 用栈来实现   找出中点折半，将后半段放入栈中
     *              进行对调
     * @param head
     * @return
     */
    public static boolean isPalindromeList2(Node  head){
        if(head.next==null || head==null){
            return true;
        }

        //定义当前节点从头节点开始
        Node cur =head;
        //定义right节点是头节点下一个
        Node right =head.next;

        /**
         * 重点：TODO
         *      快的一次走两步,慢的一次走一步
         *      那么最后快的结束了慢的走了一半,此时在走的过程中需要压栈
         */
        while(cur.next !=null && cur.next.next!=null){
            right=right.next;
            cur=cur.next.next;
        }

        Stack<Node> stack = new Stack<Node>();
        while(right!=null){
            stack.push(right);
            right=right.next;
        }
        while (!stack.isEmpty()){
            if(head.value!=stack.pop().value){
                return false;
            }
            head=head.next;
        }
        return true;

    }

}
