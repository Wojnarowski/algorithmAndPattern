package leetcode.everyday.commit2022.september;

import leetcode.everyday.TreeNode;

/**
 * 669     修剪二叉搜索树
 *
 *
 *
 */
public class Solution_20220910_669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) return trimBST(root.right, low, high);
        else if (root.val > high) return trimBST(root.left, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }


}
