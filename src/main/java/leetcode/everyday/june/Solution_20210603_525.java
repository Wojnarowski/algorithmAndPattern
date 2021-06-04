package leetcode.everyday.june;

import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 *q 525 连续数组
 *
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 *
 *  
 *
 *
 *  
 */
public class Solution_20210603_525 {

    /**
     * 前缀和+hash表
     *  TODO 并不是1和0间隔出现
     * @param nums
     * @return
     */
    public  static int findMaxLength(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 0;
        }
        int sum[] = new int [nums.length+1];
        for(int i=1;i<=nums.length;i++){
            sum[i]=sum[i-1]+ (nums[i-1]==1?1:-1);
        }
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=2;i<=nums.length;i++){
            if(!map.containsKey(sum[i-2])){
                map.put(sum[i-2],i-2);
            }
            if(map.containsKey(sum[i])){
                ans =Math.max(ans,i-map.get(sum[i]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(findMaxLength(new int[]{1,0,1,0,1})==5,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
