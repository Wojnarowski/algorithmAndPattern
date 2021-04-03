package leetcode.everyday.april;

import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Stack;

/**
 *q 1143 最长公共子序列
 *给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 *  
 *
 * 示例 1：
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3
 *
 *
 * 示例 2：
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 *
 *
 *
 * 示例 3：
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 *  
 *
 * 提示：
 *
 * 1 <= text1.length, text2.length <= 1000
 * text1 和 text2 仅由小写英文字符组成。
 *
 */
public class Solution_20210403_1143 {


    /**
     * 思路：动态规划 画表
     *  https://leetcode-cn.com/problems/longest-common-subsequence/solution/shi-pin-jiang-jie-shi-yong-dong-tai-gui-hua-qiu-ji/
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        if(text1 ==null || text1.length()==0 || text2==null || text2.length()==0){
                return 0;
        }
        //设置动态转移方程
        int dp[][] = new int [text1.length()+1][text2.length()+1];
        //初始化第一行
        for(int col=0;col<dp[0].length;col++){
            dp[0][col]=0;
        }
        //初始化第一列
        for(int row =0;row<dp.length;row++){
            dp[row][0]=0;
        }
        for(int row =1;row<dp.length;row++){
            char ch1=text1.charAt(row-1);
            for(int col=1;col<dp[row].length;col++){
                char ch2 = text2.charAt(col-1);
                if(ch1==ch2){
                    dp[row][col]=dp[row-1][col-1]+1;
                }else{
                     dp[row][col] = Math.max(dp[row-1][col],dp[row][col-1]);
                }
            }
        }
        int[] lastRow=dp[dp.length-1];
        return lastRow[lastRow.length-1];
   }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(longestCommonSubsequence("abcde","ace")==3,"程序异常");
        Assert.isTrue(longestCommonSubsequence("abc","abc")==3,"程序异常");
        Assert.isTrue(longestCommonSubsequence("abc","def")==0,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
