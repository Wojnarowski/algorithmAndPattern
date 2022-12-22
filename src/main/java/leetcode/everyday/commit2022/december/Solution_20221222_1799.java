package leetcode.everyday.commit2022.december;

import java.util.Arrays;

/**
 * 1799. N 次操作后的最大分数和
 *
 */
public class Solution_20221222_1799 {
    int n,m,mask;
    int[][] dp;
    public int maxScore(int[] nums) {
        n = nums.length;m = n / 2;
        mask = 1 << n;
        dp = new int[1 << n][m+1];
        return dfs(nums,0,1);
    }
    int dfs(int[] nums,int cur,int cnt){
        if(cnt > m) return 0;
        if(dp[cur][cnt] != 0) return dp[cur][cnt];
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j = i + 1;j<n;j++){
                if(((cur >> i) & 1) == 1 || ((cur >> j) & 1) == 1) continue;
                int next = cur | (1 << i) |(1 << j);
                ans = Math.max(ans,cnt * gcd(nums[i],nums[j]) + dfs(nums,next,cnt + 1));
            }
        }
        dp[cur][cnt] = ans;
        return ans;
    }
    int gcd(int a,int b){
        return b > 0?gcd(b,a%b):a;
    }

}

