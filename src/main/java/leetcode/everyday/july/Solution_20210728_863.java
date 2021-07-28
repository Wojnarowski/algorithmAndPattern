package leetcode.everyday.july;

import leetcode.everyday.TreeNode;

import java.util.*;

/**
 *
 *  863 二叉树中所有距离为 K 的结点
 *
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 *
 *
 *
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 *  
 *
 * 提示：
 *
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 *
 *
 */
public class Solution_20210728_863 {


    /**
     * 递归法
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, TreeNode> familyMap = new HashMap<>();
        //递归获取父子结点映射关系
        map(root, familyMap);
        boolean[] visited = new boolean[501];
        //递归获取距离指定结点指定距离的所有结点值
        search(target, K, res, visited, familyMap);
        return res;

    }

    private void search(TreeNode target, int K, List<Integer> res, boolean[] visited, Map<TreeNode, TreeNode> familyMap) {
        if(target == null || K < 0 || visited[target.val]) return;
        if(K == 0 && !visited[target.val]) {
            res.add(target.val);
            visited[target.val] = true;
            return;
        }
        visited[target.val] = true;
        search(target.left, K-1, res, visited, familyMap);
        search(target.right, K-1, res, visited, familyMap);
        search(familyMap.get(target), K-1, res, visited, familyMap);
    }

    private void map(TreeNode root, Map<TreeNode, TreeNode> familyMap) {
        if(root == null) return ;
        if(root.left != null) familyMap.put(root.left, root);
        if(root.right != null) familyMap.put(root.right, root);
        map(root.left, familyMap);
        map(root.right, familyMap);
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(isCovered(test,1,50)==true,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
