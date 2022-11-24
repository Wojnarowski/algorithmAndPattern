package leetcode.everyday.commit2022.november;

import java.util.* ;

/**
 * 795. 区间子数组个数
 *
 */
public class Solution_20221124_795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length, ans = 0;
        int[] l = new int[n + 10], r = new int[n + 10];
        Arrays.fill(l, -1); Arrays.fill(r, n);
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!d.isEmpty() && nums[d.peekLast()] < nums[i]) r[d.pollLast()] = i;
            d.addLast(i);
        }
        d.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!d.isEmpty() && nums[d.peekLast()] <= nums[i]) l[d.pollLast()] = i;
            d.addLast(i);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] < left || nums[i] > right) continue;
            ans += (i - l[i]) * (r[i] - i);
        }
        return ans;

    }
}
