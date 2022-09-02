package leetcode.everyday.commit2022.september;

import leetcode.everyday.TreeNode;

/**
 * 687   最长同值路径
 *
 *
 *
 */
public class Solution_20220902_687 {
    public int max=0;//记录最大长度
    public int longestUnivaluePath(TreeNode root) {
        if(root==null){
            return 0;
        }
        DFS(root);//深度遍历
        return max;

    }

    private int  DFS(TreeNode root) {
        if(root.left==null && root.right==null){
            return 0;//返回
        }

        int leftsize= root.left!=null? DFS(root.left)+1 :0; //左边
        int rightsize= root.right!=null? DFS(root.right)+1 :0 ;//右边
        //每个节点具有相同值 。
        if(leftsize>0 && root.left.val!=root.val){
            leftsize= 0;
        }
        if(rightsize>0 && root.right.val!=root.val){
            rightsize= 0;
        }

        max=Math.max(max,leftsize+rightsize);//保存最大路径
        return Math.max(leftsize,rightsize);//返回左右

    }
}
