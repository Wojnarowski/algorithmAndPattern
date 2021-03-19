package leetcode.everyday.march;

import org.springframework.util.Assert;

/**
 * 115. 不同的子序列
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 *  
 *
 * 示例 1：
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 *
 *
 * 示例 2：
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 *  
 *
 * 提示：
 *
 * 0 <= s.length, t.length <= 1000
 * s 和 t 由英文字母组成
 *
 */
public class Solution_20210317_115 {


    public static int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        //+1代表每个字符串前面加个空串
        int [][] dp=new int[m+1][n+1];
        //给行赋初始值相当于 第一个t的字符串是空 在s中出现的次数
        for (int i=0;i<n+1;i++) {
            dp[0][i] = 1;
        }
        //可有可无
//        for (int i=1;i<m+1;i++) {
//            dp[i][0] = 0;
//        }
        for(int i=1 ;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(t.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
                }
                else{
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[m][n];

    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(numDistinct("rabbbit","rabbit")==3,"程序异常");
        Assert.isTrue(numDistinct("babgbag","bag")==5,"程序异常");

        System.out.println("-------------运行通过-------------");


    }
}
