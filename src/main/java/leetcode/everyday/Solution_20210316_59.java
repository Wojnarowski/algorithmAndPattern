package leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 *给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *  
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 20
 */
public class Solution_20210316_59 {


    public  static int[][] generateMatrix(int n) {
        if(!(1 <= n && n<= 20)){
            return null;
        }
        //开始,结束
        int start = 1, target = n * n;
        //生成数组，螺旋打印
        int[][] resultArray =new int [n][n];
        //定义左右，上下四个边界
        int l=0,r=n-1,t=0,b=n-1;
        //填充
        do{
            //左  -  右
            for(int i = l;i <= r;i++){
                resultArray[t][i]=start++;
            }
            t++;
            //上  -  下
            for(int i=t ;i<= b;i++){
                resultArray[i][r]=start++;
            }
            r--;
            //右  -  左
            for(int i = r;i >= l;i--){
                resultArray[b][i]=start++;
            }
            b--;
            //下  -  上
            for(int i = b;i >= t;i--){
                resultArray[i][l]=start++;
            }
            l++;

        }while (start<=target);



        return resultArray;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //int[][] result = generateMatrix(1);
        //AlgorithmUtil.sysoutDobbleArray(result);
        int[][] result = generateMatrix(3);
        AlgorithmUtil.sysoutDobbleArray(result);


        System.out.println("-------------运行通过-------------");


    }
}
