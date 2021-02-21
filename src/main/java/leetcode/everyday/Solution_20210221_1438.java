package leetcode.everyday;

import org.springframework.util.Assert;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 *给你一个整数数组 nums ，和一个表示限制的整数 limit，
 * 请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 *
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 * 示例 2：
 *
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 * 示例 3：
 *
 * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 * 输出：3
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 *
 */


public class Solution_20210221_1438 {

    /**
     * 思路 1.大方向利用滑动窗口
     *      2.数组中的最大值和最小值利用好数据接口保证取的时候时间复杂度是O(1)
     *
     * @param nums
     * @param limit
     * @return
     */
    public static int longestSubarray1(int[] nums, int limit) {
        //前置判断
        if(nums.length<=0 || nums==null){
            return 0;
        }
        //保存窗口内数组最大值的双端队列
        Deque <Integer> maxQueue = new ArrayDeque<>();
        //保存窗口内数组最小值的双端队列
        Deque <Integer> minQueue = new ArrayDeque<>();
        //定义窗口左右下标和返回值
        int right=0,left=0,res=0;
        //窗口右移的条件
        while(right<nums.length){
            /**
             * 判断此时最大值双端队列中是否有比当前值大的值，如果有就移除后-->前判断
             * 如当前 队列中值为 1<-2<-4   此时nums[right] 为5
             * 则变换规则如下
             * 1<-2<-4
             * 1<-2
             * 1
             * null
             * 5
             */
            while(!maxQueue.isEmpty() && nums[right]>maxQueue.peekLast()){
                maxQueue.removeLast();
            }
            //和最大队列类似
            while(!minQueue.isEmpty() && nums[right]<minQueue.peekLast()){
                minQueue.removeLast();
            }
            /**
             *都清除完成后将符合条件数据加到相应队列后面,此时保证最大队列中的数为当前窗口数组中最大的，
             * 最小队列中的数为当前窗口中最下的
             */
            maxQueue.addLast(nums[right]);
            minQueue.addLast(nums[right]);
            //窗口右侧指针向右移动
            right++;
            //如果最大数减去最小数 不满足条件，此时左指针向右移动
            while(maxQueue.peekFirst() - minQueue.peekFirst()>limit){
                if(maxQueue.peekFirst() == nums[left]){
                    maxQueue.removeFirst();
                }
                if(minQueue.peekFirst() == nums[left]){
                    minQueue.removeFirst();
                }
                left++;
            }
            //和返回值比较,此时right - left之后不用+1
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] a1 = new int[]{8,2,4,7};
        int [] a2 = new int[]{10,1,2,4,7,2};
        int [] a3 = new int[]{4,2,2,2,4,4,2,2};

        System.out.println("-------------开始执行-------------");
        Assert.isTrue(longestSubarray1(a1,4)==2,"程序异常");
        Assert.isTrue(longestSubarray1(a2,5)==4,"程序异常");
        Assert.isTrue(longestSubarray1(a3,0)==3,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
