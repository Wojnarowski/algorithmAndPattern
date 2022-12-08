package leetcode.everyday.commit2022.december;

/**
 * 1812. 判断国际象棋棋盘中一个格子的颜色
 *
 */
public class Solution_20221208_1812 {
    public boolean squareIsWhite(String coordinates) {
        return (coordinates.charAt(0) + coordinates.charAt(1)) % 2 == 1;
    }
}
