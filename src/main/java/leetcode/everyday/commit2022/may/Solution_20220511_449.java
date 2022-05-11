package leetcode.everyday.commit2022.may;

import java.util.*;

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
        StringBuilder sb = new StringBuilder();
        dfs_s(root, sb);
        return sb.toString();
    }

    void dfs_s(TreeNode cur, StringBuilder sb){
        // 空结点不序列化
        if(cur == null) return;
        sb.append(cur.val + " ");
        dfs_s(cur.left, sb);
        dfs_s(cur.right, sb);
    }

    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        List<Integer> list = new ArrayList<>();
        for(String str : data.split(" ")){
            list.add(Integer.parseInt(str));
        }
        return dfs_d(list, 0, list.size() - 1);
    }

    TreeNode dfs_d(List<Integer> list, int l, int r){
        if(l > r) return null;
        // 根节点
        TreeNode root = new TreeNode(list.get(l));
        int k = l + 1;
        // 找分界点
        while(k <= r && list.get(k) < list.get(l)) k++;
        root.left = dfs_d(list, l + 1, k - 1);
        root.right = dfs_d(list, k, r);
        return root;
    }



    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
