package leetcode.everyday.commit2023.march;

import java.util.HashSet;
import java.util.Set;

/**
 * 2351. 第一个出现两次的字母
 */
public class Solution_202230301_2373 {

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n-2][n-2];
        for (int j = 0; j < n-2; j++) {
            for (int i = 0; i < n-2; i++)
                ans[i][j] = getMax(grid, i+1, j+1);
        }
        return ans;
    }

    public int getMax(int[][] grid, int i, int j) {
        int max = 0;
        for (int x = i-1; x <= i+1; x++) {
            for (int y = j-1; y <= j+1; y++) {
                max = Math.max(max, grid[x][y]);
            }
        }
        return max;
    }
}
