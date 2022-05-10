package leetcode.everyday.commit;

/**
 *11
 *
 */


public class Solution_20220510_70 {

    public int climbStairs(int n) {
        if (n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }

    public int climbStairs2(int n) {
        if (n==1){
            return 1;
        }
        int [] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        //循环次数是n-3+1(+1是加上3这个状态)
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
