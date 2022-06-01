package leetcode.everyday.commit2022.june;

import java.util.Arrays;

/**
 * 473   火柴拼正方形
 *
 *
 * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 *
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 *
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入: matchsticks = [1,1,2,2,2]
 * 输出: true
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 *
 * 输入: matchsticks = [3,3,3,3,4]
 * 输出: false
 * 解释: 不能用所有火柴拼成一个正方形。
 *  
 *
 * 提示:
 *
 * 1 <= matchsticks.length <= 15
 * 1 <= matchsticks[i] <= 108
 * 通过次数31,251提交次数72,872
 *
 *
 *
 *
 */


public class Solution_20220601_473 {

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 4 != 0) return false;
        int target = sum / 4;
        Arrays.sort(matchsticks);
        return backtrack(matchsticks, target, matchsticks.length - 1, new int[4]);

    }

    private boolean backtrack(int[] matchsticks, int target, int index, int[] len) {
        if (index == -1) {
            return len[0] == len[1] && len[1] == len[2] && len[2] == len[3];
        }
        for (int i = 0; i < 4; i++) {
            if (len[i] + matchsticks[index] > target || (i > 0 && len[i] == len[i - 1])) continue;
            len[i] += matchsticks[index];
            if (backtrack(matchsticks, target, index - 1, len))
                return true;
            len[i] -= matchsticks[index];
        }
        return false;
    }


    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
