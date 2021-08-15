package leetcode.everyday.august;


import java.util.HashMap;
import java.util.Map;

/**
 *576. 界的路径数
 *
 * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
 *
 * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/out-of-boundary-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */


public class Solution_20210815_576 {
    private Integer[][][] memo;
    private int[] offsets = new int[] {0,1,0,-1,0};

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new Integer[m][n][maxMove+1];
        return count(m, n, startRow, startColumn, maxMove);
    }
    private int count(int m, int n, int i, int j, int N) {
        if(N < 0) return 0;
        if(i<0||i==m||j<0||j==n) return 1;
        if(memo[i][j][N]!=null) return memo[i][j][N];
        int ans = 0;
        for(int k=0;k<4;k++) {
            ans = (int)(((long)ans + count(m, n, i + offsets[k], j + offsets[k+1], N - 1)) % 1000000007);
        }
        return memo[i][j][N] = ans;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{2,2,3,4};

        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(tribonacci(3)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
