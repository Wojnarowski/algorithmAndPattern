package leetcode.everyday.commit2022.april;

import java.util.*;

/**
 * 429  N 叉树的层序遍历
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *  
 *
 * 提示：
 *
 * 树的高度不会超过 1000
 * 树的节点总数在 [0, 10^4] 之间
 * 通过次数86,065提交次数119,878
 * 请问您在哪类招聘中遇到此题？
 *
 *
 */
public class Solution_20220408_429 {

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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Node> d = new ArrayDeque<>();
        if (root != null) d.addLast(root);
        while (!d.isEmpty()) {
            int size = d.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                Node t = d.pollFirst();
                for (Node node : t.children) d.addLast(node);
                list.add(t.val);
            }
            ans.add(list);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
