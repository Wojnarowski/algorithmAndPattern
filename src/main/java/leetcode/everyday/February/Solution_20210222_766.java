package leetcode.everyday.February;

import leetcode.everyday.AlgorithmUtil;
import org.springframework.util.Assert;

/**
 *托普利茨矩阵
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 *
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出：true
 * 解释：
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True 。
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,2],[2,2]]
 * 输出：false
 * 解释：
 * 对角线 "[1, 2]" 上的元素不同。
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 20
 * 0 <= matrix[i][j] <= 99
 *  
 *
 * 进阶：
 *
 * 如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？
 * 如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？
 *
 */


public class Solution_20210222_766 {

    /**
     * 思路 1.只需判断当前行的元素与上一行的前一个元素是否相同 即可
     *      1	2	3	4
     *      5	1	2	3
     *      9	5	1	2
     *      时间复杂度：O(mn)O(mn)，其中 mm 为矩阵的行数，nn 为矩阵的列数。矩阵中每个元素至多被访问两次。
     *      空间复杂度：O(1)O(1)，我们只需要常数的空间保存若干变量。
     *
     */
    public static  boolean isToeplitzMatrix(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]!=matrix[i-1][j-1]){
                    return false;
                }
            }
        }
            return true;
    }

    public static void main(String[] args) {
        int [][] a1 = new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println("-------------开始执行-------------");
        AlgorithmUtil.sysoutDobbleArray(a1);
        Assert.isTrue(isToeplitzMatrix(a1)==true,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
