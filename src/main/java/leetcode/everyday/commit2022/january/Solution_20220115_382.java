package leetcode.everyday.commit2022.january;

import leetcode.everyday.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 382  链表随机节点
 *
 * 给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。
 *
 * 实现 Solution 类：
 *
 * Solution(ListNode head) 使用整数数组初始化对象。
 * int getRandom() 从链表中随机选择一个节点并返回该节点的值。链表中所有节点被选中的概率相等。
 *  
 *
 * 示例：
 *
 *
 * 输入
 * ["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
 * [[[1, 2, 3]], [], [], [], [], []]
 * 输出
 * [null, 1, 3, 2, 2, 3]
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.getRandom(); // 返回 1
 * solution.getRandom(); // 返回 3
 * solution.getRandom(); // 返回 2
 * solution.getRandom(); // 返回 2
 * solution.getRandom(); // 返回 3
 * // getRandom() 方法应随机返回 1、2、3中的一个，每个元素被返回的概率相等。
 *  
 *
 * 提示：
 *
 * 链表中的节点数在范围 [1, 104] 内
 * -104 <= Node.val <= 104
 * 至多调用 getRandom 方法 104 次
 *  
 *
 * 进阶：
 *
 * 如果链表非常大且长度未知，该怎么处理？
 * 你能否在不使用额外空间的情况下解决此问题？
 * 通过次数33,399提交次数47,585
 * 请问您在哪类招聘中遇到此题？
 *
 *
 *
 */
public class Solution_20220115_382 {

    List<Integer> list = new ArrayList<>();
    Random random = new Random(20220116);

    public Solution_20220115_382(ListNode head) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        int idx = random.nextInt(list.size());
        return list.get(idx);
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
