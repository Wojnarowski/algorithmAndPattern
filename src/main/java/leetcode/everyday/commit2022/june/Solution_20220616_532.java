package leetcode.everyday.commit2022.june;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 532      数组中的 k-diff 数对
 *
 * 给定一个整数数组和一个整数 k，你需要在数组里找到 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 *
 * 这里将 k-diff 数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
 *
 * 0 <= i < j < nums.length
 * |nums[i] - nums[j]| == k
 * 注意，|val| 表示 val 的绝对值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3, 1, 4, 1, 5], k = 2
 * 输出：2
 * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * 示例 2：
 *
 * 输入：nums = [1, 2, 3, 4, 5], k = 1
 * 输出：4
 * 解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 * 示例 3：
 *
 * 输入：nums = [1, 3, 1, 5, 4], k = 0
 * 输出：1
 * 解释：数组中只有一个 0-diff 数对，(1, 1)。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -107 <= nums[i] <= 107
 * 0 <= k <= 107
 * 通过次数32,570提交次数81,406
 *
 *
 *
 */


public class Solution_20220616_532 {

    public int findPairs(int[] nums, int k) {
        //直接开1e4的空间，减少hash表扩容的时间
        Set<Integer> numSet = new HashSet<>((int) 1e4);
        //用set去重
        Set<Integer> ans = new HashSet<>((int) 1e4);
        //只存放数对(x,y)中的x即可
        for (int num : nums) {
            if (numSet.contains(num - k)) {
                ans.add(num - k);
            }
            if (numSet.contains(num + k)) {
                ans.add(num);
            }
            numSet.add(num);
        }
        return ans.size();

    }


    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
