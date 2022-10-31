package leetcode.everyday.commit2022.october;

import java.util.ArrayList;
import java.util.List;

/**
 * 481. 神奇字符串
 */
public class Solution_20221031_481 {

    public int magicalString(int n) {
        char[] arr = new char[n + 20];
        arr[0] = '1'; arr[1] = '2'; arr[2] = '2';
        int cur = 1, l = 2, ans = 0, r = 3;
        while (r < n) {
            if (arr[l] == '1') arr[r++] = (char)('0' + cur);
            else {
                arr[r++] = (char)('0' + cur);
                arr[r++] = (char)('0' + cur);
            }
            cur = 3 - cur;
            l++;
        }
        for (int i = 0; i < n; i++) if (arr[i] == '1') ans++;
        return ans;

    }
}
