package leetcode.everyday.commit2022.may;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 961   在长度 2N 的数组中找出重复 N 次的元素
 *
 * 给你一个整数数组 nums ，该数组具有以下属性：
 *
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [5,1,5,2,5,3,5,4]
 * 输出：5
 *  
 *
 * 提示：
 *
 * 2 <= n <= 5000
 * nums.length == 2 * n
 * 0 <= nums[i] <= 104
 * nums 由 n + 1 个 不同的 元素组成，且其中一个元素恰好重复 n 次
 * 通过次数44,950提交次数65,805
 *
 *
 */


public class Solution_20220521_961 {
    int[] cnts = new int[10010];

    public int repeatedNTimes(int[] nums) {
        for (int x : nums) {
            if (++cnts[x] > 1) return x;
        }
        return -1;

    }

    int higher_find(int[] starts, int target) {
        if (target > starts[starts.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = starts.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (starts[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
