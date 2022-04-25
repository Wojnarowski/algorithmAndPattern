package leetcode.everyday.commit2022.april;

import java.util.Random;

/**
 * 398   随机数索引
 *
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 *
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 *
 * 示例:
 *
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 *
 * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
 * solution.pick(3);
 *
 * // pick(1) 应该返回 0。因为只有nums[0]等于1。
 * solution.pick(1);
 * 通过次数22,366提交次数32,341
 * 请问您在哪类招聘中遇到此题？
 *
 *
 */
public class Solution_20220425_398 {
    int[] nums;
    Random rd;
    public Solution(int[] nums) {
        this.nums = nums;
        rd = new Random();
    }

    public int pick(int target) {
        int ans = 0;
        for (int i = 0, cnt = 0; i < nums.length; ++i){
            if (nums[i] == target && rd.nextInt(++cnt) == 0) {
                // 水塘抽样
                ans = i;
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
