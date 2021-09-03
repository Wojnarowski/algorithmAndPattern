package leetcode.everyday.september;

import org.springframework.util.ObjectUtils;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 *q 17 最小K个数
 *
 *
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *
 *
 */
public class Solution_20210903_17 {

    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue =new PriorityQueue();
        for(int i=0;i<arr.length;i++){
            priorityQueue.add(arr[i]);
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i]=priorityQueue.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(judgeSquareSum(5)==true,"程序异常");
        System.out.println(2^2);
        System.out.println("-------------运行通过-------------");
    }
}
