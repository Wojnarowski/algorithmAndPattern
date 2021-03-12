package leetcode.github.list;

public class ListNode {

      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      @Override
      public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
      }

      /**
       * 返回长度为5 值为1到5递增的链表头结点
       * @return
       */
      public static ListNode getListHeader(){
            ListNode listNode11 = new ListNode(1);
            ListNode listNode12 = new ListNode(2);
            ListNode listNode13 = new ListNode(3);
            ListNode listNode14 = new ListNode(4);
            ListNode listNode15 = new ListNode(5);
            listNode11.next=listNode12;
            listNode12.next=listNode13;
            listNode13.next=listNode14;
            listNode14.next=listNode15;
            return listNode11;
      }
}
