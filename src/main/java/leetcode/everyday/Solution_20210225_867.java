package leetcode.everyday;

/**
 *给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 *
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 *
 *
 *  
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 *
 *
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *
 */


public class Solution_20210225_867 {

    public static  int[][] transpose(int[][] matrix) {
        if(matrix == null){
            return null;
        }
        int m=matrix.length,n=matrix[0].length;
        int [][] res = new int[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[j][i]=matrix[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [][] a1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("-------------开始执行-------------");
        AlgorithmUtil.sysoutDobbleArray(a1);
        int[][] result = transpose(a1);
        AlgorithmUtil.sysoutDobbleArray(result);
        System.out.println("-------------运行通过-------------");

    }
}
