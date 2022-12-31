package leetcode.everyday.commit2022.december;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2037. 使每位学生都有座位的最少移动次数
 *
 */
public class Solution_20221231_2037 {

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int n = seats.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(students[i] - seats[i]);
        }
        return ans;
    }
}

