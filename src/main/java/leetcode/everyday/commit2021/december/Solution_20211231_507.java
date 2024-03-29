package leetcode.everyday.commit2021.december;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *q 507  完美数
 *
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 *
 * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 *
 *  
 *
 * 示例 1：
 *
 * 输入：num = 28
 * 输出：true
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 * 示例 2：
 *
 * 输入：num = 6
 * 输出：true
 * 示例 3：
 *
 * 输入：num = 496
 * 输出：true
 * 示例 4：
 *
 * 输入：num = 8128
 * 输出：true
 * 示例 5：
 *
 * 输入：num = 2
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= num <= 108
 * 通过次数60,198提交次数123,591
 *
 *
 *
 */
public class Solution_20211231_507 {

    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int ans = 1;
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) {
                ans += i;
                if (i * i != num) ans += num / i;
            }
        }
        return ans == num;

    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{1,2,3,1};
        //Assert.isTrue(maxPower("leet")==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }


}
