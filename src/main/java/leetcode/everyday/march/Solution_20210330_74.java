package leetcode.everyday.march;

import org.springframework.util.Assert;

/**
 *编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 * 通过次数93,340提交次数223,758
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Solution_20210330_74 {


    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null){
            return false;
        }
        boolean flag = false;
        int m =matrix.length;
        int n=matrix[0].length;
        for(int i=0 ; i<m;i++ ){
            if(target >=matrix[i][0]){
                for(int j = 0;j<n;j++){
                    if(target== matrix[i][j]){
                        flag=true;
                        break;
                    }
                }
            }
            else {
                continue;
            }
        }
        return flag;
    }



    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(reverseBits(43261596)==964176192,"程序异常");

        System.out.println("-------------运行通过-------------");
    }
}
