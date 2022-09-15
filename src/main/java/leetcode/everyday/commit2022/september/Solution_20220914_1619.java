package leetcode.everyday.commit2022.september;

import java.util.Arrays;

/**
 * 1619     最大交换
 *
 *
 *
 */
public class Solution_20220914_1619 {

    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, tot = 0;
        for (int i = n / 20; i < n - n / 20; i++) tot += arr[i];
        return tot * 1.0 / (n * 0.9);
    }

}
