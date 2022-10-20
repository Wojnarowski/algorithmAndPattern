package leetcode.everyday.commit2022.october;

/**
 * 779. 第K个语法符号
 */
public class Solution_20221020_779 {

    public int kthGrammar(int n, int k) {
        int f = 0;
        while (k >= 1) {
            if (k == 1) {
                if (f % 2 == 0) {
                    return 0;
                } else {
                    return 1;
                }
            }
            int tmp = (int)Math.pow(2, n - 2);
            if (k > tmp) {
                f++;
                k -= tmp;
            }
            n--;
        }
        return 0;
    }
}
