package leetcode.everyday.commit2022.may;

/**
 * 0406   后继者
 *
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 * 通过次数42,630提交次数68,922
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/successor-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 */


public class Solution_20220516_0406 {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val <= p.val) return inorderSuccessor(root.right, p);
        TreeNode ans = inorderSuccessor(root.left, p);
        return ans == null ? root : ans;
    }


    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
