package leetcode.everyday.commit2023.february;

import leetcode.everyday.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 2331. 计算布尔二叉树的值
 */
public class Solution_202230206_2331 {

    public boolean evaluateTree(TreeNode root) {
        if(root == null) {
            return false;
        }
        int resVal = dfs(root);

        if(resVal == 1) {
            return true;
        }
        return false;
    }

    private int dfs(TreeNode root) {
        if(root == null) {
            return -1;
        }

        if(root.left == null && root.right == null) {
            return root.val;
        }
        int leftVal = dfs(root.left);
        int rightVal = dfs(root.right);

        if(root.val == 3) {
            return Math.min(leftVal, rightVal);
        }
        if(root.val == 2) {
            return Math.max(leftVal, rightVal);
        }
        return -1;
    }



}
