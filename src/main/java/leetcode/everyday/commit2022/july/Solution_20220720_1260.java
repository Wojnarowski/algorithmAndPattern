package leetcode.everyday.commit2022.july;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 1260  二维网格迁移
 *
 *
 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。

 每次「迁移」操作将会引发下述活动：

 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 请你返回 k 次迁移操作后最终得到的 二维网格。

  

 示例 1：



 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 输出：[[9,1,2],[3,4,5],[6,7,8]]
 示例 2：



 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 示例 3：

 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 输出：[[1,2,3],[4,5,6],[7,8,9]]
  

 提示：

 m == grid.length
 n == grid[i].length
 1 <= m <= 50
 1 <= n <= 50
 -1000 <= grid[i][j] <= 1000
 0 <= k <= 100

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/shift-2d-grid
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 */


public class Solution_20220720_1260 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len =grid.length , len2 = grid[0].length;
        for(int i=0;i<k;i++){
            grid = shitftSignlGrid(grid);
        }
        for(int i=0;i<len;i++){
            List<Integer>  list = new ArrayList<>();
            for(int j=0;j<len2;j++){
                list.add(grid[i][j]);
            }
            result.add(list);
        }
        return result;

    }

    public int[][] shitftSignlGrid(int[][] grid){
        int len =grid.length , len2 = grid[0].length;
        int[][] newgrid = new int[len][len2];
        for(int i=0;i<len2;i++){
            for(int j=0;j<len;j++){
                if(i!=len2-1){
                    newgrid[j][i+1] = grid[j][i];
                }else if(i==len2-1 && j!=len-1){
                    newgrid[j+1][0] = grid[j][i];
                }else {
                    newgrid[0][0] = grid[j][i];
                }

            }
        }
        return newgrid;
    }


    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
