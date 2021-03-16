package leetcode.github.slidwindow;

import leetcode.everyday.AlgorithmUtil;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * q15_三数之和
 *给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 *
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 *
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 */
public class Solution15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums==null || nums.length<3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        if(nums[0]>0){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            //三个数里面两个相同，组成的数组肯定是一个
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left=i + 1,right= nums.length-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum==0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(sum>0){
                    right--;
                }
                else{
                    left--;
                }
            }

        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(maxArea(new int[]{1,2,1})==2,"程序异常");
        List<List<Integer>> list = threeSum(new int []{-1,0,1,2,-1,-4});

        System.out.println("-------------运行通过-------------");
    }
}
