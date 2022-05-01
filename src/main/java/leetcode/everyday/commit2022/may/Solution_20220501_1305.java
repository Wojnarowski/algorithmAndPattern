package leetcode.everyday.commit2022.may;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 1305  两棵二叉搜索树中的所有元素
 *
 *给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 * 示例 2：
 *
 *
 *
 * 输入：root1 = [1,null,8], root2 = [8,1]
 * 输出：[1,1,8,8]
 *  
 *
 * 提示：
 *
 * 每棵树的节点数在 [0, 5000] 范围内
 * -105 <= Node.val <= 105
 * 通过次数38,321提交次数49,083
 * 请问您在哪类招聘中遇到此题？
 *
 *
 */
public class Solution_20220501_1305 {

    int INF = 0x3f3f3f3f;
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
  }


    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        dfs(root1, l1); dfs(root2, l2);
        int n = l1.size(), m = l2.size(), i = 0, j = 0;
        while (i < n || j < m) {
            int a = i < n ? l1.get(i) : INF, b = j < m ? l2.get(j) : INF;
            if (a <= b) {
                ans.add(a); i++;
            } else {
                ans.add(b); j++;
            }
        }
        return ans;
    }
    void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return ;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
