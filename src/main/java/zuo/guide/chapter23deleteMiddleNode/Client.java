package zuo.guide.chapter23deleteMiddleNode;

/**
 * 删除链表中间节点和a/b处的节点
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

        Node node = removeMidNode(nodePart1);
        System.out.println(node);
    }

    public  static Node removeMidNode(Node head){
        if(head==null|| head.next==null){
            return head;
        }
        if(head.next.next==null){
            return head.next;
        }
        Node pre = head;
        Node cur=head.next.next;
        while(cur.next!=null&&cur.next.next!=null){
            pre=pre.next;
            cur=cur.next.next;
        }
        pre.next=pre.next.next;
        return head;
    }


    public Node removeByRatio(Node head,int a, int b){

        if(a<1||a>b){
            return head;
        }
        int n=0;
        Node cur =head;
        while(cur!=null){
            n++;
            cur=cur.next;
        }
        n=(int)Math.ceil(((double)(n*a))/(double)b);
        if(n==1){
            head=head.next;
        }

        if(n>1){
            cur=head;
            while(--n!=1){
                cur=cur.next;
            }
            cur.next=cur.next.next;
        }

        return head;
    }


}
