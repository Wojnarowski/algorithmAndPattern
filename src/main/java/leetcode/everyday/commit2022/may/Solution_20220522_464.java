package leetcode.everyday.commit2022.may;

/**
 * 464  我能赢吗
 *
 * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和 达到或超过  100 的玩家，即为胜者。
 *
 * 如果我们将游戏规则改为 “玩家 不能 重复使用整数” 呢？
 *
 * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
 *
 * 给定两个整数 maxChoosableInteger （整数池中可选择的最大数）和 desiredTotal（累计和），若先出手的玩家是否能稳赢则返回 true ，否则返回 false 。假设两位玩家游戏时都表现 最佳 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：maxChoosableInteger = 10, desiredTotal = 11
 * 输出：false
 * 解释：
 * 无论第一个玩家选择哪个整数，他都会失败。
 * 第一个玩家可以选择从 1 到 10 的整数。
 * 如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
 * 第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
 * 同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
 * 示例 2:
 *
 * 输入：maxChoosableInteger = 10, desiredTotal = 0
 * 输出：true
 * 示例 3:
 *
 * 输入：maxChoosableInteger = 10, desiredTotal = 1
 * 输出：true
 *  
 *
 * 提示:
 *
 * 1 <= maxChoosableInteger <= 20
 * 0 <= desiredTotal <= 300
 * 通过次数16,217提交次数44,016
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/can-i-win
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */


public class Solution_20220522_464 {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if (((maxChoosableInteger + 1) * maxChoosableInteger >> 1) < desiredTotal)// 都加起来也不够
            return false;
        int limit = (1 << maxChoosableInteger) - 1; // 限制位,由maxChoosableInteger每一位上的1表示可用的数字
        int used = 0;// 已经被选中的位置
        // 缓存做过的,Integer记录的是used,Boolean是这个used的结果,算过就不算了
        Boolean[] dp = new Boolean[limit + 1];
        boolean b = this.win(dp, desiredTotal, used, limit);
        return b;
    }

    public boolean win(Boolean[] dp, int desiredTotal, int used, int limit) {
        if (dp[used] != null) {// 算过不算
            return dp[used];// 直接返回
        }
        int avl = limit & (~used);// 当前可用的数字avl
        while (avl > 0) {
            int cur = avl & -avl;// 取出一个可用的位1->1 2->2 4->3
            int num = (int) (Math.log(cur) / Math.log(2)) + 1;// 可用位cur对应的数字num
            if (num >= desiredTotal || !win(dp, desiredTotal - num, used | cur, limit)) {
                dp[used] = true;
                return true;
            }
            avl &= avl - 1;// 当前位置尝试过了,把尝试过的位置从未尝试列表中移除
        }
        dp[used] = false;
        return false;
    }


    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
