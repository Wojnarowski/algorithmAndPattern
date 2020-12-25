package zuo.db;

public class DpTest {


    /**
     * 一只青蛙一次可以跳一个台阶，也可以一次跳两个台阶。求青蛙跳到第n级的台阶一共有多少种跳法
     */
   public static int f (int  n){
        if(n<=1){
            return n;
        }

        //创建数组保存历史数据
        int[]dp=new int[n+1];
        //给出初始值
        dp[0]=0;
        dp[1]=1;
        //当 n = 2 时，dp[2] = dp[1] + dp[0] = 1。这显然是错误的，你可以模拟一下，应该是 dp[2] = 2。
        dp[2]=2;
        //通过关系式来计算dp[n]
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        //返回最终结果
        return dp[n];

    }

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     *  机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * 问总共有多少条不同的路径？
     */
    public static int uniquePaths(int m,int n){
        if(m<=0 || n<=0){
            return 0;

        }
        return 0;
    }


    public static void main(String[] args) {
        int result =f(3);
        System.out.println(result);
    }

}
