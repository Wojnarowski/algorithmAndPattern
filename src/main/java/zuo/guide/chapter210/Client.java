package zuo.guide.chapter210;

public class Client {

    public static class Node{
        private int value;
        private Node next;
        public Node(int data ){
            this.value=data;
        }
    }


    /**
     * 如何判断一个链表是否有环，如果有，则返回第一个进入环的节点，没有则返回 null。
     *
     *  如果一个链表没有环，那么遍历链表一定可以遇到链表的终点;如果链表有环，那么遍历链表就永远在环里转下去了。
     * 如何找到第一个入环节点，具体过程如下∶
     *  1．设置一个慢指针 slow 和一个快指针 fast。在开始时，slow 和 fast 都指向链表的头节点 head。然后 slow 每次移动一步，fast 每次移动两步，在链表中遍历起来。 
     * 2.如果链表无环，那么 fast 指针在移动的过程中一定先遇到终点，一旦fast 到达终点，说明链表是没有环的，直接返回 null，表示该链表无环，当然也没有第一个入环的节点。 
     * 3.如果链表有环，那么 fast 指针和 slow 指针一定会在环中的某个位置相遇，当 fast和 slow相遇时，fast 指针重新回到head 的位置，slow指针不动。
     *      接下来，fast指针从每次移动两步改为每次移动一步，slow 指针依然每次移动一步，然后继续遍历。 
     * 4.fast 指针和 slow 指针一定会再次相遇，并且在第一个入环的节点处相遇。
     * @param head
     * @return
     */
    public Node getLoopNode(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }

        Node n1 = head.next; // slow
        Node n2 = head.next.next; // fast
        while(n1 != n2){
            //快指针到底
            if(n2.next == null || n1.next.next==null){
                return null;
            }
            n2=n2.next.next;
            n1=n1.next;
        }
        n2=head;
        while(n1 != n2){
            n1=n1.next;
            n2=n2.next;
        }
        return n1;
    }

    public Node  noLoop(Node head1 ,Node head2){
        if(head1 ==null || head2==null){
            return null;
        }
        Node cur1 =head1;
        Node cur2=head2;
        int n=0;
        while(cur1.next!=null){
            n++;
            cur1=cur1.next;
        }
        while (cur2.next!=null){
            n--;
            cur2=cur2.next;
        }
        if(cur1 != cur2){
            return  null;
        }
        cur1=n>0?head1:head2;
        cur2= cur1 ==head1?head2:head1;
        n=Math.abs(n);
        while (n!=0){
            n--;
            cur1=cur1.next;
        }
        while(cur1!=cur2){
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;
    }



}
