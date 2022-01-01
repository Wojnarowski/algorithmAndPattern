package leetcode.everyday.commit2021.may;

import java.util.*;

/**
 *q 692 前K个高频单词
 *
 *给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 *
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *  
 *
 * 示例 2：
 *
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *  
 *
 * 注意：
 *
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *  
 *
 * 扩展练习：
 *
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Solution_20210520_692 {


    /**
     * 思路一: 哈希表 & 优先队列
     * @param words
     * @param k
     * @return
     */
    public static  List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(String str:words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        PriorityQueue<Object[]> q= new PriorityQueue<Object[]>(k,(a,b)->{
            // 如果词频不同，根据词频升序
            int c1=(Integer)a[0];
            int c2=(Integer)b[0];
            if(c1!=c2){
                return  c1-c2;
            }
            // 如果词频相同，根据字典序倒序
            String s1 = (String)a[1], s2 = (String)b[1];
            return s2.compareTo(s1);
        });

        for(String s:map.keySet()){
            int cnt=map.get(s);
            if(q.size()<k){ //不足k个，直接入堆
                q.add(new Object[]{cnt,s});
            }
            else{
                Object[] peek = q.peek(); //获取堆顶元素
                if(cnt>(Integer)peek[0]){ //大于堆顶元素 弹出堆顶元素，入堆
                    q.poll();
                    q.add(new Object[]{cnt,s});
                }
                else if(cnt == (Integer)peek[0]){  // 词频与堆顶元素相同
                    String top = (String)peek[1];
                    if (s.compareTo(top) < 0) { // 且字典序大小比堆顶元素小，弹出堆顶元素，入堆
                        q.poll();
                        q.add(new Object[]{cnt,s});
                    }
                }
            }
        }
        while(!q.isEmpty()){
            ans.add((String)q.poll()[1]);
        }
        Collections.sort(ans);
        return ans;
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2)==28,"程序异常");
        topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2);
        System.out.println("-------------运行通过-------------");
    }
}
