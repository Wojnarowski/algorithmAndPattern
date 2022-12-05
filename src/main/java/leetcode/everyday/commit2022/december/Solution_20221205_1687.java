package leetcode.everyday.commit2022.december;

import java.util.ArrayList;
import java.util.*;
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
        dp[0] = 0;
        Deque<int[]> q = new ArrayDeque<int[]>(); //双端队列
        int dif = 0, wei = 0;
        for (int i = 1; i <= n; i++) {
            int cur = dp[i - 1] + 2;//cur为每次滑动窗口增加的值即dp[i-1]+cost[i,i]
            dif += i >= 2 && boxes[i - 1][0] != boxes[i - 2][0] ? 1 : 0;//dif为运输累加值，由于我们无法直接在队列中进行修改，那么可以考虑增加一个累加值
            wei += boxes[i - 1][1]; //重量要加上当前箱子的重量
            while (!q.isEmpty() && q.peekLast()[1] + dif >= cur) q.pollLast(); //构造一个单调递增的队列
            q.add(new int[]{i, cur - dif, boxes[i - 1][1] - wei});
            //判断左端队头是否在窗口外 并且重量不能超过最大重量
            while (q.peekFirst()[0] <= i - maxBoxes || q.peekFirst()[2] + wei > maxWeight) q.pollFirst();
            dp[i] = q.peekFirst()[1] + dif;
        }
        return dp[n];

    }


}
