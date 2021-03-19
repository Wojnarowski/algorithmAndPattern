package leetcode.everyday.February;

import java.util.HashMap;
import java.util.Map;

/**
 *给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2：
 *
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 *  
 *
 * 提示：
 *
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Solution_20210220_697 {

    /**
     * 思路 1.利用hash key 为值  value 为次数  找出度
     *      2.利用滑动窗口找到 长度为degree的数组
     * @param nums
     * @return
     */
    public static int findShortestSubArray1(int[] nums) {
        if(nums ==null || nums.length<=0){
            return 0;
        }

        //存放 值 - 次数
        Map<Integer ,Integer> counter = new HashMap<Integer ,Integer>();
        int degree =0;
        for(int i=0;i<nums.length;i++){
            if(counter.get(nums[i])!=null){
                counter.put(nums[i],counter.get(nums[i])+1);
                degree=Math.max(degree,counter.get(nums[i]));
            }
            else{
                counter.put(nums[i],1);
                degree=Math.max(degree,1);
            }
        }
        System.out.println("--------degree="+degree);
        //2.利用窗口找数组
        int left=0,right=0,length=nums.length;
        int res=length;
        Map<Integer ,Integer> slipWindowUse = new HashMap<Integer ,Integer>();

        while (right<length){
            slipWindowUse.put(nums[right],slipWindowUse.getOrDefault(nums[right],0)+1);
            right++;
            while(slipWindowUse.get(nums[right-1])==degree){
                slipWindowUse.put(nums[left], slipWindowUse.get(nums[left]) - 1);
                res = Math.min(res, right - left);
                left++;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int [] a = new int[]{1, 2, 2, 3, 1};
        int [] a1 = new int[]{1, 2};
        int [] a2 = new int[]{1};
        int [] a3 = new int[]{1, 2, 3, 2, 1};
        int [] a4 = new int[]{1, 2, 3, 2, 4,5,6,7,8};

        System.out.println(findShortestSubArray1(a3));
    }
}
