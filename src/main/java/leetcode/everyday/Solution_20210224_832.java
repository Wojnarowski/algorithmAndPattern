package leetcode.everyday;

import com.sun.deploy.util.ArrayUtil;
import org.springframework.util.Assert;

import java.util.Arrays;

/**
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 *  
 *
 * 示例 1：
 * 输入：[[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 *
 *
 * 示例 2：
 * 输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *  
 *
 * 提示：
 *
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 *
 */


public class Solution_20210224_832 {

    /**
     * 思路：1.双指针进行交换
     *       2.和1进行 ^ 异或操作进行1和0的互换
     * @param A
     * @return
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        if(A==null){
            return null;
        }
        //int m=A.length,n=A[0].length;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length/2;j++){
                int temp=A[i][j];
                A[i][j]=A[i][A[i].length-j-1]^1;
                A[i][A[i].length-j-1]=temp ^ 1;
            }
            if (A[i].length % 2 == 1) {
                // 如果这行为基数，则将中间的数进行异或即可
                A[i][A[i].length / 2] ^= 1;
            }

        }

        return A;
    }

    public static void main(String[] args) {
        //int [][] a1 = new int[][]{{1,1,0},{1,0,1},{0,0,0,1},{0,0,0,1}};
        int [][] a1 = new int[][]{{1,1,0,0},{1,0,0,1},{0,0,0},{1,0,1,0}};
        System.out.println("-------------开始执行-------------");
        AlgorithmUtil.sysoutDobbleArray(a1);
        int[][] result = flipAndInvertImage(a1);
        //Assert.isTrue(flipAndInvertImage(a1)==true,"程序异常");
        AlgorithmUtil.sysoutDobbleArray(result);
        System.out.println("-------------运行通过-------------");

    }
}
