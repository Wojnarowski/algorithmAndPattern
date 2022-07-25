package leetcode.everyday.commit2022.july;

import leetcode.everyday.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1206     设计跳表
 *
 *
 * 不使用任何库函数，设计一个 跳表 。
 *
 * 跳表 是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。
 *
 * 例如，一个跳表包含 [30, 40, 50, 60, 70, 90] ，然后增加 80、45 到跳表中，以下图的方式操作：
 *
 *
 * Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons
 *
 * 跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(n))，空间复杂度是 O(n)。
 *
 * 了解更多 : https://en.wikipedia.org/wiki/Skip_list
 *
 * 在本题中，你的设计应该要包含这些函数：
 *
 * bool search(int target) : 返回target是否存在于跳表中。
 * void add(int num): 插入一个元素到跳表。
 * bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。
 * 注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。
 *
 *  
 *
 * 示例 1:
 *
 * 输入
 * ["Skiplist", "add", "add", "add", "search", "add", "search", "erase", "erase", "search"]
 * [[], [1], [2], [3], [0], [4], [1], [0], [1], [1]]
 * 输出
 * [null, null, null, null, false, null, true, false, true, false]
 *
 * 解释
 * Skiplist skiplist = new Skiplist();
 * skiplist.add(1);
 * skiplist.add(2);
 * skiplist.add(3);
 * skiplist.search(0);   // 返回 false
 * skiplist.add(4);
 * skiplist.search(1);   // 返回 true
 * skiplist.erase(0);    // 返回 false，0 不在跳表中
 * skiplist.erase(1);    // 返回 true
 * skiplist.search(1);   // 返回 false，1 已被擦除
 *  
 *
 * 提示:
 *
 * 0 <= num, target <= 2 * 104
 * 调用search, add,  erase操作次数不大于 5 * 104 
 *
 *
 *
 *
 */


public class Solution_20220726_1206 {

    /**
     * 本题的关键在于，对于新加入的结点如何确定新结点的层数，通过概率的方式来获取。
     *
     * 初始时默认为1层，有0.5的概率增加一层，0.5的概率确定为当前层。这样的话，新增加的结点为2层的概率是1/2，3层的概率是1/4，4层的概率是1/8...
     * 头结点(head)不存储数据，其层数等于最高层数，如果新增加的结点层数高于最高层，则要扩充头结点层数。
     * 在实现跳表的增加、删除、查找时，都是从头结点的最高层出发，优先往右搜索，无法往右搜索的情况下再往下层搜索。
     * 增加：对于新增加的结点，首先确定其层数，更新maxLevel(可能不会更新)，必要时扩充头结点，找到小于val最右结点，从上往下遍历设置指针。
     * 搜索：找到小于target的最右结点，判断下一个节点的值是否等于target。
     * 删除：找到小于val的最右结点，从上往下依次设置指针。
     *
     *
     */
    class SkipListNode {
        public int val;
        public ArrayList<SkipListNode> nexts;

        public SkipListNode() {
            this.nexts = new ArrayList<>();
        }

        public SkipListNode(int val) {
            this.val = val;
            this.nexts = new ArrayList<>();
        }
    }
    private static final double PROBABILITY = 0.5;
    private static final int MAX_LEVEL = 31;
    private SkipListNode head;
    private int size;
    private int maxLevel;

    public Solution_20220726_1206() {
        this.head = new SkipListNode();
        this.head.nexts.add(null);
        this.size = 0;
        this.maxLevel = 0;

    }

    // 在整个跳表中查找小于val的最右结点
    private SkipListNode mostRightLessNodeInTree(int val) {
        int level = maxLevel;
        SkipListNode cur = head;
        while (level >= 0) {
            cur = mostRightLessNodeInLevel(val, cur, level--);
        }
        return cur;
    }

    // 在跳表同一层(level)中查找小于val的最右结点
    private SkipListNode mostRightLessNodeInLevel(int val, SkipListNode cur, int level) {
        SkipListNode next = cur.nexts.get(level);
        while (next != null && next.val < val) {
            cur = next;
            next = cur.nexts.get(level);
        }
        return cur;
    }

    public void add(int num) {
        size++;
        int newNodeLevel = 0;
        while (Math.random() < PROBABILITY) {
            newNodeLevel++;
            if (newNodeLevel == MAX_LEVEL) {
                break;
            }
        }
        while (newNodeLevel > maxLevel) {
            head.nexts.add(null);
            maxLevel++;
        }
        SkipListNode newNode = new SkipListNode(num);
        for (int i = 0; i <= newNodeLevel; i++) {
            newNode.nexts.add(null);
        }
        int level = maxLevel;
        SkipListNode pre = head;
        while (level >= 0) {
            pre = mostRightLessNodeInLevel(num, pre, level);
            if (level <= newNodeLevel) {
                newNode.nexts.set(level, pre.nexts.get(level));
                pre.nexts.set(level, newNode);
            }
            level--;
        }
    }

    public boolean search(int target) {
        SkipListNode less = mostRightLessNodeInTree(target);
        SkipListNode next = less.nexts.get(0);
        return next != null && next.val == target;
    }

    public boolean erase(int num) {
        if (!search(num)) {
            return false;
        }
        size--;
        int level = maxLevel;
        SkipListNode pre = head;
        while (level >= 0) {
            pre = mostRightLessNodeInLevel(num, pre, level);
            SkipListNode next = pre.nexts.get(level);
            if (next != null && next.val == num) {
                pre.nexts.set(level, next.nexts.get(level));
            }
            if (level != 0 && pre == head && pre.nexts.get(level) == null) {
                head.nexts.remove(level);
                maxLevel--;
            }
            level--;
        }
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}
