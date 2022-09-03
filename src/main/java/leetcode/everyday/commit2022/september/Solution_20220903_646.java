package leetcode.everyday.commit2022.september;

import leetcode.everyday.TreeNode;

import java.util.Arrays;

/**
 * 646   最长数对链
 *
 *
 *
 */
public class Solution_20220903_646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b)->a[0]-b[0]);
        int n = pairs.length, ans = 1;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = i - 1; j >= 0 && f[i] == 1; j--) {
                if (pairs[j][1] < pairs[i][0]) f[i] = f[j] + 1;
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
