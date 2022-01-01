package leetcode.everyday.commit2021.may;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *q 1707 与数组中元素的最大异或值
 *
 * 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
 *
 * 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
 *
 * 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
 * 输出：[3,3,7]
 * 解释：
 * 1) 0 和 1 是仅有的两个不超过 1 的整数。0 XOR 3 = 3 而 1 XOR 3 = 2 。二者中的更大值是 3 。
 * 2) 1 XOR 2 = 3.
 * 3) 5 XOR 2 = 7.
 * 示例 2：
 *
 * 输入：nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
 * 输出：[15,-1,5]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length, queries.length <= 105
 * queries[i].length == 2
 * 0 <= nums[j], xi, mi <= 109
 *
 */
public class Solution_20210523_1707 {

    static int N = (int)1e5 * 32;
    static int[][] trie = new int[N][2];
    static int[] cnt = new int[N];
    static int idx = 0;
    public Solution_20210523_1707() {
        for (int i = 0; i <= idx; i++) {
            Arrays.fill(trie[i], 0);
            cnt[i] = 0;
        }
        idx = 0;
    }
    // 往 Trie 存入(v = 1)/删除(v = -1) 某个数 x
    void add(int x, int v) {
        int p = 0;
        for (int i = 31; i >= 0; i--) {
            int u = (x >> i) & 1;
            if (trie[p][u] == 0) trie[p][u] = ++idx;
            p = trie[p][u];
            cnt[p] += v;
        }
    }
    int getVal(int x) {
        int ans = 0;
        int p = 0;
        for (int i = 31; i >= 0; i--) {
            int a = (x >> i) & 1, b = 1 - a;
            if (cnt[trie[p][b]] != 0) {
                p = trie[p][b];
                ans = ans | (b << i);
            } else if (cnt[trie[p][a]] != 0) {
                p = trie[p][a];
                ans = ans | (a << i);
            } else {
                return -1;
            }
        }
        return ans ^ x;
    }


    /**
     *
     * @param nums
     * @param qs
     * @return
     */
    public int[] maximizeXor(int[] nums, int[][] qs) {
        int n = qs.length;

        // 使用哈希表将原本的顺序保存下来
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(qs[i], i);

        // 对两者排降序
        sort(nums);
        Arrays.sort(qs, (a, b)->b[1]-a[1]);

        // 将所有数存入 Trie
        for (int i : nums) add(i, 1);

        int[] ans = new int[n];
        int left = -1; // 在 nums 中下标「小于等于」left 的值都已经从 Trie 中移除
        for (int[] q : qs) {
            int x = q[0], limit = q[1];
            // 二分查找到待删除元素的右边界，将其右边界之前的所有值从 Trie 中移除。
            int right = getRight(nums, limit);
            for (int i = left + 1; i < right; i++) add(nums[i], -1);
            left = right - 1;
            ans[map.get(q)] = getVal(x);
        }
        return ans;
    }

    // 二分找到待删除的右边界
    int getRight(int[] nums, int limit) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] <= limit) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[r] <= limit ? r : r + 1;
    }
    // 对 nums 进行降序排序（Java 没有 Api 直接支持对基本类型 int 排倒序，其他语言可忽略）
    void sort(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int c = nums[r];
            nums[r--] = nums[l];
            nums[l++] = c;
        }
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2)==28,"程序异常");
        //topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2);
        System.out.println("-------------运行通过-------------");

    }
}
