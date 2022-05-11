package leetcode.everyday.commit2022.may;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *449 序列化和反序列化二叉搜索树
 *
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 树中节点数范围是 [0, 104]
 * 0 <= Node.val <= 104
 * 题目数据 保证 输入的树是一棵二叉搜索树。
 * 通过次数22,235提交次数38,525
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/serialize-and-deserialize-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */


public class Solution_20220511_449 {


      public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder builder = new StringBuilder();
        rserialize(root,builder);
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    private void rserialize(TreeNode root, StringBuilder builder) {
        if (root == null){
            builder.append("#,");
            return;
        }
        builder.append(root.val + ",");
        rserialize(root.left,builder);
        rserialize(root.right,builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0 || data == "") return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }

    private TreeNode dfs(Queue<String> queue) {
        String poll = queue.poll();
        if (poll.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(poll));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }



    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
