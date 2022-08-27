package leetcode.everyday.commit2022.august;

import leetcode.everyday.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 662 二叉树最大宽度
 *
 *
 *
 */
public class Solution_20220827_662 {
    Map<Integer, Integer> map = new HashMap<>();
    int ans;
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 0);
        return ans;
    }
    void dfs(TreeNode root, int u, int depth) {
        if (root == null) return ;
        if (!map.containsKey(depth)) map.put(depth, u);
        ans = Math.max(ans, u - map.get(depth) + 1);
        u = u - map.get(depth) + 1;
        dfs(root.left, u << 1, depth + 1);
        dfs(root.right, u << 1 | 1, depth + 1);
    }


}
