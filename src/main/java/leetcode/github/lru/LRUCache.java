package leetcode.github.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LRUCache
 * @Description TODO
 * @Author paul
 * @Date 2021/6/16 22:27
 * Vertion 1.0
 * -------------------------------------------------------------_ooOoo_
 * ------------------------------------------------------------o8888888o
 * ------------------------------------------------------------88"-.-"88
 * ------------------------------------------------------------(|--_--|)
 * ------------------------------------------------------------O\--=--/O
 * ---------------------------------------------------------____/`---'\____
 * -------------------------------------------------------.'--\\|-----|//--`.
 * ------------------------------------------------------/--\\|||--:--|||//--\
 * -----------------------------------------------------/--_|||||--:--|||||---\
 * -----------------------------------------------------|---|-\\\-----///-|---|
 * -----------------------------------------------------|-\_|--''\---/''--|---|
 * -----------------------------------------------------\--.-\__--`-`--___/-.-/
 * ---------------------------------------------------___`.-.'--/--.--\--`.-.-__
 * ------------------------------------------------.""-'<--`.___\_<|>_/___.'-->'"".
 * -----------------------------------------------|-|-:--`--\`.;`\-_-/`;.`/---`-:-|-|
 * -----------------------------------------------\--\-`-.---\_-__\-/__-_/---.-`-/--/
 * ---------------------------------------======`-.____`-.___\_____/___.-`____.-'======
 * -------------------------------------------------------------`=---='
 * ---------------------------------------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * -----------------------------------------------------佛祖保佑--------永无BUG
 */
public class LRUCache {

    // 双向链表节点定义
    class Node{
        int key;
        int val;
        Node pre;
        Node next;
    }

    //模拟缓存容量
    private int capacity;

    //保存链表的头结点和尾节点
    private Node first;
    private Node last;

    //从key到node映射的map
    private Map<Integer, Node> map;

    public LRUCache(int capacity){
        this.capacity=capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key){
        Node node = map.get(key);
        if(node==null){
            return -1;
        }

        moveToHead(node);
        return node.val;

    }

    public void put (int key,int value){
        //看看节点是否已经存在
        Node node = map.get(key);
        //节点不存在
        if(node==null){
            //先创建节点，然后看节点是否满了，如果满了删除最后一个节点；然后将节点放到链表头部，增加一个映射关系
            //否则直接覆盖，然后移动到链表头部
            node = new Node();
            node.key=key;
            node.val=value;

            if(map.size()==capacity){
                removeLast();
            }
            addToHead(node);
            map.put(key,node);
        }
        //节点存在直接放到前面
        else{
            node.val=value;
            moveToHead(node);
        }
    }

    private void moveToHead(Node node) {
        //要修改很多指针

        //如果是头节点
        if(node == first){
            return ;
        }
        //如果是最后一个节点
        else if(node == last){
            //将最后一个节点的next指针置为空，然后last指向前一个节点
            last.pre.next = null;
            last=last.pre;
        }
        //如果是中间节点
        else{
            //如果是中间节点，中间节点的前节点的后指针  指向 中间节点的后节点
            //中间节点的后节点的前指针 指向 中间节点的前节点
            node.pre.next=node.next;
            node.next.pre=node.pre;
        }

        //把当前节点作为头结点
        node.pre= first.pre;//也可以写成node.pre=first.pre;
        node.next=first;
        first.pre=node;
        first=node;
    }

    private void addToHead(Node node) {
        if(map.isEmpty()){
            first=node;
            last=node;
        }
        else{
            //把新节点作为头节点
            //node.pre=first.pre;
            node.next=first;
            first.pre=node;
            first=node;
        }
    }

    private void removeLast() {
        map.remove(last.key);
        Node preNode = last.pre;
        //修改last指针位置
        if(preNode != null){
            preNode.next=null;
            last=preNode;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.first.val);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);

        cache.put(1,1);
        System.out.println(cache);
        cache.put(2,2);
        System.out.println(cache);
        cache.put(3,3);
        System.out.println(cache);
        cache.put(4,4);
        System.out.println(cache);
        cache.put(5,5);
        System.out.println(cache);
        cache.put(6,6);
        System.out.println(cache);
        cache.get(3);
        System.out.println("调用get");
        System.out.println(cache);


    }


}

