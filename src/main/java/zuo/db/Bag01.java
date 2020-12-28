package zuo.db;

import java.util.Arrays;

public class Bag01 {
    public static void main(String[] args) {

        int[] wights={2,3,4,5};//每个物品的体积
        int[] values={3,4,5,6};//每个物品的价值
        int [][] dp = Bag.bag01(4,8,wights,values);
        //打印dp数组
        for(int i=1;i<=4;i++){
            for(int j=1;j<=8;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        int[] item = new int[4];
        //寻找最优价值的物品组成
        findWhat(4,8,wights,dp,item);
        //打印item数组
        System.out.println(Arrays.toString(item));

        //一维数组求背包问题
        int [] dp2 = Bag.bag02(4,8,wights,values);
        System.out.println(Arrays.toString(dp2));


    }

    /**
     * 寻找最优的物品构成
     * @param i 物品个数
     * @param j  背包最大容量
     * @param wights 重量数组
     * @param dp  动态结果
     * @param item  选定商品数组
     */
    private static void findWhat(int i, int j, int[] wights, int[][] dp, int[] item) {
        if(i>0){
             int w = wights[i-1];
             //没有放入当前物品
             if(dp[i][j]==dp[i-1][j]){
                 item[i-1]=0;
                 findWhat(i-1,j,wights,dp,item);
             }else{
                 item[i-1]=1;
                 findWhat(i-1,j-w,wights,dp,item);
             }
        }
    }
}
