package leetcode.everyday.commit2022.november;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 754. 到达终点数字
 *
 */
public class Solution_20221104_754 {

    public int reachNumber(int target) {
        target = Math.abs(target);
        int s = 0, n = 0;
        while (s < target || (s - target) % 2 == 1) // 没有到达（越过）终点，或者相距奇数
            s += ++n;
        return n;

    }

}
