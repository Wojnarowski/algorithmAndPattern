package leetcode.everyday.commit2022.february;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1984  学生分数的最小差值
 *
 * 给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
 *
 * 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
 *
 * 返回可能的 最小差值 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [90], k = 1
 * 输出：0
 * 解释：选出 1 名学生的分数，仅有 1 种方法：
 * - [90] 最高分和最低分之间的差值是 90 - 90 = 0
 * 可能的最小差值是 0
 * 示例 2：
 *
 * 输入：nums = [9,4,1,7], k = 2
 * 输出：2
 * 解释：选出 2 名学生的分数，有 6 种方法：
 * - [9,4,1,7] 最高分和最低分之间的差值是 9 - 4 = 5
 * - [9,4,1,7] 最高分和最低分之间的差值是 9 - 1 = 8
 * - [9,4,1,7] 最高分和最低分之间的差值是 9 - 7 = 2
 * - [9,4,1,7] 最高分和最低分之间的差值是 4 - 1 = 3
 * - [9,4,1,7] 最高分和最低分之间的差值是 7 - 4 = 3
 * - [9,4,1,7] 最高分和最低分之间的差值是 7 - 1 = 6
 * 可能的最小差值是 2
 *  
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 1000
 * 0 <= nums[i] <= 105
 * 通过次数10,916提交次数17,660
 *
 *
 *
 *
 */
public class Solution_20220211_1984 {

    /**
     * 时间复杂度：排序复杂度为 O(n\log{n})O(nlogn)；遍历得到答案复杂度为 O(n)O(n)。整体复杂度为 O(n\log{n})O(nlogn)
     * 空间复杂度：O(\log{n})O(logn)
     * @param nums
     * @param k
     * @return
     */
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, ans = nums[k - 1] - nums[0];
        for (int i = k; i < n; i++) {
            ans = Math.min(ans, nums[i] - nums[i - k + 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(reversePrefix("abcd",'z').equals("abcd"),"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}