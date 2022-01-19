package leetcode.everyday.commit2022.january;

import java.util.*;

/**
 * 219  存在重复元素 II
 *
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 示例 3：
 *
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 *  
 *
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 * 通过次数141,614提交次数324,171
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 */
public class Solution_20220119_219 {

    /**
     * 整理题意：是否存在长度不超过的 k + 1k+1 窗口，窗口内有相同元素。
     *
     * 我们可以从前往后遍历 numsnums，同时使用 Set 记录遍历当前滑窗内出现过的元素。
     *
     * 假设当前遍历的元素为 nums[i]nums[i]：
     *
     * 下标小于等于 kk（起始滑窗长度还不足 k + 1k+1）：直接往滑窗加数，即将当前元素加入 Set 中；
     * 下标大于 kk：将上一滑窗的左端点元素 nums[i - k - 1]nums[i−k−1] 移除，判断当前滑窗的右端点元素 nums[i]nums[i] 是否存在 Set 中，若存在，返回 True，否则将当前元素 nums[i]nums[i] 加入 Set 中。
     * 重复上述过程，若整个 numsnums 处理完后仍未找到，返回 False。
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
