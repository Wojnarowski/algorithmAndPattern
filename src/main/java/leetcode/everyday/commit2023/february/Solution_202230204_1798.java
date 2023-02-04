package leetcode.everyday.commit2023.february;

import leetcode.everyday.TreeNode;

import java.util.Arrays;

/**
 * 1798. 你能构造出连续值的最大数目
 */
public class Solution_202230204_1798 {

    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);

        int r = 1;
        for(int coin : coins) {
            if(coin > r) { break; }
            r += coin;
        }

        return r;
    }
}
