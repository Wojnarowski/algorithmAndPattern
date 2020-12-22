package zuo.db;

public class DpTest {


    /**
     * 一只青蛙一次可以跳一个台阶，也可以一次跳两个台阶。求青蛙跳到第n级的台阶一共有多少种跳法
     */
    int f (int  n){
        if(n<=1){
            return n;
        }

        //创建数组保存历史数据
        int[]dp=new int[n+1];
        //给出初始值 
        dp[0]=0;
        dp[1]=1;

    }

}
