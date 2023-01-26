package leetcode.everyday.commit2023.january;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1663. 具有给定数值的最小字符串
 */
public class Solution_202230126_1663 {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int n1 = n;
        while((--n)*26>=k--){//确定最多多少个a
            sb.append('a');
        }
        int m = k/26;//确定最多多少个z
        int t = k - m*26;//剩余差值
        sb.append((char)('a'+t));
        for (int i = 0; i < m; i++) {
            sb.append('z');
        }
        return sb.toString();
    }

}
