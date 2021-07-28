package leetcode.everyday.july;

import leetcode.everyday.TreeNode;

import java.util.*;

/**
 *
 *  671 二叉树中第二小的节点
 *
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 *
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * 示例 2：
 *
 *
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 231 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 * 通过次数32,366提交次数69,088
 *
 *
 */
public class Solution_20210727_671 {

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    Set<Integer> set = new HashSet();


    /**
     * 用最小堆，遍历然后弹出第二个就行
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null){
            return -1;
        }
        dfs(root);
        int ans =queue.poll();
        return queue.size()==0?-1:queue.poll();

    }

    private void dfs(TreeNode node) {
        if(node==null){
            return ;
        }
        if(!set.contains(node.val)){
            queue.offer(node.val);
            set.add(node.val);
        }
        dfs(node.left);
        dfs(node.right);

    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(isCovered(test,1,50)==true,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
