package leetcode.everyday.commit2022.april;

import java.util.ArrayList;
import java.util.List;

/**
 * 905   按奇偶排序数组
 *
 * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，
 * 后跟所有奇数元素。
 *
 * 返回满足此条件的 任一数组 作为答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,1,2,4]
 * 输出：[2,4,3,1]
 * 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[0]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * 0 <= nums[i] <= 5000
 * 通过次数94,413提交次数132,739
 *
 *
 */
public class Solution_20220428_905 {

    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        for (int i = 0, j = n - 1; i < j; i++) {
            if (nums[i] % 2 == 1) {
                int c = nums[j];
                nums[j--] = nums[i];
                nums[i--] = c;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
