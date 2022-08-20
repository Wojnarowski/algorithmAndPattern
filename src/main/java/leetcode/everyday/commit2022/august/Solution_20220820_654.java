package leetcode.everyday.commit2022.august;

import leetcode.everyday.TreeNode;

/**
 * 654 最大二叉树
 *
 *
 *
 */
public class Solution_20220820_654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
    TreeNode build(int[] nums, int l, int r) {
        if (l > r) return null;
        int idx = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > nums[idx]) idx = i;
        }
        TreeNode ans = new TreeNode(nums[idx]);
        ans.left = build(nums, l, idx - 1);
        ans.right = build(nums, idx + 1, r);
        return ans;
    }

}
