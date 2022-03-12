package leetcode.everyday.commit2022.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 590 N 叉树的后序遍历
 *给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。
 *
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[5,6,3,2,4,1]
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 *  
 *
 * 提示：
 *
 * 节点总数在范围 [0, 104] 内
 * 0 <= Node.val <= 104
 * n 叉树的高度小于或等于 1000
 *  
 *
 * 进阶：递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 通过次数96,188提交次数124,032
 * 请问您在哪类招聘中遇到此题？
 *
 *
 */
public class Solution_20220312_590 {


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        dfs(root);
        return ans;
    }
    void dfs(Node root) {
        if (root == null) return;
        for (Node node : root.children) dfs(node);
        ans.add(root.val);
    }


    public static void main(String[] args) {


        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
