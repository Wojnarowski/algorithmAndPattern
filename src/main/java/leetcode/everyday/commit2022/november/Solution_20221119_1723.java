package leetcode.everyday.commit2022.november;

import java.util.Arrays;

/**
 * 1732. 找到最高海拔
 *
 */
public class Solution_20221119_1723 {

    public int largestAltitude(int[] gain) {
        int ans = 0, h = 0;
        for(int x : gain) {
            h += x;
            ans = Math.max(ans, h);
        }
        return ans;
    }
}
