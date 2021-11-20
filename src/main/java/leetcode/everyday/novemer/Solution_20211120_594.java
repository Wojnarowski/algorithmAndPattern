package leetcode.everyday.novemer;

import java.util.Arrays;

/**
 *
 * 594  最长和谐子序列
 *
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 *
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [1,1,1,1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * -109 <= nums[i] <= 109
 * 通过次数53,455提交次数95,233
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution_20211120_594 {

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        for (int i = 0, j = 0; j < n; j++) {
            while (i < j && nums[j] - nums[i] > 1) i++;
            if (nums[j] - nums[i] == 1) ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{0,1};
        //Assert.isTrue(missingNumber(array)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
