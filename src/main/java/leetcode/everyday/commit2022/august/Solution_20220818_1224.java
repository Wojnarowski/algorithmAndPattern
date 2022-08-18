package leetcode.everyday.commit2022.august;

import leetcode.everyday.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 1224 最大相等频率
 *
 *
 * 有 n 个 (id, value) 对，其中 id 是 1 到 n 之间的一个整数，value 是一个字符串。不存在 id 相同的两个 (id, value) 对。
 *
 * 设计一个流，以 任意 顺序获取 n 个 (id, value) 对，并在多次调用时 按 id 递增的顺序 返回一些值。
 *
 * 实现 OrderedStream 类：
 *
 * OrderedStream(int n) 构造一个能接收 n 个值的流，并将当前指针 ptr 设为 1 。
 * String[] insert(int id, String value) 向流中存储新的 (id, value) 对。存储后：
 * 如果流存储有 id = ptr 的 (id, value) 对，则找出从 id = ptr 开始的 最长 id 连续递增序列 ，并 按顺序 返回与这些 id 关联的值的列表。然后，将 ptr 更新为最后那个  id + 1 。
 * 否则，返回一个空列表。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入
 * ["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
 * [[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
 * 输出
 * [null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]
 *
 * 解释
 * OrderedStream os= new OrderedStream(5);
 * os.insert(3, "ccccc"); // 插入 (3, "ccccc")，返回 []
 * os.insert(1, "aaaaa"); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
 * os.insert(2, "bbbbb"); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
 * os.insert(5, "eeeee"); // 插入 (5, "eeeee")，返回 []
 * os.insert(4, "ddddd"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 1000
 * 1 <= id <= n
 * value.length == 5
 * value 仅由小写字母组成
 * 每次调用 insert 都会使用一个唯一的 id
 * 恰好调用 n 次 insert
 * 通过次数14,235提交次数17,621
 *
 *
 */
public class Solution_20220818_1224 {

    public int maxEqualFreq(int[] nums) {
        int length = (int) 1e5 + 7;
        //存放数字的个数
        int[] hash = new int[length];
        //记录最大的数字频率
        int maxFreq = 0;
        //记录最大数字频率的数字种类
        int maxSpecies = 0;
        //记录数字种类
        int species = 0;
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            //当前没有的新数字
            if (hash[num]++ == 0) {
                species++;
            }
            if (hash[num] > maxFreq) {
                //超过了 最大数字频率
                maxFreq = hash[num];
                //最大数字频率的数字种类 只有一种
                maxSpecies = 1;
            } else if (hash[num] == maxFreq) {
                //新加入一个最大频率的数字
                maxSpecies++;
            }
            //有以下几种情况
            //①频率都是1 如：1、2、3、4、5 随便删除一个即可
            //②频率都是maxFreq 如：111 222 333 4 删除4即可
            //③最大频率的种类是1个 并且maxFreq是 i / species（平均数量）多一个
            //如：111 222 333 4444 删除1个4  或者如 1111111 随便删除一个
            if (maxFreq == 1 || maxFreq * maxSpecies == i || maxSpecies == 1 && maxFreq == i / species + 1) {
                ans = i + 1;
            }
        }
        return ans;
    }
}
