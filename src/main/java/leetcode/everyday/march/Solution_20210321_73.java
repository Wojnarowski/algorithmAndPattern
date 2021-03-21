package leetcode.everyday.march;

import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 *给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *  
 *
 * 示例 1：
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 *
 *
 * 示例 2：
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 * 通过次数95,159提交次数162,407
 * 在真实的面试中遇到过这道题？
 *
 */
public class Solution_20210321_73 {

    /**
     * 思路一: 两边遍历矩阵，利用额外空间记录哪些行，列有0；第二遍置0
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> row_zero = new HashSet<>();
        Set<Integer> col_zero = new HashSet<>();
        int row =matrix.length;
        int col =matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    row_zero.add(i);
                    col_zero.add(j);
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(row_zero.contains(i) || col_zero.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }

    }
    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"})==22,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
