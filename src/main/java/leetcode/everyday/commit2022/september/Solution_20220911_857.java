package leetcode.everyday.commit2022.september;

import leetcode.everyday.TreeNode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 857     修剪二叉搜索树
 *
 *
 *
 */
public class Solution_20220911_857 {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] ds = new double[n][2];
        for (int i = 0; i < n; i++) {
            ds[i][0] = wage[i] * 1.0 / quality[i]; ds[i][1] = i * 1.0;
        }
        Arrays.sort(ds, (a, b)->Double.compare(a[0], b[0]));
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->b-a);
        double ans = 1e18;
        for (int i = 0, tot = 0; i < n; i++) {
            int cur = quality[(int)ds[i][1]];
            tot += cur; q.add(cur);
            if (q.size() > k) tot -= q.poll();
            if (q.size() == k) ans = Math.min(ans, tot * ds[i][0]);
        }
        return ans;
    }

}
