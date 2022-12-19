package leetcode.everyday.commit2022.december;

import java.util.ArrayList;
import java.util.List;

/**
 * 1971. 寻找图中是否存在路径
 *
 */
public class Solution_20221219_1971 {
    private int[] root;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        root = new int[n];
        for (int i = 0 ; i < n; i++) root[i] = i;
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
            if (find(source) == find(destination)) return true;
        }
        return find(source) == find(destination);
    }
    private void union(int p, int q) {
        root[find(p)] = find(q);
    }

    private int find(int n) {
        return root[n] == n ? n : (root[n] = find(root[n]));
    }
}

