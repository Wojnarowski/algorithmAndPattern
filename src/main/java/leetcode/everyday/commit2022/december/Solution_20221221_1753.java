package leetcode.everyday.commit2022.december;

import java.util.Arrays;

/**
 * 1753. 移除石子的最大得分
 *
 */
public class Solution_20221221_1753 {

    public int maximumScore(int a, int b, int c) {
        int ans = 0;
        int[] rec = new int[]{a, b, c};
        Arrays.sort(rec);
        while (rec[0] != 0 || rec[1] != 0) {
            ans++;
            rec[1]--; rec[2]--;
            Arrays.sort(rec);
        }
        return ans;
    }
}

