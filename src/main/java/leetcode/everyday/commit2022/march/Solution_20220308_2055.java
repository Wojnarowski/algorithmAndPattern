package leetcode.everyday.commit2022.march;

import java.util.ArrayList;
import java.util.List;

/**
 * 2055 蜡烛之间的盘子
 *
 * 给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。
 *
 * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。
 *
 * 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
 * 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。
 *
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入：s = "**|**|***|", queries = [[2,5],[5,9]]
 * 输出：[2,3]
 * 解释：
 * - queries[0] 有两个盘子在蜡烛之间。
 * - queries[1] 有三个盘子在蜡烛之间。
 * 示例 2:
 *
 *
 *
 * 输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
 * 输出：[9,0,0,0,0]
 * 解释：
 * - queries[0] 有 9 个盘子在蜡烛之间。
 * - 另一个查询没有盘子在蜡烛之间。
 *  
 *
 * 提示：
 *
 * 3 <= s.length <= 105
 * s 只包含字符 '*' 和 '|' 。
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * 0 <= lefti <= righti < s.length
 * 通过次数4,898提交次数11,380
 *
 *
 */
public class Solution_20220308_2055 {


    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] cs = s.toCharArray();
        int n = cs.length, m = queries.length;
        int[] ans = new int[m], sum = new int[n + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cs[i] == '|') list.add(i);
            sum[i + 1] = sum[i] + (cs[i] == '*' ? 1 : 0);
        }
        if (list.size() == 0) return ans;
        for (int i = 0; i < m; i++) {
            int a = queries[i][0], b = queries[i][1];
            int c = -1, d = -1;
            // 找到 a 右边最近的蜡烛
            int l = 0, r = list.size() - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (list.get(mid) >= a) r = mid;
                else l = mid + 1;
            }
            if (list.get(r) >= a) c = list.get(r);
            else continue;
            // 找到 b 左边最近的蜡烛
            l = 0; r = list.size() - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (list.get(mid) <= b) l = mid;
                else r = mid - 1;
            }
            if (list.get(r) <= b) d = list.get(r);
            else continue;
            if (c <= d) ans[i] = sum[d + 1] - sum[c];
        }
        return ans;

    }


    public static void main(String[] args) {


        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
