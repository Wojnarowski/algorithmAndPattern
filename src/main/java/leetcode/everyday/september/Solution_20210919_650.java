package leetcode.everyday.september;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *q 650    只有两个键盘
 *
 *最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
 *
 * Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
 * Paste（粘贴）：粘贴 上一次 复制的字符。
 * 给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：3
 * 输出：3
 * 解释：
 * 最初, 只有一个字符 'A'。
 * 第 1 步, 使用 Copy All 操作。
 * 第 2 步, 使用 Paste 操作来获得 'AA'。
 * 第 3 步, 使用 Paste 操作来获得 'AAA'。
 * 示例 2：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/2-keys-keyboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_20210919_650 {

    /**
     * https://leetcode-cn.com/problems/2-keys-keyboard/solution/tong-ge-lai-shua-ti-la-yi-ti-wu-jie-bao-qg6qr/
     * @param n
     * @return
     */
    int INF = 10000;
    public int minSteps(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <=n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 2; i <=n; i++) {
            int min = INF;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    if (i != j) {
                        dp[i][j] = dp[i - j][j] + 1;
                        min = Math.min(min, dp[i][j]);
                    } else {
                        dp[i][j] = min + 1;
                    }
                }
            }
        }

        return IntStream.of(dp[n]).min().getAsInt();

    }
    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{1,2,3,1};
        //Assert.isTrue(findPeakElement(array)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
