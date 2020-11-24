package zuo.guide.chapter28;

/**
 *
 *将链表分成左边小，中间相等，右边大的形式。
 *
 * */
public class Patition2 {


    public static class Node {

        public int value;
        public Node next;

        public Node(int value){
            this.value=value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static Node listPartition2(Node head, int pivot){
        Node sH=null;//小的头
        Node sT=null;//小的尾
        Node eH=null;//相等的头
        Node eT=null;//相等的尾
        Node bH=null;//大的头
        Node bT=null;//大的尾
        Node next = null; //保存的下一个节点
        //所有节点分进三个链表中
        while(head!=null){
             next=head.next;
             head.next=null;
             if(head.value<pivot){
                if(sH == null){
                    sH=head;
                    sT=head;
                }else{
                    sT.next=head;
                    sT=head;
                }
             }else if(head.value==pivot){
                 if(eH==null){
                     eH=head;
                     eT=head;
                 }else{
                     eT.next=head;
                     eT=head;
                 }
             }else {
                 if(bH==null){
                     bH=head;
                     bT=head;
                 }else{
                     bT.next=head;
                     bT=head;
                 }
             }
             head=next;
        }
        //将小的和等于的连接
        if(sT != null){
            sT.next=eH;
            eT=eT==null?sT:eT;
        }
        //所有重新连接
        if(eT!=null){
            eT.next=bH;
        }

        return sH !=null ? sH : eH != null ? eH :  bH;

    }

    public static void main(String[] args) {
        Node nodePart1 = new Node(5);
        Node nodePart2 = new Node(4);
        Node nodePart3 = new Node(1);
        Node nodePart4 = new Node(3);
        Node nodePart5 = new Node(2);
        nodePart1.setNext(nodePart2);
        nodePart2.setNext(nodePart3);
        nodePart3.setNext(nodePart4);
        nodePart4.setNext(nodePart5);

        Node node =listPartition2(nodePart1,3);
        System.out.println(node.value);
    }


}
