package leetcode.everyday.june;

import java.util.HashSet;
import java.util.Set;

/**
 *q 523 连续的子数组和
 *
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 * 示例 2：
 *
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 * 示例 3：
 *
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 *  
 *
 *
 *  
 */
public class Solution_20210602_523 {

    /**
     * 前缀和 + hash表 + 同余定理
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum[] = new int[nums.length+1];
        for(int i=1;i<sum.length;i++){
            sum[i]=sum[i-1]+nums[i-1];
        }
        Set<Integer> set = new HashSet<>();
        for(int i=2;i<sum.length;i++){
            set.add(sum[i-2]%k);
            if(set.contains(sum[i]%k)){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(judgeSquareSum(5)==true,"程序异常");
        System.out.println(2^2);
        System.out.println("-------------运行通过-------------");
    }
}
