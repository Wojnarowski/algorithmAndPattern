package leetcode.everyday.commit2023.february;

import leetcode.everyday.TreeNode;

import java.util.*;

/**
 * 1145. 二叉树着色游戏
 */
public class Solution_202230203_1145 {

    int[] sums;
    int x;
    TreeNode xNode = null;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.x = x;
        sums = new int[n+1];
        fillSums(root);
        return sums[root.val]-sums[x]>sums[x] ||
                (xNode.left!=null && sums[xNode.left.val]>sums[root.val]-sums[xNode.left.val]) ||
                (xNode.right!=null && sums[xNode.right.val]>sums[root.val]-sums[xNode.right.val]);
    }

    private int fillSums(TreeNode root){
        if(root == null) return 0;
        if(root.val == x) xNode = root;
        sums[root.val] = 1+fillSums(root.left)+fillSums(root.right);
        return sums[root.val];
    }

}
