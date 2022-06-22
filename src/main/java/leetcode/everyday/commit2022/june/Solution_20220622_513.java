package leetcode.everyday.commit2022.june;

import leetcode.everyday.TreeNode;

/**
 * 513   找树左下角的值
 *
 *
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 *
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 *
 *
 *
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *  
 *
 * 提示:
 *
 * 二叉树的节点个数的范围是 [1,104]
 * -231 <= Node.val <= 231 - 1 
 * 通过次数99,722提交次数135,706
 * 请问您在哪类招聘中遇到此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 */


public class Solution_20220622_513 {

    int h = 0, val = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return val;
    }
    public void dfs(TreeNode root, int height) {
        if (root != null) {
            if (height > h) {
                h = height;
                val = root.val;
            }
            dfs(root.left, height + 1);
            dfs(root.right, height + 1);
        }
    }


    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
