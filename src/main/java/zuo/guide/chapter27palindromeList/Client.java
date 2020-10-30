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
         *      那么最后快的结束了慢的走了一半
         */
        while(cur.next !=null && cur.next.next!=null){
            right=right.next;
            cur=cur.next.next;
        }

        //将右边开始的数据进行压栈
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


    /**
     * 1.首先改变链表右边结构，使整个右半区反转，然后指向中间节点
     * 2.leftStart和rightStart同时向中间移动，移动每一步都比较leftStart和rightStart
     * 节点的值，看是否一样。如果都一样，说明链表是回文结构，如果不一样不是回文结构。
     * 3.不管返回的结果是true还是false，在返回前都应该把链表恢复成原来的样子。
     * 4.链表恢复成原来的结构后，返回检查结果。
     * @param head
     * @return
     */
    public static boolean isPalindromeList3(Node  head){
        if(head ==null || head.next==null){
            return true;
        }

        Node n1 = head;
        Node n2 = head;
        //利用快慢指针查找中间节点
        while(n2.next!=null && n2.next.next!=null){
                n1=n1.next;  //中部
                n2=n2.next.next; //结尾
        }
        n2=n1.next;  //n2 右半部分第一个节点
        n1.next=null;  //mid.next -> null
        Node n3 = null;
        //反转右半区
        while(n2!=null){
            n3=n2.next; //n3 保存下一个节点
            n2.next=n1; //下一个反转节点
            n1=n2;  //n1 移动
            n2=n3;  //n2 移动
        }

        n3 = n1;//n3  保存最后一个节点
        n2 = head; //n2 左边第一个节点
        boolean res = true;
        while(n1 !=null && n2 !=null){
            if(n1.value!=n2.value){
                res = false;
                break;
            }
            n1=n1.next;
            n2=n2.next;
        }
        n1=n3.next;
        n3.next=null;
        //回复列表
        while(n1!=null){
            n2=n1.next;
            n1.next=n3;
            n3=n1;
            n1=n2;
        }
        return  res;

    }

}
