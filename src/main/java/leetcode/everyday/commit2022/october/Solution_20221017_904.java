package leetcode.everyday.commit2022.october;

import java.util.Arrays;

/**
 * 904. 水果成篮
 *
 */
public class Solution_20221017_904 {

    public int totalFruit(int[] fruits) {
        int i = 0, j = -1, n = fruits.length, res = 0, a = -1, b = -1, ai = 0, bi = 0;
        while (++j < n) {
            int cur = fruits[j];
            if (cur == a || a == -1) {
                a = cur;
                ai = j;
            } else if (cur == b || b == -1) {
                b = cur;
                bi = j;
            } else {
                res = Math.max(res, j - i);
                if (ai < bi) {
                    i = ai + 1;
                    a = cur;
                    ai = j;
                } else {
                    i = bi + 1;
                    b = cur;
                    bi = j;
                }
            }
        }
        return Math.max(res, j - i);
    }
}
