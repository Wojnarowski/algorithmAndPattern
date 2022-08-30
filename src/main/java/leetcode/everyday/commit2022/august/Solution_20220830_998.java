package leetcode.everyday.commit2022.august;

import leetcode.everyday.TreeNode;

/**
 * 998 最大二叉树 II
 *
 *
 *
 */
public class Solution_20220830_998 {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        else if(val>root.val){
            TreeNode cur=new TreeNode(val);
            cur.left=root;
            return cur;
        }
        else{
            root.right=insertIntoMaxTree(root.right,val);
            return root;
        }

    }


}
