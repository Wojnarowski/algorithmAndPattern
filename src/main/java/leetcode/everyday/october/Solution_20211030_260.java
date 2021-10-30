package leetcode.everyday.october;

import java.util.HashMap;
import java.util.Map;

/**
 *q 260  只出现一次的数字 III
 *
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 *
 *  
 *
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * 示例 2：
 *
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * 示例 3：
 *
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * 提示：
 *
 * 2 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * 除两个只出现一次的整数外，nums 中的其他数字都出现两次
 *
 */
public class Solution_20211030_260 {

    /**
     * hash表统计
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        int[] ans = new int[2];
        int idx = 0;
        for (int i : nums) {
            if (map.get(i) == 1) ans[idx++] = i;
        }
        return ans;
    }

    /**
     * 利用异或先求和
     * 利用除答案以外的元素均出现两次，我们可以先对 numsnums 中的所有元素执行异或操作，得到 sumsum，sumsum 为两答案的异或值（sumsum 必然不为 00）。
     *
     * 然后取 sumsum 二进制表示中为 11 的任意一位 kk，sumsum 中的第 kk 位为 11 意味着两答案的第 kk 位二进制表示不同。
     *
     * 对 nums进行遍历，对第 k 位分别为 0和 1的元素分别求异或和（两答案必然会被分到不同的组），即为答案。
     *
     * @param nums
     * @return
     */
    public int[] singleNumber2(int[] nums) {
        int sum = 0;
        for (int i : nums) sum ^= i;
        int k = -1;
        for (int i = 31; i >= 0 && k == -1; i--) {
            if (((sum >> i) & 1) == 1) k = i;
        }
        int[] ans = new int[2];
        for (int i : nums) {
            if (((i >> k) & 1) == 1) ans[1] ^= i;
             else ans[0] ^= i;
        }
        return ans;
    }

    public int[] singleNumber3(int[] nums) {
        // 所有数异或的结果
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // 取出不同的那个位，我们这里取最右边的那个1
        int bit = xor & (-xor);

        // 按这个位将所有数分成两半分别异或的结果就是我们要找的那两个数
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & bit) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        // 构造返回值
        return new int[] {x, y};
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
//        int [] num1= new int[]{4,1,2};
////        int [] num2= new int[]{1,3,4,2};
        int [] num1= new int[]{2,4};
        int [] num2= new int[]{1,2,3,4};
        //int [] ans = nextGreaterElement(num1,num2);
        //System.out.println(Arrays.toString(ans));

        //Assert.isTrue(arrangeCoins(5)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
