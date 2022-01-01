package leetcode.everyday.commit2021.march;

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
        char[] charArray  = s.toCharArray();
        //动态转移方程
        boolean[][] isPalindrome  = new boolean[n][n];
        //组建i到j之间回文串的动态转移方程
        for(int right=0;right<n;right++){
            for(int left=0;left<=right;left++){
                if(charArray[left]==charArray[right] && ((right-left<=2) || isPalindrome[left+1][right-1])){
                    isPalindrome[left][right]=true;
                }
            }
        }
        //前n项分割次数动态转移方程
        int[] dp = new int[n];
        Arrays.fill(dp,n);
        for(int i=0;i<n;i++){
            if(isPalindrome[0][i]){
                dp[i]=0;
                continue;
            }
            for(int j=0;j<i;j++){
                //前项
                if(isPalindrome[j+1][i]){
                    dp[i]=Math.min(dp[i],dp[j]+1);
                }
            }
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        String str1="aab";
        String str2="a";
        String str3="ab";
        String str4="cdd";
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(minCut(str1)==1,"程序异常");
        Assert.isTrue(minCut(str2)==0,"程序异常");
        Assert.isTrue(minCut(str3)==1,"程序异常");
        Assert.isTrue(minCut(str4)==1,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
