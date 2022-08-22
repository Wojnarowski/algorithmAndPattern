package leetcode.everyday.commit2022.august;

import leetcode.everyday.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 655 输出二叉树
 *
 *
 *
 */
public class Solution_20220822_655 {

    public List<List<String>> printTree(TreeNode root) {
        // 树高从0开始
        int h = depth(root) - 1;

        int m = h + 1;
        int n = (1 << (h + 1)) -1;

        // 构造结果数组
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add("");
            }
            ans.add(list);
        }

        // DFS遍历每个节点
        dfs(ans, root, 0, (n - 1) >> 1, h);

        return ans;
    }
    private void dfs(List<List<String>> ans, TreeNode node, int r, int c, int h) {
        if (node == null) {
            return;
        }

        ans.get(r).set(c, String.valueOf(node.val));

        dfs(ans, node.left, r + 1, c - (1 << (h - r - 1)), h);
        dfs(ans, node.right, r + 1, c + (1 << (h - r - 1)), h);
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }


}
