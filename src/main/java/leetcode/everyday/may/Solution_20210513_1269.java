package leetcode.everyday.may;

/**
 *q 1269 停在原地的方案数
 *
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 *
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 *
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 *
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 *
 *  
 *
 *
 *
 * 示例 1：
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 *
 *
 *
 *
 * 示例  2：
 * 输入：steps = 2, arrLen = 4
 * 输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * 向右，向左
 * 不动，不动
 *
 *
 *
 *
 * 示例 3：
 * 输入：steps = 4, arrLen = 2
 * 输出：8
 *  
 *
 * 提示：
 *
 * 1 <= steps <= 500
 * 1 <= arrLen <= 10^6
 * 通过次数7,403提交次数15,792
 *
 *
 */
public class Solution_20210513_1269 {

    /**
     * steps 步后 在 arrLen  内回到索引0处
     * 思路一： 定义 f[i][j]f[i][j] 代表当前剩余操作数为 ii，所在位置为 jj 的所有方案数。
     *
     *
     * @param steps  步数
     * @param arrLen  长度
     * @return
     */
    int mod = (int)1e9+7;
    public int numWays(int steps, int arrLen) {
        int max = Math.min(steps / 2, arrLen - 1);
        int[][] f = new int[steps + 1][max + 1];
        f[steps][0] = 1;
        for (int i = steps - 1; i >= 0; i--) {
            for (int j = 0; j <= max; j++) {
                f[i][j] = (f[i][j] + f[i + 1][j]) % mod;
                if (j - 1 >= 0) f[i][j] = (f[i][j] + f[i + 1][j - 1]) % mod;
                if (j + 1 <= max) f[i][j] = (f[i][j] + f[i + 1][j + 1]) % mod;
            }
        }
        return f[0][0];
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(judgeSquareSum(5)==true,"程序异常");
        //xorQueries(new int[]{1,3,4,8},new int [][]{{0,1},{1,2},{0,3},{3,3}});
        System.out.println("-------------运行通过-------------");
    }
}
