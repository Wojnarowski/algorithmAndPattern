package leetcode.everyday.commit2022.october;

import java.util.*;

/**
 * 862. 和至少为 K 的最短子数组
 */
public class Solution_20221026_862 {

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length, res = Integer.MAX_VALUE;
        long sum = 0;
        Deque<long[]> queue = new LinkedList<>();
        queue.offer(new long[]{-1, 0});
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (queue.size() > 0 && sum - queue.peek()[1] >= k) {
                res = (int)Math.min(res, i - queue.poll()[0]);
            }
            while (queue.size() > 0 && queue.peekLast()[1] >= sum) {
                queue.pollLast();
            }
            queue.offer(new long[]{i, sum});
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

}
