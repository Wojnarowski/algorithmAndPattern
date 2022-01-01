package leetcode.everyday.commit2021.july;

import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 *q 981  基于时间的键值存储
 *
 * 创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
 *
 * 1. set(string key, string value, int timestamp)
 *
 * 存储键 key、值 value，以及给定的时间戳 timestamp。
 * 2. get(string key, int timestamp)
 *
 * 返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp。
 * 如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
 * 如果没有值，则返回空字符串（""）。
 *  
 *
 * 示例 1：
 *
 * 输入：inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
 * 输出：[null,null,"bar","bar",null,"bar2","bar2"]
 * 解释： 
 * TimeMap kv;  
 * kv.set("foo", "bar", 1); // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1  
 * kv.get("foo", 1);  // 输出 "bar"  
 * kv.get("foo", 3); // 输出 "bar" 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"）  
 * kv.set("foo", "bar2", 4);  
 * kv.get("foo", 4); // 输出 "bar2"  
 * kv.get("foo", 5); // 输出 "bar2"  
 *
 * 示例 2：
 *
 * 输入：inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs = [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
 * 输出：[null,null,null,"","high","high","low","low"]
 *  
 *
 * 提示：
 *
 * 所有的键/值字符串都是小写的。
 * 所有的键/值字符串长度都在 [1, 100] 范围内。
 * 所有 TimeMap.set 操作中的时间戳 timestamps 都是严格递增的。
 * 1 <= timestamp <= 10^7
 * TimeMap.set 和 TimeMap.get 函数在每个测试用例中将（组合）调用总计 120000 次。
 * 通过次数7,510提交次数14,968
 *
 *
 */
public class Solution_20210710_981 {

    class TimeMap {

        class Node{
            String k,v;
            int t;
            Node(String _k,String _v, int _t){
                k=_k;v=_v;t=_t;
            }
        }
        Map<String, List<Node>> map = new HashMap<>();


        /** Initialize your data structure here. */
        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            List<Node> list =map.getOrDefault(key,new ArrayList<>());
            list.add(new Node(key,value,timestamp));
            map.put(key,list);
        }

        public String get(String key, int timestamp) {
            List<Node> list = map.getOrDefault(key, new ArrayList<>());
            if(CollectionUtils.isEmpty(list)){
                return "";
            }
            int n=list.size();
            int l=0,r=n-1;
            while(l<r){
                int mid =l+r+1>>1;
                if(list.get(mid).t<=timestamp){
                    l=mid;
                }else{
                    r=mid-1;
                }
            }
            return list.get(r).t <=timestamp ?list.get(r).v:"";
        }
    }



    /**
     * priorityQueue
     * @param nums
     * @return
     */

    public static  int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>((a,b)->{
            if(b.v!=a.v){
                return b.v-a.v;
            }
            return 0;
        });

        for(int c:map.keySet()){
            priorityQueue.add(new Node(c, map.get(c)));
        }

        Node poll  = priorityQueue.poll();
        if(poll.v>nums.length/2){
            return poll.c;
        }
        return -1;

    }


    static class  Node{
        int c;
        int v;

        Node(int _c ,int _v){
            c=_c;
            v=_v;
        }
    }


    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public static  int majorityElement2(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        int length = nums.length;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count * 2 > length ? candidate : -1;
    }
    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(majorityElement(new int[]{1,2,5,9,5,9,5,5,5})==5,"程序异常");
        //Assert.isTrue(majorityElement(new int[]{3,2})==-1,"程序异常");
        Assert.isTrue(majorityElement(new int[]{1,2,5,9,5,9,5,5,5})==5,"程序异常");

        System.out.println("-------------运行通过-------------");
    }
}
