package leetcode.everyday.commit2022.june;

/**
 * 926      将字符串翻转到单调递增
 *
 *
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
 *
 * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
 *
 * 返回使 s 单调递增的最小翻转次数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "00110"
 * 输出：1
 * 解释：翻转最后一位得到 00111.
 * 示例 2：
 *
 * 输入：s = "010110"
 * 输出：2
 * 解释：翻转得到 011111，或者是 000111。
 * 示例 3：
 *
 * 输入：s = "00011000"
 * 输出：2
 * 解释：翻转得到 00000000。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s[i] 为 '0' 或 '1'
 * 通过次数24,844提交次数40,040
 *
 *
 */


public class Solution_20220611_926 {

    public int minFlipsMonoIncr(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length, ans = 0;
        int[] g = new int[n + 10];
        Arrays.fill(g, n + 10);
        for (int i = 0; i < n; i++) {
            int t = s.charAt(i) - '0';
            int l = 1, r = i + 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (g[mid] > t) r = mid;
                else l = mid + 1;
            }
            g[r] = t;
            ans = Math.max(ans, r);
        }
        return n - ans;

    }


    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
