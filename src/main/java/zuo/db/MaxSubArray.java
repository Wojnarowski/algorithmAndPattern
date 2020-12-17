package zuo.db;

public class MaxSubArray {

    public static int maxSubArray(int [] nums){
        //构造子问题，db[n] 是代表以n为结尾的最大子序和
        int [] dp=new int[nums.length];
        //状态初始化
        dp[0]=nums[0];
        int ans=dp[0];
        for(int i=1;i<dp.length;i++) {
            // 分离指标函数，列出状态转移方程
            dp[i]=Math.max(dp[i-1],0)+nums[i];
            //最优解是最优子结构中的最大值
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("maxSubArray="+maxSubArray(nums));
    }

}
