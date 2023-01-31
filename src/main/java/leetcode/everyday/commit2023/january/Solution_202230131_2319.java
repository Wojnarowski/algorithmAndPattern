package leetcode.everyday.commit2023.january;

import leetcode.everyday.ListNode;

/**
 * 2319. 判断矩阵是否是一个 X 矩阵
 */
public class Solution_202230131_2319 {
    public boolean checkXMatrix(int[][] grid) {
        int l = grid.length - 1;
        for(int i = 0; i <= l; i++){
            for(int j = 0; j <= l; j++){
                if(i == j || i + j == l) {
                    if(grid[i][j] == 0) return false;
                }else{
                    if(grid[i][j] != 0) return false;
                }
            }
        }
        return true;
    }
}
