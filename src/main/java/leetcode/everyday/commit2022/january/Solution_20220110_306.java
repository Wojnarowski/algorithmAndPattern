package leetcode.everyday.commit2022.january;

import java.util.ArrayList;
import java.util.List;

/**
 * 306  累加数
 *
 *
 * 累加数 是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
 *
 * 说明：累加序列里的数 不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："112358"
 * 输出：true
 * 解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2：
 *
 * 输入："199100199"
 * 输出：true
 * 解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 *  
 *
 * 提示：
 *
 * 1 <= num.length <= 35
 * num 仅由数字（0 - 9）组成
 *  
 *
 * 进阶：你计划如何处理由过大的整数输入导致的溢出?
 *
 * 通过次数20,853提交次数59,523
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/additive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution_20220110_306 {

    String num;
    int n;
    List<List<Integer>> list = new ArrayList<>();
    public boolean isAdditiveNumber(String _num) {
        num = _num;
        n = num.length();
        return dfs(0);
    }

    boolean dfs(int u) {
        int m = list.size();
        if (u == n) return m >= 3;
        int max = num.charAt(u) == '0' ? u + 1 : n;
        List<Integer> cur = new ArrayList<>();
        for (int i = u; i < max; i++) {
            cur.add(0, num.charAt(i) - '0');
            if (m < 2 || check(list.get(m - 2), list.get(m - 1), cur)) {
                list.add(cur);
                if (dfs(i + 1)) return true;
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

    boolean check(List<Integer> a, List<Integer> b, List<Integer> c) {
        List<Integer> ans = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < a.size() || i < b.size(); i++) {
            if (i < a.size()) t += a.get(i);
            if (i < b.size()) t += b.get(i);
            ans.add(t % 10);
            t /= 10;
        }
        if (t > 0) ans.add(t);
        boolean ok = c.size() == ans.size();
        for (int i = 0; i < c.size() && ok; i++) {
            if (c.get(i) != ans.get(i)) ok = false;
        }
        return ok;
    }



    public static void main(String[] args) {


        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");

        System.out.println("-------------运行通过-------------");

    }
}
