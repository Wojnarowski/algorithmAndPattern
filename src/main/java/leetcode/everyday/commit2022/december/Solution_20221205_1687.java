package leetcode.everyday.commit2022.december;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1774. 最接近目标价格的甜点成本
 *
 */
public class Solution_20221205_1687 {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        int[] dp = new int[n + 5];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0; //初始状态为0
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j >= 1 && j >= i - maxBoxes + 1; j--) {
                sum += boxes[j - 1][1]; //累加箱子的种类之和
                if (sum > maxWeight) break; //超过了最大重量
                dp[i] = Math.min(dp[i], dp[j - 1] + cost(boxes, j, i));
            }
        }
        return dp[n];
    }

    int cost(int[][] boxes, int l, int r) {
        int ans = 2, port = boxes[l - 1][0]; //初始话为2,因为返回仓库算一次行程
        while (++l <= r) {
            if (boxes[l - 1][0] == port) continue; //只要相同，那么次数不会增加
            ans++;  //码头不相同运输次数增加1
            port = boxes[l - 1][0];
        }
        return ans;
    }

}
