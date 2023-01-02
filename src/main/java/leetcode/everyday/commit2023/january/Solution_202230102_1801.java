package leetcode.everyday.commit2023.january;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 2351. 第一个出现两次的字母
 */
public class Solution_202230102_1801 {
    int mod = (int)1e9 + 7;
    public int getNumberOfBacklogOrders(int[][] orders) {
        long ans = 0;
        PriorityQueue<int[]> sell = new PriorityQueue<>((a, b)-> a[0] < b[0] ? -1 : 1), buy = new PriorityQueue<>((a, b)-> a[0] < b[0] ? 1 : -1);//a[0] < b[0] ? -1 : 1默认小根堆，a[0] < b[0] ? 1 : -1 大根堆
        for (int[] o : orders) {
            if (o[2] == 0) solove(sell, buy, o, true);//从sell backlog中寻找订单
            else solove(buy, sell, o, false);//从buy backlog中寻找订单
        }
        while (!buy.isEmpty()) ans += buy.poll()[1];
        while (!sell.isEmpty()) ans += sell.poll()[1];
        return (int)(ans % mod);

    }
    void solove(PriorityQueue<int[]> q1, PriorityQueue<int[]> q2, int[] o, boolean ok) {
        while (!q1.isEmpty() && o[1] != 0 && (ok ? q1.peek()[0] <= o[0] : q1.peek()[0] >= o[0])) {//通过ok判断价格是大于等于还是小于等于
            int[] t = q1.poll();
            int cnt = Math.min(o[1], t[1]); //取两者中数量最少的
            o[1] -= cnt;
            t[1] -= cnt;
            if (t[1] > 0) q1.add(t); //若数量还有剩，继续放入堆中
        }
        if (o[1] > 0) q2.add(new int[]{o[0], o[1]}); //若订单还有剩，放入backlog中
    }
}
