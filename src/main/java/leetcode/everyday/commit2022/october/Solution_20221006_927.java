package leetcode.everyday.commit2022.october;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *927  三等分
 *
 *
 */
public class Solution_20221006_927 {

    public int[] threeEqualParts(int[] arr) {
        int[] fail = new int[]{-1, -1};
        // 检查总数
        int n = arr.length, cnt = 0;
        for (int i = 0; i < n; i++) cnt += arr[i];
        if (cnt == 0) return new int[]{0, 2};
        if (cnt % 3 != 0) return fail;
        // 检查间隔相对位
        int t = cnt / 3;
        int[][] ins = new int[3][t];
        for (int i = 0, j = -1, k = 0, p = 0, idx = 0; i < n; i++) {
            if (arr[i] == 0) continue;
            if (j != -1) ins[p][idx++] = i - j;
            if (++k == t) {
                j = -1; k = 0; p++; idx = 0;
            } else {
                j = i;
            }
        }
        for (int i = 0; i < t; i++) {
            if (ins[0][i] == ins[1][i] && ins[0][i] == ins[2][i] && ins[1][i] == ins[2][i]) continue;
            return fail;
        }
        // 构造答案（l1 和 l2 分别为能够划分出最左边 t 个 1 的 左右端点；r1 和 r2 分别为能够划分出最右边 t 个 1 的左右端点）
        int l1 = -1, l2 = -1, r1 = -1, r2 = -1;
        for (int i = 0, k = 0; i < n; i++) {
            k += arr[i];
            if (k == t) {
                if (l1 == -1) l1 = i;
            } else if (k == t + 1) {
                l2 = i - 1;
                break;
            }
        }
        for (int i = n - 1, k = 0; i >= 0; i--) {
            k += arr[i];
            if (k == t) {
                if (r2 == -1) r2 = i;
            } else if (k == t + 1) {
                r1 = i + 1;
                break;
            }
        }
        int d = 0; // d 为最右边一段的后缀 0 的数量
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 1) break;
            d++;
        }
        if (l1 + d > l2 || r1 + d > r2) return fail;
        return new int[]{l1 + d, r1 + d};

    }
}
