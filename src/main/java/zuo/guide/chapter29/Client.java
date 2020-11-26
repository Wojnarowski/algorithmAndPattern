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

    /**
     * 1．将两个链表分别从左到右遍历，遍历过程中将值压栈，这样就生成了两个链表节点值的逆序栈，分别表示为s1 和 s2。
     *  例如∶链表9->3->7，s1从栈顶到栈底为7，3，9;链表6>3，s2从栈顶到栈底为3，6。
     *
     *
     * 2.     * 将s1和s2同步弹出，这样就相当于两个链表从低位到高位依次弹出，在这个过程中生成相加链表即可，同时需要关注每一步是否有进位，用 ca 表示。
     *  例如∶s1先弹出7，s2 先弹出3，这一步相加结果为10，产生了进位，令ca=1，然后生成一个节点值为0的新节点，记为newl;
     * s1 再弹出3，s2再弹出6，这时进位为ca=1，所以这一步相加结果为10，继续产生进位，仍令ca=1，然后生成一个节点值为0的新节点记为 new2，
     * 令new2.next=newl; s1 再弹出9，s2为空，这时ca=1，这一步相加结果为10，仍令ca=1，然后生成一个节点值为0的新节点，记为 new3，令 new3.next=new2。
     * 这一步也是模拟简单的从低位到高位进位相加的过程。
     *
     *  3.当s1 和s2 都为空时，还要关注一下进位信息是否为1，如果为1，比如步骤2中的例子，表示还要生成一个节点值为1的新节点，记为new4，令 new4.next=new3。
     *
     *
     * z 4.返回新生成的结果链表即可。
     * @param head1
     * @param head2
     * @return
     */
    public static Node addList1(Node head1, Node head2){
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


    /**
     * 1.将两个链表逆序，这样就可以依次得到从低位到高位的数字。
     * 例如∶链表9->3->7，逆序后变为7->3->9;链表6->3，逆序后变为3->6。
     *
     *  2．同步遍历两个逆序后的链表，这样就依次得到两个链表从低位到高位的数字，在这个过程中生成相加链表即可，同时需要关注每一步是否有进位，
     * 用ca表示。具体过程与方法一的步骤 2相同。
     *
     *
     *  3.当两个链表都遍历完成后，还要关注进位信息是否为1，如果为1，还要生成一个节点值为1 的新节点。
     *
     *  4.将两个逆序的链表再逆序一次，即调整成原来的样子。
     *
     * 5.返回新生成的结果链表。
     *
     *
     * @param head1
     * @param head2
     * @return
     */
    public static Node addList2(Node head1, Node head2){

        return null;
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

        Node node = addList1(node1,node2);
        System.out.println(node);
    }
}
