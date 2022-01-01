package leetcode.everyday.commit2021.december;

import java.util.PriorityQueue;

/**
 *q 1005    K 次取反后最大化的数组和
 *
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 *
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 *
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * 示例 2：
 *
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 * 示例 3：
 *
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 *
 *
 */
public class Solution_20211203_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int n = nums.length, idx = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->nums[a]-nums[b]);
        boolean zero = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) q.add(i);
            if (nums[i] == 0) zero = true;
            if (Math.abs(nums[i]) < Math.abs(nums[idx])) idx = i;
        }
        if (k <= q.size()) {
            while (k-- > 0) nums[q.peek()] = -nums[q.poll()];
        } else {
            while (!q.isEmpty() && k-- > 0) nums[q.peek()] = -nums[q.poll()];
            if (!zero && k % 2 != 0) nums[idx] = -nums[idx];
        }
        int ans = 0;
        for (int i : nums) ans += i;
        return ans;
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{1,2,3,1};
        //Assert.isTrue(maxPower("leet")==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
