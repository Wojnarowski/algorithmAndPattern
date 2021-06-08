package leetcode.everyday.june;

import org.springframework.util.Assert;

/**
 *q 494 目标和
 *
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 *
 * 输入：nums = [1], target = 1
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 100
 *
 *
 */
public class Solution_20210607_494 {

    /**
     * DFS写法
     * 数据范围只有 2020，而且每个数据只有 +/-+/− 两种选择，因此可以直接使用 DFS 进行「爆搜」。
     *
     * 而 DFS 有「使用全局变量维护」和「接收返回值处理」两种形式。
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWaysDFS(int[] nums, int target) {
        return dfs(nums,target,0,0);
    }

    private int dfs(int[] nums, int target, int index, int sum) {
        if(index==nums.length){
            return sum==target?1:0;
        }
        int left=dfs(nums,target,index+1,sum+nums[index]);
        int right=dfs(nums,target,index+1,sum-nums[index]);
        return left + right;
    }

    /**
     * 动态规划
     * dp[i][j]=dp[i-1][j+nums[i]]+dp[i-1][j-nums[i]]
     * @param nums
     * @param s
     * @return
     */
    public int findTargetSumWaysDP(int[] nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        // 绝对值范围超过了sum的绝对值范围则无法得到
        if (Math.abs(s) > Math.abs(sum)) return 0;
        int len = nums.length;
        int range = sum * 2 + 1;//因为要包含负数所以要两倍，又要加上0这个中间的那个情况
        int[][] dp = new int[len][range];//这个数组是从总和为-sum开始的
        //加上sum纯粹是因为下标界限问题，赋第二维的值的时候都要加上sum
        // 初始化   第一个数只能分别组成+-nums[i]的一种情况
        dp[0][sum + nums[0]] += 1;
        dp[0][sum - nums[0]] += 1;
        for (int i = 1; i < len; i++) {
            for (int j = -sum; j <= sum; j++) {
                if((j+nums[i]) > sum) {//+不成立 加上当前数大于了sum   只能减去当前的数
                    dp[i][j+sum] = dp[i-1][j-nums[i]+sum]+0;
                }else if((j-nums[i]) < -sum) {//-不成立  减去当前数小于-sum   只能加上当前的数
                    dp[i][j+sum] = dp[i-1][j+nums[i]+sum]+0;
                }else {//+-都可以
                    dp[i][j+sum] = dp[i-1][j+nums[i]+sum]+dp[i-1][j-nums[i]+sum];
                }
            }
        }
        return dp[len - 1][sum + s];
    }

    /**
     * 套用背包规则
     * @param nums
     * @param S
     * @return
     */
    public  static int findTargetSumWaysDP1(int[] nums, int S) {
        int n = nums.length;
        int sum = 0;
        for (int i=0;i<n;i++) {

            sum += nums[i];
        }

        if(S > sum || (S + sum) % 2 == 1) return 0;

        int target = (S + sum) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i=0;i<n;i++){

            for (int j=target;j>=nums[i];j--) {

                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[target];
    }



    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(findTargetSumWaysDP1(new int[]{1,1,1,1,1},3)==5,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
