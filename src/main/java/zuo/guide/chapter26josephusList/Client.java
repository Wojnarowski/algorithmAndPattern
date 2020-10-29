package zuo.guide.chapter26josephusList;

/**
 * 约瑟夫环形链表问题
 * 输入：环形单链表的头结点head和报数的值m
 * 返回：最后生存下来的结点，且这个节点自己组成的环形单链表，其他节点都删掉
 *
 * 进阶：
 *      如果链表节点数为N，想在时间复杂度为O(N)时完成原问题的要求，该怎么实现？
 */
public class Client {

    public static void main(String[] args) {

    }


    public static Node josePhusKill(Node head , int m){
        if(head==null  ||  head.next==head  ||  m<1){
            return head;
        }
        Node last =head;
        while(head.next!=head){
            last=last.next;
        }
        int count =0;
        while(head!=last){
            if(count++ == m){
                last.next=head.next;
                count=0;
            }else{
                last=last.next;
            }
            head=last.next;
        }
        return head;
    }

}
