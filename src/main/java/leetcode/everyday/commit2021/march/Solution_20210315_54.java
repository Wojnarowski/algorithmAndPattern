package leetcode.everyday.commit2021.march;

import java.util.ArrayList;
import java.util.List;

/**
 *给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *  
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]、
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 */
public class Solution_20210315_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list= new ArrayList<Integer>();
        if(matrix==null || matrix.length==0){
            return list;
        }
        //行
        int m=matrix.length;
        //列
        int n=matrix[0].length;
        //统计矩阵层数
        int count=(Math.min(m, n)+1)/2;
        int i=0;
        //外层开始遍历逐层打印
        while(i<count){
            //打印上 ,一整行
            for(int j=i;j<n-i;j++){
                list.add(matrix[i][j]);
            }
            //打印右   列第二个开始，到底
            for(int j=i+1;j<m-i;j++){
                list.add(matrix[j][(n-1)-i]);
            }
            //打印下  行倒数第二个开始到正数第二个
            for (int j = (n-1)-(i+1); j >= i && (m-1-i != i); j--) {
                list.add(matrix[(m-1)-i][j]);
            }
            //打印左
            for (int j = (m-1)-(i+1); j >= i+1 && (n-1-i) != i; j--) {
                list.add(matrix[j][i]);
            }
            i++;

        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(isValidSerialization("9,#,#,1")==false,"程序异常");
        System.out.println("-------------运行通过-------------");


    }
}
