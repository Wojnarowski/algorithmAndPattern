package leetcode.everyday.commit2023.january;

import java.util.*;

/**
 * 1806. 还原排列的最少操作步数
 */
public class Solution_202230110_753 {

    public String crackSafe(int n, int k) {
        //初始化的扩散seed
        StringBuilder seed = new StringBuilder(String.join("", Collections.nCopies(n, "0")));
        Set<String> vis = new HashSet<>();
        vis.add(seed.toString());
        int t = (int) Math.pow(k, n);//目标的组合数量
        dfs(seed, vis, t, n, k);
        return seed.toString();
    }
    private boolean dfs(StringBuilder seed, Set<String> vis, int t, int n, int k) {
        if (vis.size() == t) return true;//出口条件，组合数到达目标的组合数量
        String last = seed.substring(seed.length() - n + 1);//最后的n-1个字符
        for (char c = '0'; c < '0' + k; c++) {
            String tmp = last + c;
            if (!vis.contains(tmp)) {
                vis.add(tmp);
                seed.append(c);
                if (dfs(seed, vis, t, n, k)) return true;
                vis.remove(tmp);
                seed.deleteCharAt(seed.length() - 1);
            }
        }
        return false;
    }
}
