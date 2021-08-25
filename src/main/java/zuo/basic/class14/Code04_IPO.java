package zuo.basic.class14;

import java.util.*;

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
public class Code04_IPO {

    /**
     *  贪心实现
     *  1.根据W 解锁项目进小根堆
     *  2.按利润放入大根堆  做 ，W提升
     *  3.周而复始
     *
     * @param K 表示你只能串行的最多做k个项目
     * @param W 表示你初始的资金
     * @param Profits [i]表示i号项目在扣除花费之后还能挣到的钱(利润)
     * @param Capital 表示i号项目的花费
     * @return
     */
    public static int findMaximizedCapital(int K, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Program> minCostQ = new PriorityQueue<Program>(new MinCostComparator());
        PriorityQueue<Program> maxProfitQ = new PriorityQueue<Program>(new MaxProfitComparator());
        for(int i=0;i<Profits.length;i++){
            minCostQ.add(new Program(Profits[i],Capital[i]));
        }
        for(int i=0;i<K;i++){
            while(!minCostQ.isEmpty() && minCostQ.peek().c<=W){
                maxProfitQ.add(minCostQ.poll());
            }
            //如果一个都不能做
            if(maxProfitQ.isEmpty()){
                return W;
            }
            W+=maxProfitQ.poll().p;
        }
        return W;
    }


    public static class MinCostComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.c-o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o2.p-o1.p;
        }
    }

    public static class Program {
        public int p;
        public int c;

        public Program(int p,int c){
            this.p=p;
            this.c=c;
        }
    }

}

