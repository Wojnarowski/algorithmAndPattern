package zuo.guide.chapter21PirntSameThingIn2SortedLinkedList;

/**
 * 打印两个有序链表中相同的数据
 * 暴力解法：双重for循环
 * 正解
 *  注意：有序
 *  如果head1<head2 head1 向下移动
 *   如果head2<head1 head2 向下移动
 *   如果 head1==head2 打印这个值，同时向下移动
 *   如果head1 或者head2 的任何一个值移动到null，整个过程停止
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


        Node nodePart21 = new Node(6);
        Node nodePart22 = new Node(7);
        Node nodePart23 = new Node(8);
        Node nodePart24 = new Node(9);
        Node nodePart25 = new Node(10);
        nodePart21.setNext(nodePart22);
        nodePart22.setNext(nodePart23);
        nodePart23.setNext(nodePart24);
        nodePart24.setNext(nodePart25);

        printCommonPart(nodePart1,nodePart21);


    }


    public static void printCommonPart(Node head1,Node head2){
        System.out.println("print Common Part");
        while(head1!=null && head2!=null){
            if(head1.value<head2.value){
                head1=head1.next;
            }else if(head2.value<head1.value){
                head2=head2.next;
            }else if(head1.value==head2.value){
                System.out.println(head1.value);
                head1=head1.next;
                head2=head2.next;
            }
        }
        System.out.println("打印完毕");

    }

}
