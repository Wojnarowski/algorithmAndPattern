package leetcode.everyday.commit2022.december;

/**
 * 2011. 执行操作后的变量值
 *
 */
public class Solution_20221223_2011 {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            x+=operation.charAt(1)=='+'?1:-1;
        }
        return x;
    }
}

