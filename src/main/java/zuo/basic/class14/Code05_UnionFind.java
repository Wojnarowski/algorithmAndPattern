package zuo.basic.class14;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Code05_UnionFind
 * @Description TODO
 * @Author paul
 * @Date 2021/8/25 16:18
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
 *
 * 并查集
 *  小集合的头节点挂大集合的头结点
 *  优化获取父节点
 *
 */
public class Code05_UnionFind {

    public static class Node<V>{

        V value;

        public Node(V v){
            value = v;
        }
    }

    public static class UnionFind<V>{
        public HashMap<V,Node<V>> nodes;
        public HashMap<Node<V>,Node<V>> parents; //节点的parent节点
        public HashMap<Node<V>,Integer> sizeMap; //节点的集合大小

        public UnionFind(List<V> values){
            nodes=new HashMap<V,Node<V>>();
            parents=new HashMap<Node<V>,Node<V>>();
            sizeMap= new HashMap<Node<V>,Integer>();
            for(V cur: values){
                Node<V> node = new Node<>(cur);
                nodes.put(cur,node);
                parents.put(node,node);
                sizeMap.put(node,1);
            }
        }

        /**
         * 给定一个节点，往上找找到不能在往上把代表返回
         * @param cur
         * @return
         */
        public Node<V> findParent(Node<V> cur){
            Stack<Node<V>> path = new Stack<>();
            //放入栈里面
            while(cur!=parents.get(cur)){
                path.push(cur);
                cur=parents.get(cur);
            }
            //到达不能在往上了
            //将节点挂到最上节点
            while(!path.isEmpty()){
                parents.put(path.pop(),cur);
            }
            return cur;
        }

        public boolean isSameSet(V a,V b){
            return findParent(nodes.get(a))==findParent(nodes.get(b));
        }

        public int sets(){
            return sizeMap.size();
        }

        public void union(V a,V b){

        }

    }
}

