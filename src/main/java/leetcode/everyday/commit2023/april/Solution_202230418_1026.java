package leetcode.everyday.commit2023.april;

import leetcode.everyday.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 节点与其祖先之间的最大差值
 */
public class Solution_202230418_1026 {

    private int ans;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }
    private void dfs(TreeNode root, int mi, int mx) {
        if (root == null) {
            return;
        }
        int x = Math.max(Math.abs(mi - root.val), Math.abs(mx - root.val));
        ans = Math.max(ans, x);
        mi = Math.min(mi, root.val);
        mx = Math.max(mx, root.val);
        dfs(root.left, mi, mx);
        dfs(root.right, mi, mx);
    }

}
