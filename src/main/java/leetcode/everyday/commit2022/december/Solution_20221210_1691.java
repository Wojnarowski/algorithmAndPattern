package leetcode.everyday.commit2022.december;

import java.util.Arrays;

/**
 * 1691. 堆叠长方体的最大高度
 *
 */
public class Solution_20221210_1691 {
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length, ans = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) Arrays.sort(cuboids[i]);
        Arrays.sort(cuboids, (a, b) -> a[0] == b[0] ? (a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]) : a[0] - b[0]);//从第一个元素从小到大进行排序，若相等按照第二个元素，若还相等按照第三个元素
        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[i][1] >= cuboids[j][1] && cuboids[i][2] >=  cuboids[j][2]) dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
