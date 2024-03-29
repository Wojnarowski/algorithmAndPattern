package leetcode.everyday.commit2021.august;

/**
 * 581.最短无序连续子数组
 *
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [2,6,4,8,10,9,15]
 *
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：0
 *
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：0
 *  
 *
 * 提示：
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 *  
 *
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 *
 *
 *
 */


public class Solution_20210803_581 {

    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int small=nums[n-1],big=nums[0];
        int l=-1,r=-2;
        for(int i=n-1;i>=0;--i){
            small=Math.min(small,nums[i]);
            if(nums[i]>small){
                l=i;
            }
        }
        for(int i=0;i<n;++i){
            big=Math.max(big,nums[i]);
            if(nums[i]<big){
                r=i;
            }
        }
        return r-l+1;

    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
