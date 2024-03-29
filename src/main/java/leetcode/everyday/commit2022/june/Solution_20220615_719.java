package leetcode.everyday.commit2022.june;

import java.util.Arrays;

/**
 * 719      找出第 K 小的数对距离
 *
 * 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
 *
 * 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,1], k = 1
 * 输出：0
 * 解释：数对和对应的距离如下：
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * 距离第 1 小的数对是 (1,1) ，距离为 0 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1,6,1], k = 3
 * 输出：5
 *  
 *
 * 提示：
 *
 * n == nums.length
 * 2 <= n <= 104
 * 0 <= nums[i] <= 106
 * 1 <= k <= n * (n - 1) / 2
 * 通过次数21,883提交次数49,945
 *
 *
 *
 */


public class Solution_20220615_719 {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0;
        int right = nums[len - 1] - nums[0];
        while (left < right) {
            int mid = (left + right) / 2;
            int count = countLessEquals(nums, mid);
            if (count < k) {
                // 如果小于等于 mid 的个数严格小于 k 个，说明 mid 太小了
                // 下一轮搜索区间为 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间为 [left..mid]
                right = mid;
            }
        }
        return left;

    }

    private int countLessEquals(int[] nums, int threshold) {
        int count = 0;
        int len = nums.length;
        for (int left = 0, right = 0; right < len; right++) {
            while (nums[right] - nums[left] > threshold) {
                left++;
            }
            // 此时满足 nums[right] - nums[left] <= threshold
            // right 与 [left..right - 1] 里的每一个元素的「距离」都小于等于 threshold
            // [left..right - 1] 里元素的个数为 right - left
            count += right - left;
        }
        return count;
    }



    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
