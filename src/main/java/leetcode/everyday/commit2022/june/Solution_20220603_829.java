package leetcode.everyday.commit2022.june;

import leetcode.everyday.TreeNode;

/**
 * 829   连续整数求和
 *
 * 给定一个正整数 n，返回 连续正整数满足所有数字之和为 n 的组数 。 
 *
 *  
 *
 * 示例 1:
 *
 * 输入: n = 5
 * 输出: 2
 * 解释: 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
 * 示例 2:
 *
 * 输入: n = 9
 * 输出: 3
 * 解释: 9 = 4 + 5 = 2 + 3 + 4
 * 示例 3:
 *
 * 输入: n = 15
 * 输出: 4
 * 解释: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 *  
 *
 * 提示:
 *
 * 1 <= n <= 109​​​​​​​
 * 通过次数23,616提交次数51,837
 *
 *
 *
 *
 */


public class Solution_20220603_829 {

    public int consecutiveNumbersSum(int n) {
        int ans = 0; n *= 2;
        for (int k = 1; k * k < n; k++) {
            if (n % k != 0) continue;
            if ((n / k - (k - 1)) % 2 == 0) ans++;
        }
        return ans;

    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
