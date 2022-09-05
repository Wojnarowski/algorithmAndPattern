package leetcode.everyday.commit2022.september;

import leetcode.everyday.TreeNode;

import java.util.*;

/**
 * 652    寻找重复的子树
 *
 *
 *
 */
public class Solution_20220905_652 {

    private List<TreeNode> list;
    private int idx;
    private Map<Mark, Integer> map;
    private Set<Integer> set;


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        set = new HashSet<>();
        list = new ArrayList<>();
        idx = 1;
        dfs(root);
        return list;
    }
    public int dfs(TreeNode node) {
        int left = 0, right = 0;
        if (node.left != null) {
            left = dfs(node.left);
        }
        if (node.right != null) {
            right = dfs(node.right);
        }
        Mark mark = new Mark(node.val, left, right);
        if (map.containsKey(mark)) {
            int cur = map.get(mark);
            if (!set.contains(cur)) {
                set.add(cur);
                list.add(node);
            }
            return cur;
        }  else {
            map.put(mark, idx++);
            return idx - 1;
        }
    }

    public static class Mark {
        public int nodeVal, leftIdx, rightIdx;

        public Mark(int nodeVal, int leftIdx, int rightIdx) {
            this.nodeVal = nodeVal;
            this.leftIdx = leftIdx;
            this.rightIdx = rightIdx;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Mark)) {
                return false;
            }
            Mark mark = (Mark) other;
            return nodeVal == mark.nodeVal && leftIdx == mark.leftIdx && rightIdx == mark.rightIdx;
        }

        @Override
        public int hashCode() {
            return (nodeVal + 200) * 100000000 + leftIdx * 10000 + rightIdx;
        }
    }

}
