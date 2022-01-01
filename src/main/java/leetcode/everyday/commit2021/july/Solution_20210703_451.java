package leetcode.everyday.commit2021.july;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *q 451 根据字符出现频率排序
 *
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 * 输入:
 * "tree"
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 *
 * 示例 2:
 * 输入:
 * "cccaaa"
 * 输出:
 * "cccaaa"
 *
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 *
 * 输入:
 * "Aabb"
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 *
 *  
 */
public class Solution_20210703_451 {

    /**
     * 思路
     *  1.先使用「哈希表」对词频进行统计；
     *  2.遍历统计好词频的哈希表，将每个键值对以 {字符,词频} 的形式存储到「优先队列（堆）」中。并规定「优先队列（堆）」排序逻辑为：
     *      如果 词频 不同，则按照 词频 倒序；
     *      如果 词频 相同，则根据 字符字典序 升序（由于本题采用 Special Judge 机制，这个排序策略随意调整也可以。但通常为了确保排序逻辑满足「全序关系」，这个地方可以写正写反，但理论上不能不写，否则不能确保每次排序结果相同）；
     * 3.从「优先队列（堆）」依次弹出，构造答案。
     *
     * @param s
     * @return
     */
    class  Node{
        char c;
        int v;

        Node(char _c ,int _v){
            c=_c;
            v=_v;
        }
    }
    public String frequencySort(String s) {

        char [] sArray = s.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c: sArray){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Node> q = new PriorityQueue<Node>((a,b)->{
            if(b.v!=a.v){
                return b.v-a.v;
            }
            else{
                return a.c-b.c;
            }
        });
        for(char c:map.keySet()){
            q.add(new Node(c, map.get(c)));
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            Node poll  = q.poll();
            int k =poll.v;
            while(k-->0) sb.append(poll.c);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(judgeSquareSum(5)==true,"程序异常");
        System.out.println(2^2);
        System.out.println("-------------运行通过-------------");
    }
}
