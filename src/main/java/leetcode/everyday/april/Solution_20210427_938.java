package leetcode.everyday.april;

import leetcode.everyday.TreeNode;

import java.util.Arrays;

/**
 *q 938 二叉搜索树的范围和
 *
 *给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * 示例 2：
 *
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 2 * 104] 内
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * 所有 Node.val 互不相同
 *
 *
 */
public class Solution_20210427_938 {

    int low, high;
    int ans;
    public int rangeSumBST(TreeNode root, int _low, int _high) {
        low=_low;high=_high;
        dfs(root);
        return  ans;
    }

    private void dfs(TreeNode root) {
        if(root==null){
            return;
        }
        dfs(root.left);
        if (low <= root.val && root.val <= high){
            ans += root.val;
        }
        dfs(root.right);
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(combinationSum4_3(new int[]{9},3)==0,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
