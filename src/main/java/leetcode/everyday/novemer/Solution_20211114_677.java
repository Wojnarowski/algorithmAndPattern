package leetcode.everyday.novemer;

/**
 *
 * 677 键值映射
 *
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 *
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 *  
 *
 * 提示：
 *
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 * 通过次数26,347提交次数40,546
 * 请问您在哪类招聘中遇到此题？
 *
 */
public class Solution_20211114_677 {

    class MapSum {

        private class Node {
            Node[] children = new Node[26];
            // 题目约定了val值大于0，所以，这里用0作为默认值，表示不是key的节点
            int val = 0;
        }

        private Node root;


        public MapSum() {
            this.root = new Node();
        }

        public void insert(String key, int val) {
            Node node = this.root;
            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i) - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Node();
                }
                node = node.children[index];
            }
            node.val = val;
        }

        public int sum(String prefix) {

            Node node = this.root;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                node = node.children[index];
                if (node == null) {
                    // 不存在这个前缀，返回0
                    return 0;
                }
            }
            // 从这个节点往下DFS
            return dfs(node);
        }
        private int dfs(Node node) {
            if (node == null) {
                return 0;
            }
            int ans = 0;
            if (node.val > 0) {
                // val > 0 说明是一个有效的 key
                ans = node.val;
            }
            for (Node child : node.children) {
                ans += dfs(child);
            }

            return ans;
        }
    }
    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{0,1};
        //Assert.isTrue(missingNumber(array)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
