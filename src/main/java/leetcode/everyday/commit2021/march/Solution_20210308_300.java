package leetcode.everyday.commit2021.march;

/**
 *给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *  
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 *
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 *
 *
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 */
public class Solution_20210308_300 {


    public static int lengthOfLIS(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        //记录以nums[i]结尾的最长严格递增子序列
        int []dp = new int[nums.length];
        dp[0]=1;
        int ans =1;
        for(int i=1;i<nums.length;i++){
            //循环找以每个元素为结尾的最长严格递增子序列
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] num1=new int[]{10,9,2,5,3,7,101,18};
        int [] num2=new int[]{0,1,0,3,2,3};
        int [] num3=new int[]{7,7,7,7,7,7,7};
        System.out.println("-------------开始执行-------------");
        System.out.println(lengthOfLIS(num1));
        System.out.println("------------------");
        System.out.println(lengthOfLIS(num2));
        System.out.println("------------------");
        System.out.println(lengthOfLIS(num3));
        System.out.println("-------------运行通过-------------");

    }
}
