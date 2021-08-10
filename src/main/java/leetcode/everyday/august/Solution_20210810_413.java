package leetcode.everyday.august;


import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 413  等差数列划分
 *
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 *
 * 子数组 是数组中的一个连续序列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 * 通过次数40,957提交次数61,040
 *
 *
 *
 */


public class Solution_20210810_413 {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int start = 0, end = 1, d = nums[1] - nums[0], result = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == d) {
                // 符合等差
                // 若i为最后一项，需要累加一次等差数列数目
                if ((end = i) == nums.length - 1) {
                    result += (end - start) * (end - start - 1) / 2;
                }
            } else {
                // 不符合等差，将下一次开始置于上一个标
                // 若已满3，累加一次等差数列数目
                if (end - start >= 2) {
                    result += (end - start) * (end - start - 1) / 2;
                }
                d = nums[end = i] - nums[start = end - 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{2,2,3,4};

        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(tribonacci(3)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
