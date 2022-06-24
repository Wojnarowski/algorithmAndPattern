package leetcode.everyday.commit2022.june;

import leetcode.everyday.TreeNode;

import java.util.*;

/**
 * 515   在每个树行中找最大值
 *
 *
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 *
 *  
 *
 * 示例1：
 *
 *
 *
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 示例2：
 *
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 *  
 *
 * 提示：
 *
 * 二叉树的节点个数的范围是 [0,104]
 * -231 <= Node.val <= 231 - 1
 *  
 *
 * 通过次数70,443提交次数106,609
 * 请问您在哪类招聘中遇到此题？
 *
 *
 */


public class Solution_20220624_515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //当前层的数量
            int curSize = queue.size();
            //当前层的最大值
            int curMax = Integer.MIN_VALUE;
            for (int i = 0; i < curSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                curMax = Math.max(curMax, node.val);
            }
            ans.add(curMax);
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
