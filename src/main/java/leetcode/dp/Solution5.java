package leetcode.dp;

/**
 *给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 *
 *
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 *
 *
 *
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 *
 *
 *
 *
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 *  
 *
 */
public class Solution5 {

    public static String longestPalindrome(String str) {
        int len = str.length();
        if(len<2){
            return str;
        }
        /**
         * 转移方程：字符串两边界值相等并且子字符串是回文字符串则该字符串是回文字符串
         * dp数组含义：字符串s从i到j的索引子字符串是否是回文字符串
         */
        boolean dp[][] = new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }
        int maxLen=1;
        int start =0;

        for(int j=1;j<len;j++){
            for(int i=0;i<j;i++){
                if(str.charAt(i)==str.charAt(j)){
                    if(j-i<3){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }else{
                    dp[i][j]=false;
                }

                if (dp[i][j]) {
                    int curLen = j - i + 1;
                    maxLen =  Math.max(curLen,maxLen);
                    start = i;
//                    if (curLen > maxLen) {
//                        maxLen = curLen;
//                        start = i;
//                    }
                }
            }

        }

        return str.substring(start, start + maxLen);
    }


    public static void main(String[] args) {
        //String str="babad";
        //String str="cbbd";
        //String str="a";
        String str="ac";
        System.out.println(longestPalindrome(str));

    }
}
