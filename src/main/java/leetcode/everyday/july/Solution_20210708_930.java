package leetcode.everyday.july;

import java.util.HashMap;
import java.util.Map;

/**
 *q 930 和相同的二元子数组
 *
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 *
 * 子数组 是数组的一段连续部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * 示例 2：
 *
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * nums[i] 不是 0 就是 1
 * 0 <= goal <= nums.length
 *
 *
 */
public class Solution_20210708_930 {

    /**
     * 前缀和
     * 超时了
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length+1;
        int [] preSum= new int[n];
        //构造前缀和数组
        for(int i=1;i<n;i++){
            preSum[i]=preSum[i-1]+nums[i-1];
        }
        int ans =0;
        for(int i=0;i<preSum.length;i++){
            for(int j=i+1;j<preSum.length;j++){
                if(preSum[j]-preSum[i]==goal){
                    ans++;
                }
            }
        }
        return ans;
    }

    public int numSubarraysWithSum2(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum =0;
        int ans =0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-goal)){
                ans += map.get(sum-goal);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(findErrorNums(5)==true,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
