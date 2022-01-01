package leetcode.everyday.commit2021.july;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 1743 从相邻元素对还原数组
 *
 * 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
 *
 * 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
 *
 * 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
 *
 * 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：adjacentPairs = [[2,1],[3,4],[3,2]]
 * 输出：[1,2,3,4]
 * 解释：数组的所有相邻元素对都在 adjacentPairs 中。
 * 特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
 * 示例 2：
 *
 * 输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * 输出：[-2,4,1,-3]
 * 解释：数组中可能存在负数。
 * 另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
 * 示例 3：
 *
 * 输入：adjacentPairs = [[100000,-100000]]
 * 输出：[100000,-100000]
 *  
 *
 * 提示：
 *
 * nums.length == n
 * adjacentPairs.length == n - 1
 * adjacentPairs[i].length == 2
 * 2 <= n <= 105
 * -105 <= nums[i], ui, vi <= 105
 * 题目数据保证存在一些以 adjacentPairs 作为元素对的数组 nums
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Solution_20210725_1743 {


    static int N = (int)1e6+10;
    static int[] q = new int[N];

    public int[] restoreArray(int[][] aps) {
        int m = aps.length, n = m + 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] ap : aps) {
            int a = ap[0], b = ap[1];
            List<Integer> alist =  map.getOrDefault(a, new ArrayList<>());
            alist.add(b);
            map.put(a, alist);
            List<Integer> blist = map.getOrDefault(b, new ArrayList<>());
            blist.add(a);
            map.put(b, blist);
        }
        int l = N / 2, r = l + 1;
        int std = aps[0][0];
        List<Integer> list = map.get(std);
        q[l--] = std;
        q[r++] = list.get(0);
        if (list.size() > 1) q[l--] = list.get(1);
        while ((r - 1) - (l + 1) + 1 < n) {
            List<Integer> alist = map.get(q[l + 1]);
            int j = l;
            for (int i : alist) {
                if (i != q[l + 2]) q[j--] = i;
            }
            l = j;

            List<Integer> blist = map.get(q[r - 1]);
            j = r;
            for (int i : blist) {
                if (i != q[r - 2]) q[j++] = i;
            }
            r = j;
        }
        int[] ans = new int[n];
        for (int i = l + 1, idx = 0; idx < n; i++, idx++) {
            ans[idx] = q[i];
        }
        return ans;

    }



    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //int test[][] = new int[][]{{1,2},{3,4},{5,6}};
        //Assert.isTrue(isCovered(test,2,5)==true,"程序异常");
        int test[][] = new int[][]{{1,2}};
        //Assert.isTrue(isCovered(test,1,50)==true,"程序异常");



        System.out.println("-------------运行通过-------------");
    }
}
