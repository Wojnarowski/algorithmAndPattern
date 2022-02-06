package leetcode.everyday.commit2022.february;

import java.util.Arrays;

/**
 * 1748  唯一元素的和
 *
 * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
 *
 * 请你返回 nums 中唯一元素的 和 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,2]
 * 输出：4
 * 解释：唯一元素为 [1,3] ，和为 4 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1,1]
 * 输出：0
 * 解释：没有唯一元素，和为 0 。
 * 示例 3 ：
 *
 * 输入：nums = [1,2,3,4,5]
 * 输出：15
 * 解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 通过次数32,988提交次数41,723
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-unique-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution_20220206_1748 {
    public int sumOfUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && nums[j] == nums[i]) j++;
            if (j - i == 1) ans += nums[i];
            i = j;
        }
        return ans;
    }

    int[] cnt = new int[110];
    public int sumOfUnique2(int[] nums) {
        for (int i : nums) cnt[i]++;
        int ans = 0;
        for (int i = 1; i <= 100; i++) {
            if (cnt[i] == 1) ans += i;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(reversePrefix("abcd",'z').equals("abcd"),"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
