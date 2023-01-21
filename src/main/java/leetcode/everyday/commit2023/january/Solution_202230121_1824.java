package leetcode.everyday.commit2023.january;

import java.util.Arrays;

/**
 * 1825. 求出 MK 平均值
 */
public class Solution_202230121_1824 {

    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[] dp = new int[3];
        dp[0] = dp[2] = 1;
        for (int i = 1; i < n; i++) {
            int obs = obstacles[i];
            //初始化dp，分两步
            int pre0 = dp[0];
            int pre1 = dp[1];
            int pre2 = dp[2];
            //1.最大值填充
            Arrays.fill(dp, (int)2e9);
            //2.实际障碍物情况：如果 j 位置无障碍物，先更新为刚刚保存的前一位置pre的次数
            if (obs != 1) dp[0] = pre0;
            if (obs != 2) dp[1] = pre1;
            if (obs != 3) dp[2] = pre2;
            //比较从非 j 的位置跳过来，是否次数更小
            if (obs != 1) dp[0] = Math.min(dp[0], Math.min(dp[1], dp[2]) + 1);
            if (obs != 2) dp[1] = Math.min(dp[1], Math.min(dp[0], dp[2]) + 1);
            if (obs != 3) dp[2] = Math.min(dp[2], Math.min(dp[0], dp[1]) + 1);
        }
        return Arrays.stream(dp).min().orElse(-1);

    }

}
