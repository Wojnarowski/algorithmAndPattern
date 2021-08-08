package leetcode.everyday.august;


import org.springframework.util.Assert;

/**
 * 1137  第 N 个泰波那契数
 *
 * 泰波那契序列 Tn 定义如下： 
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 *
 * 输入：n = 25
 * 输出：1389537
 *  
 *
 */


public class Solution_20210808_1137 {

    public static  int tribonacci(int n) {
      if(n==0){
          return 0;
      }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        int []dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        if(n>=3){
            for(int i=3;i<=n;i++){
                dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
            }
        }
            return dp[n];
    }

    public static void main(String[] args) {
        int [] arr = new int[]{2,2,3,4};

        System.out.println("-------------开始执行-------------");
        Assert.isTrue(tribonacci(3)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
