package leetcode.everyday.commit2023.january;

import java.util.*;
import java.util.HashSet;
import java.util.Map;

/**
 * 1815. 得到新鲜甜甜圈的最多组数
 */
public class Solution_202230122_1815 {
    private Map<Long, Integer> memo;
    private int batchSize;
    public int maxHappyGroups(int batchSize, int[] groups) {
        this.batchSize = batchSize;
        memo = new HashMap<Long, Integer>();
        int[] mod = new int[batchSize];
        for (int num : groups) {
            ++mod[num % batchSize];
        }
        int res = mod[0];
        for (int i = 1, end = (batchSize + 1) >> 1; i < end; i++) {
            int mini = Math.min(mod[i], mod[batchSize - i]);
            res += mini;
            mod[i] -= mini;
            mod[batchSize - i] -= mini;
        }
        if ((batchSize & 1) == 0) {
            res += mod[batchSize >> 1] >> 1;
            mod[batchSize >> 1] = ((mod[batchSize >> 1] & 1) == 0) ? 0 : 1;
        }
        long state = 0;
        for (int i = 1; i < batchSize; i++) {
            state += (1L << (i * 5)) * mod[i];
        }
        return res + dfs(state, 0);
    }
    private int dfs(long state, int mod) {
        if (memo.containsKey(state)) {
            return memo.get(state);
        }
        int res = 0;
        int add = mod == 0 ? 1 : 0;
        for (int i = 1; i < batchSize; i++) {
            if ((state >> (i * 5) & 31) != 0) {
                int tmp = dfs(state - (1L << (i * 5)), (mod + i) % batchSize);
                res = Math.max(res, tmp + add);
            }
        }
        memo.put(state, res);
        return res;
    }

}
