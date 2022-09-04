package leetcode.everyday.commit2022.september;

import java.util.Arrays;

/**
 * 1582   二进制矩阵中的特殊位置
 *
 *
 *
 */
public class Solution_20220904_1582 {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] mm = new int[m], nn = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = mat[i][j];
                if (cur == 1) {
                    mm[i]++;
                    nn[j]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = mat[i][j];
                if (cur == 1 && mm[i] == 1 && nn[j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
