package leetcode.everyday.commit2021.july;

import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *q 10 主要元素
 *
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。
 * 若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 *
 *  
 *
 * 示例 1：
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *
 *
 * 示例 2：
 * 输入：[3,2]
 * 输出：-1
 *
 *
 * 示例 3：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * 通过次数41,077提交次数75,309
 *
 *
 *
 */
public class Solution_20210709_1710 {

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
