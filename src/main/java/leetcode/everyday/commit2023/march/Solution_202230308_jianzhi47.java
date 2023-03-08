package leetcode.everyday.commit2023.march;

import java.util.*;

/**
 * 2351. 第一个出现两次的字母
 */
public class Solution_202230308_jianzhi47 {
    private int[][] grid, memo;
    public int maxValue(int[][] grid) {
        this.grid = grid;
        int m = grid.length, n = grid[0].length;
        memo = new int[m][n];
        return dfs(grid.length - 1, grid[0].length - 1);
    }
    private int dfs(int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        if (memo[i][j] > 0) // grid[i][j] 都是正数，记忆化的 memo[i][j] 必然为正数
            return memo[i][j];
        return memo[i][j] = Math.max(dfs(i, j - 1), dfs(i - 1, j)) + grid[i][j];
    }

}
