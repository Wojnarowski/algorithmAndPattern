package leetcode.everyday.commit2022.december;

/**
 * 1769. 移动所有球到每个盒子所需的最小操作数
 *
 */
public class Solution_20221202_1769 {
    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '0') continue;
            for (int j = 0; j < result.length; j++)
                result[j] += Math.abs(j - i); // 当发现字符为'1'时，计算每个盒子的操作数。
        }
        return result;
    }
}
