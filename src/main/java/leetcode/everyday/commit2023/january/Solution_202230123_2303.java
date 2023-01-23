package leetcode.everyday.commit2023.january;

import java.util.HashMap;
import java.util.Map;

/**
 * 2303. 计算应缴税款总额
 */
public class Solution_202230123_2303 {
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0.0;
        if (income <= brackets[0][0]) {
            return income * brackets[0][1] * 0.01;
        }
        ans = brackets[0][0] * brackets[0][1] * 0.01;
        int bracketLen = brackets.length;
        if (bracketLen == 1) {
            return ans;
        }
        income -= brackets[0][0];

        for (int i = 1; i < bracketLen && income > 0; i++) {
            int need = Math.min(brackets[i][0] - brackets[i - 1][0], income);
            ans += need * brackets[i][1] * 0.01;
            income -= need;
        }
        return ans;
    }

}
