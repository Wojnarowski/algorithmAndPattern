package leetcode.everyday.commit2021.april;

import org.springframework.util.Assert;

import java.util.*;

/**
 *q 377 组合总和 Ⅳ
 *
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 示例 2：
 *
 * 输入：nums = [9], target = 3
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 *
 *
 */
public class Solution_20210424_377 {


    private static Map<Integer, Integer> map= new HashMap<Integer ,Integer>();

    /**
     * 递归
     * @param nums
     * @param target
     * @return
     */
    public static  int combinationSum4_1(int[] nums, int target) {
        if(target<0){
            return 0;
        }
        if(target==0){
            return 1;
        }
        int ans =0;
        for(int i=0;i<nums.length;i++){
            ans+=combinationSum4_1(nums,target-nums[i]);
        }
        return ans;
    }

    /**
     * 思路2 动态规划
     * @param nums
     * @param target
     * @return
     */
    public static  int combinationSum4_2(int[] nums, int target) {
        int [] f = new int[target+1];
        f[0]=1;
        for(int j=1 ;j<=target;j++){
            for(int u:nums){
                if(j>=u){
                    f[j]+=f[j-u];
                }
            }
        }
        return f[target];
    }

    /**
     * 思路三 记忆化递归
     * @param nums
     * @param target
     * @return
     */

    // key -> target
    //value -> total number of target

    public static  int combinationSum4_3(int[] nums, int target) {
        return backtrack(nums,target);
    }

    private static int backtrack(int[] nums, int remains) {
        if(remains==0){
            return 1;
        }
        if(map.containsKey(remains)){
            return map.get(remains);
        }
        int res =0 ;
        for(int i=0;i<nums.length;i++){
            if(remains>=nums[i]){
                res+=backtrack(nums,remains-nums[i]);
            }
        }
        map.put(remains,res);
        return res;
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(combinationSum4_3(new int[]{9},3)==0,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
