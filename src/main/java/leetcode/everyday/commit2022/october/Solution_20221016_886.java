package leetcode.everyday.commit2022.october;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 886. 可能的二分法
 *
 */
public class Solution_20221016_886 {

    int N = 2010, M = 2 * 10010;
    int[] he = new int[N], e = new int[M], ne = new int[M], color = new int[N];
    int idx;
    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }
    boolean dfs(int u, int cur) {
        color[u] = cur;
        for (int i = he[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (color[j] == cur) return false;
            if (color[j] == 0 && !dfs(j, 3 - cur)) return false;
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] ds) {
        Arrays.fill(he, -1);
        for (int[] info : ds) {
            int a = info[0], b = info[1];
            add(a, b); add(b, a);
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] != 0) continue;
            if (!dfs(i, 1)) return false;
        }
        return true;
    }
}
