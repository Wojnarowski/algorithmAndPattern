package zuo.guide.chapter28;

/**
 *
 *将链表分成左边小，中间相等，右边大的形式。
 *
 * */
public class Client {


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

    public static Node listPartition1(Node head, int pivot){
        if(head == null){
            return head;
        }
        Node cur = head;
        int i=0;
        while(cur!=null){
            i++;
            cur=cur.next;
        }
        Node[] nodeArr = new Node[i];
        i=0;
        cur=head;
        for(i=0;i<nodeArr.length;i++){
            nodeArr[i]=cur;
            cur=cur.next;
        }
        arrPatition(nodeArr,pivot);
        //断链
        for(i=1;i!=nodeArr.length;i++){
            nodeArr[i-1].next=nodeArr[i];
        }
        nodeArr[i-1].next=null;
        return  nodeArr[0];
    }

    private static void arrPatition(Node[] nodeArr, int pivot) {
            int small=-1;
            int big =nodeArr.length;
            int index=0;
            while(index!=big){
                if(nodeArr[index].value<pivot){
                    swap(nodeArr,++small,index++);
                }else if(nodeArr[index].value==pivot){
                        index++;
                }else{
                        swap(nodeArr,--big,index);
                }
            }

    }

    private static void swap(Node[] nodeArr, int a, int b) {
        Node temp =nodeArr[a];
        nodeArr[a]=nodeArr[b];
        nodeArr[b]=temp;
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

        Node node =listPartition1(nodePart1,3);
        System.out.println(node.value);
    }


}
