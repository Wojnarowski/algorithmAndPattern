package leetcode.everyday.commit2023.february;

import java.util.Arrays;

/**
 * 1223. 掷骰子模拟
 */
public class Solution_202230210_1223 {

    public int dieSimulator(int n, int[] rollMax) {
        long MOD = (long) (1e9+7);
        long[][] dp = new long[7][n+1];
        for(int i = 0; i <= 6; i++) dp[i][0]=1;
        for(int last = 1; last<=n; last++){
            for(int pre = 0; pre<=6; pre++){//前一个元素
                for(int curr = 1; curr<=6; curr++){//当前元素
                    if(curr == pre) continue;//不连续选相同种类
                    for(int select = 1; select <= Math.min(rollMax[curr-1],last); select++){//当前选当前数目限制个元素
                        //当前元素数目=当前的情况+选了select个curr的情况
                        dp[pre][last] = (dp[pre][last]+dp[curr][last-select])%MOD;
                    }
                }
            }
        }
        return (int) dp[0][n];
    }
}
