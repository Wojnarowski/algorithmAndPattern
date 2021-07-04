package leetcode.everyday.july;

import java.util.*;

/**
 *q 645 错误的集合
 *
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，
 * 导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，
 * 导致集合 丢失了一个数字 并且 有一个数字重复 。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 *
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 *
 *  
 */
public class Solution_20210704_645 {

    public static int[] findErrorNums2(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int ans [] = new int[2];
        for(int i=0;i<nums.length;i++){
                if(!set.contains(nums[i])){
                    set.add(nums[i]);
                }
                else{
                   //重复值
                    ans[0]=nums[i];

                }
        }
        //找丢失的值
        if(ans[0]==1){
            ans[1]=2;
        }else{
            if(!set.contains(ans[0]-1)){
                ans[1]=ans[0]-1;
            } else if(!set.contains(ans[0]+1)){
                ans[1]=ans[0]+1;
            }
        }



        return ans;
    }


    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int [] cnts = new int[n+1];
        for(int x:nums){
            cnts[x]++;
        }
        int [] ans = new int[2];
        for(int i=1;i<=n;i++){
            if (cnts[i] == 0) ans[1] = i;
            if (cnts[i] == 2) ans[0] = i;
        }
        return  ans;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(findErrorNums(5)==true,"程序异常");
        int[] result=  findErrorNums2(new int[]{1,3,3});
        for(int temp:result){
            System.out.println(temp);
        }
        System.out.println("-------------运行通过-------------");
    }
}
