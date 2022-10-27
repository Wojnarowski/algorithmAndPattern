package leetcode.everyday.commit2022.october;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1822. 数组元素积的符号
 */
public class Solution_20221027_1822 {

    public int arraySign(int[] nums) {
        int res = 1;
        for (int num : nums) {
            if (num < 0) {
                res *= -1;
            }
            if (num == 0) {
                return 0;
            }
        }
        return res;
    }
}
