package leetcode.everyday.commit2022.may;

import leetcode.everyday.TreeNode;

/**
 * 1022 从根到叶的二进制数之和
 *
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 *
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * 示例 2：
 *
 * 输入：root = [0]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 树中的节点数在 [1, 1000] 范围内
 * Node.val 仅为 0 或 1 
 * 通过次数26,683提交次数36,921
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */


public class Solution_20220530_1022 {

    public int sumRootToLeaf(TreeNode root) {
        return this.sumRootToLeaf( root,0);
    }
    private int sumRootToLeaf(TreeNode root, int num) {
        int ans = 0;
        num <<= 1;
        num |= root.val;
        if (root.left == null && root.right == null) {
            return num;
        }
        if (root.left != null) {
            ans += this.sumRootToLeaf(root.left, num);
        }
        if (root.right != null) {
            ans += this.sumRootToLeaf(root.right, num);
        }
        return ans;

    }



    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
