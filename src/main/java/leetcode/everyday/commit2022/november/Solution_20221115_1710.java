package leetcode.everyday.commit2022.november;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1710. 卡车上的最大单元数
 *
 */
public class Solution_20221115_1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length, ans = 0;
        Arrays.sort(boxTypes, (a,b)->b[1]-a[1]);
        for (int i = 0, cnt = 0; i < n && cnt < truckSize; i++) {
            int a = boxTypes[i][0], b = boxTypes[i][1], c = Math.min(a, truckSize - cnt);
            cnt += c; ans += c * b;
        }
        return ans;
    }
}
