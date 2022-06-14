package leetcode.everyday.commit2022.june;

/**
 * 498      对角线遍历
 *
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * 示例 2：
 *
 * 输入：mat = [[1,2],[3,4]]
 * 输出：[1,2,3,4]
 *  
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 * 通过次数64,372提交次数126,229
 * 请问您在哪类招聘中遇到此题？
 *
 *
 */


public class Solution_20220614_498 {

    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0 || mat[0].length == 0) return new int[0];
        int n = mat.length, m = mat[0].length;
        int[] res = new int[n * m];
        for (int i = 0, idx = 0; i < n + m - 1; i++)
        {
            if (i % 2 == 0) //偶数对角线
                for (int x = Math.min(i, n - 1); x >= Math.max(0, i - m + 1); x -- ) //从下往上遍历
                    res[idx++] = mat[x][i - x];
            else   		    //奇数对角线
                for (int x = Math.max(0, i - m + 1); x <= Math.min(i, n - 1); x ++ )//从上往下遍历
                    res[idx++] = mat[x][i - x];
        }
        return res;

    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
