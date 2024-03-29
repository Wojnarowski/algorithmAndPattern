package leetcode.everyday.commit2023.march;

import java.util.HashMap;
import java.util.*;
import java.util.Map;

/**
 * 1617. 统计子树中城市之间最大距离
 */
public class Solution_202230312_1617 {
    private List<Integer>[] g;
    private int msk;
    private int nxt;
    private int mx;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0] - 1, v = e[1] - 1;
            g[u].add(v);
            g[v].add(u);
        }
        int[] ans = new int[n - 1];
        for (int mask = 1; mask < 1 << n; ++mask) {
            if ((mask & (mask - 1)) == 0) {
                continue;
            }
            msk = mask;
            mx = 0;
            int cur = 31 - Integer.numberOfLeadingZeros(msk);
            dfs(cur, 0);
            if (msk == 0) {
                msk = mask;
                mx = 0;
                dfs(nxt, 0);
                ++ans[mx - 1];
            }
        }
        return ans;
    }

    private void dfs(int u, int d) {
        msk ^= 1 << u;
        if (mx < d) {
            mx = d;
            nxt = u;
        }
        for (int v : g[u]) {
            if ((msk >> v & 1) == 1) {
                dfs(v, d + 1);
            }
        }
    }

}
