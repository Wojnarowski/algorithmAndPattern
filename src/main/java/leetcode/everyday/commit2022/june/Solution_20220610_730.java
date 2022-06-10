package leetcode.everyday.commit2022.june;

import java.util.Random;

/**
 * 730     统计不同回文子序列
 *
 *给定一个字符串 s，返回 s 中不同的非空「回文子序列」个数 。
 *
 * 通过从 s 中删除 0 个或多个字符来获得子序列。
 *
 * 如果一个字符序列与它反转后的字符序列一致，那么它是「回文字符序列」。
 *
 * 如果有某个 i , 满足 ai != bi ，则两个序列 a1, a2, ... 和 b1, b2, ... 不同。
 *
 * 注意：
 *
 * 结果可能很大，你需要对 109 + 7 取模 。
 *  
 *
 * 示例 1：
 *
 * 输入：s = 'bccb'
 * 输出：6
 * 解释：6 个不同的非空回文子字符序列分别为：'b', 'c', 'bb', 'cc', 'bcb', 'bccb'。
 * 注意：'bcb' 虽然出现两次但仅计数一次。
 * 示例 2：
 *
 * 输入：s = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
 * 输出：104860361
 * 解释：共有 3104860382 个不同的非空回文子序列，104860361 对 109 + 7 取模后的值。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s[i] 仅包含 'a', 'b', 'c' 或 'd' 
 * 通过次数5,774提交次数10,715
 *
 *
 *
 *
 */


public class Solution_20220610_730 {

    public int countPalindromicSubsequences(String s) {
        int mod = 1000000007;
        int n = s.length();
        int[][] dp = new int[n][n];
        //一个单字符是一个回文子序列
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        //从长度为2的子串开始计算
        for (int len = 2; len <= n; len++) {
            //挨个计算长度为len的子串的回文子序列个数
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                //情况(1) 相等
                if (s.charAt(i) == s.charAt(j)) {
                    int left = i + 1;
                    int right = j - 1;
                    //找到第一个和s[i]相同的字符
                    while (left <= right && s.charAt(left) != s.charAt(i)) {
                        left++;
                    }
                    //找到第一个和s[j]相同的字符
                    while (left <= right && s.charAt(right) != s.charAt(j)) {
                        right--;
                    }
                    if (left > right) {
                        //情况① 没有重复字符
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                    } else if (left == right) {
                        //情况② 出现一个重复字符
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                    } else {
                        //情况③ 有两个及两个以上
                        dp[i][j] = 2 * dp[i + 1][j - 1] - dp[left + 1][right - 1];
                    }
                } else {
                    //情况(2) 不相等
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                }
                //处理超范围结果
                dp[i][j] = (dp[i][j] >= 0) ? dp[i][j] % mod : dp[i][j] + mod;
            }
        }
        return dp[0][n - 1];

    }
    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
