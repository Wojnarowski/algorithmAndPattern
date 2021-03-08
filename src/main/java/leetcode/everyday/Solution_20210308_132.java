package leetcode.everyday;

import org.springframework.util.Assert;

import java.util.Arrays;

/**
 *给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 *
 * 返回符合要求的 最少分割次数 。
 *
 *  
 *
 * 示例 1：
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 *
 *
 * 示例 2：
 * 输入：s = "a"
 * 输出：0
 *
 *
 * 示例 3：
 * 输入：s = "ab"
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 *
 */
public class Solution_20210308_132 {


    public static  int minCut(String s) {
        if(s==null || s.length()<=1){
            return 0;
        }
        int n=s.length();
        char[] charArray = s.toCharArray();
        //动态转移方程
        boolean[][] g = new boolean[n][n];
        //填充i到j之间
        for(int i=0;i<n;i++){
            Arrays.fill(g[i],true);
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
            }
        }

        System.out.println("----------动态方程组建完毕-----------");
        for(int i=0;i<g.length;i++){
            for(int j=0;j<g[0].length;j++){
                System.out.print(g[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("----------动态方程组建完毕-----------");
        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (g[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[n - 1];


    }

    public static void main(String[] args) {
        String str1="aab";
        String str2="a";
        String str3="ab";
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(minCut(str1)==1,"程序异常");
        Assert.isTrue(minCut(str2)==0,"程序异常");
        Assert.isTrue(minCut(str3)==1,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
