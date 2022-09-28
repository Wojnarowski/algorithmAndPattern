package leetcode.everyday.commit2022.september;

import java.util.*;

/**
 * 1709. 第 k 个数
 *
 *
 *
 */
public class Solution_20220928_1709 {
    public int getKthMagicNumber(int k) {
        int[] nums = {3, 5, 7};
        //是否访问 相同的算一次
        Set<Long> visited = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        //初始值为1，即x = 1
        visited.add(1L);
        queue.offer(1L);
        //第k个元素
        int target = 0;
        for (int i = 0; i < k; i++) {
            //弹出堆顶元素
            long poll = queue.poll();
            target = (int) poll;
            for (int num : nums) {
                //依次相乘 即x是 3x、5x、7x也是
                long cur = poll * num;
                //相同元素仅仅加入一次
                if (!visited.contains(cur)) {
                    visited.add(cur);
                    queue.offer(cur);
                }
            }
        }
        return target;

    }

}
