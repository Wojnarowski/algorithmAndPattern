package zuo.db;

/**
 * 参考链接  https://blog.csdn.net/qq_43648470/article/details/111414142
 * 背包问题
 * 有 n 个不同种物品，它们有各自的体积和价值，现有给定一个固定容量的背包，如何让背包里装入的物品具有最大的价值总和？

 如下即：eg：物品个数为 4，背包总容量为 8

 i（物品编号）	1	2	3	4
 w（体积）	    2	3	4	5
 v（价值）	   3	4	5	6

 */
public class Bag {


    public static  int[][]bag01(int n,int maxWeight,int [] weights,int [] values){
        int [][]dp = new int[n+1][maxWeight+1];
        for(int i=1;i<=n;i++){
            int w=weights[i-1];
            int v=values[i-1];
            for(int j=1;j<=maxWeight;j++){
                if(j>=w){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w]+v);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int n=4;
        int maxWeight=8;
        int weights []=new int[]{2,3,4,5};
        int values []=new  int[]{3,4,5,6};

        int [][]dp=bag01(4,8,weights,values);
        System.out.println(dp[n][maxWeight]);
    }


}
