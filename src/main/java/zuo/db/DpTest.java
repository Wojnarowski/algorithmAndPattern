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
        int [][]dp = new int[m][n];
        //初始化
        //列
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        //行
        for(int j=0;j<n;j++){
            dp[0][j]=1;
        }
        //推导出dp[m-1][n-1]
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[j][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 给定一个包含非负整数的 m x n 网格，
     * 请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *
     * 举例：
     输入:
     arr = [
             [1,3,1],
             [1,5,1],
             [4,2,1]
            ]
     输出: 7
     解释: 因为路径 1→3→1→1→1 的总和最小。

     步骤一、定义数组元素的含义
     由于我们的目的是从左上角到右下角，最小路径和是多少，那我们就定义 dp[i] [j]的含义为：
     当机器人从左上角走到(i, j) 这个位置时，最下的路径和是 dp[i] [j]。那么，dp[m-1] [n-1] 就是我们要的答案了。

     注意，这个网格相当于一个二维数组，数组是从下标为 0 开始算起的，所以 由下角的位置是 (m-1, n - 1)，所以 dp[m-1] [n-1] 就是我们要走的答案。

     步骤二：找出关系数组元素间的关系式
     想象以下，机器人要怎么样才能到达 (i, j) 这个位置？
     由于机器人可以向下走或者向右走，所以有两种方式到达

     一种是从 (i-1, j) 这个位置走一步到达

     一种是从(i, j - 1) 这个位置走一步到达

     不过这次不是计算所有可能路径，而是计算哪一个路径和是最小的，那么我们要从这两种方式中，选择一种，使得dp[i] [j] 的值是最小的，显然有
     dp[i] [j] = min(dp[i-1][j]，dp[i][j-1]) + arr[i][j];// arr[i][j] 表示网格中的值

     步骤三、找出初始值
     显然，当 dp[i] [j] 中，如果 i 或者 j 有一个为 0，那么还能使用关系式吗？答是不能的，因为这个时候把 i - 1 或者 j - 1，就变成负数了，数组就会出问题了，所以我们的初始值是计算出所有的 dp[0] [0….n-1] 和所有的 dp[0….m-1] [0]。这个还是非常容易计算的，相当于计算机图中的最上面一行和左边一列。因此初始值如下：

     dp[0] [j] = arr[0] [j] + dp[0] [j-1]; // 相当于最上面一行，机器人只能一直往左走

     dp[i] [0] = arr[i] [0] + dp[i-1] [0];  // 相当于最左面一列，机器人只能一直往下走
     * @param args
     */
    public static int uniquePaths(int [][] arr){
        int m = arr.length;
        int n=arr[0].length;
        if(m<=0 || n<=0){
            return 0;
        }

        int[][]dp=new int[m][n];
        //初始化
        dp[0][0]=arr[0][0];
        //初始化最左边的列
        for(int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+arr[i][0];
        }
        //初始化最上面的行
        for(int j=1;j<n;j++){
           dp[0][j]=dp[0][j-1]+arr[0][j];
        }

        //推导 dp[m-1][n-1]
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+arr[i][j];
            }
        }
        return dp[m-1][n-1];
    }




    public static void main(String[] args) {
        int result =f(3);
        System.out.println(result);

        System.out.println("----uniquePaths-------");
        int [][]arr = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
                };
        System.out.println(uniquePaths(arr));
    }

}
