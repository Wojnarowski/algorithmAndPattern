package leetcode.everyday.commit2021.june;

/**
 *q 877 石子游戏
 *
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 *
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 *
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 *
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 *
 *  
 *
 * 示例：
 *
 * 输入：[5,3,4,5]
 * 输出：true
 * 解释：
 * 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
 * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
 * 如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
 * 如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
 * 这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
 *  
 *
 * 提示：
 *
 * 2 <= piles.length <= 500
 * piles.length 是偶数。
 * 1 <= piles[i] <= 500
 * sum(piles) 是奇数。
 *
 *
 */
public class Solution_20210616_877 {


    /**
     * 动态规划思想是希望连续的，也就是说上一个状态和下一个状态(自变量)之间有关系而且连续。
     *
     * 如果涉及到最多，最少的，一般使用动态规划。
     *
     * dp[i][j]dp[i][j]：表示先手玩家（亚历克斯）与后手玩家（李）在区间 [i, j][i,j] 之间互相拿，先手玩家比后手玩家多的最大石子个数。这是个差值，而且是个最大差值。
     *
     * 对于先手玩家，有两种拿法：
     *
     * 拿开头的 piles[i]piles[i]：先手玩家手里有了 piles[i]piles[i]，因为在区间 [i + 1, j][i+1,j] 中只能由后手玩家来选择，则 dp[i + 1][j]dp[i+1][j] 表示的是后手玩家在这个区间内，比先手玩家多的最大石子个数，反过来 -dp[i + 1][j]−dp[i+1][j] 表示在这个区间内，先手玩家比后手玩家多的最大石子个数；
     * 状态转移方程：dp[i][j] = piles[i] + (-dp[i + 1][j])
     *
     * 拿结尾的 piles[j]piles[j]：先手玩家手里有了 piles[j]piles[j]，因为在区间 [i, j - 1][i,j−1] 中只能由后手玩家来选择，则 dp[i][j - 1]dp[i][j−1] 表示的是后手玩家在这个区间内，比先手玩家多的最大石子个数，反过来 -dp[i][j - 1]−dp[i][j−1] 表示在这个区间内，先手玩家比后手玩家多的最大石子个数；
     * 状态转移方程：dp[i][j] = piles[j] + (-dp[i][j - 1])
     *
     * 在这两种情况中，选择先手玩家和后手玩家选择石子堆后，石子个数差更大的一种情况：dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1])dp[i][j]=Math.max(piles[i]−dp[i+1][j],piles[j]−dp[i][j−1])
     *
     * 初始化：当只有一个数时 dp[i][i]dp[i][i]，此时先手玩家拿了必赢，所以 dp[i][i] = piles[i]dp[i][i]=piles[i]。
     *
     * 对于区间 dpdp 来说，将 ii 从 n - 1n−1 往前遍历到 00，而 jj 从 ii 位置往后遍历到 n - 1n−1，这样能够方便 i < ji<j，将大区间划分成小区间。从小区间开始判断，不断的扩大我们的判断范围看会不会赢
     *
     *
     * 实例：piles = [1, 5, 233, 7]，dp[0][0] = 1、dp[1][1] = 5、dp[2][2] = 233、dp[3][3] = 7
     * i = 3，j = 4 直接跳过；
     *
     * i = 2，j = 3，区间 [2, 3] dp[2][3] = max(233 - 7, 7 - 233) = 226；
     *
     * i = 1，j = 2，区间 [1, 2] dp[1][2] = max(5 - 233, 233 - 5) = 228；
     *        j = 3，区间 [1, 3] dp[1][3] = max(5 - 226, 7 - 228) = -221；
     *
     * i = 0，j = 1，区间 [0, 1] dp[0][1] = max(1 - 5, 5 - 1) = 4；
     *        j = 2，区间 [0, 2] dp[0][2] = max(1 - 228, 233 - 4) = 229；
     *        j = 3，区间 [0, 3] dp[0][3] = max(1 + 221, 7 - 229) = 222；
     *
     * 区间 [0, 3] 即 dp[0][3] = 222 > 0，则先手玩家（亚历克斯）会赢。
     *
     * @param piles
     * @return
     */
    public static boolean stoneGame(int[] piles) {
        int n=piles.length;
        if(n==0){
            return false;
        }
        int [][]dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i] = piles[i];
        }
        for(int i =n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }

    /**
     *事实上，这还是一道很经典的博弈论问题，也是最简单的一类博弈论问题。
     *
     * 为了方便，我们称「石子序列」为石子在原排序中的编号，下标从 11 开始。
     *
     * 由于石子的堆数为偶数，且只能从两端取石子。因此先手后手所能选择的石子序列，完全取决于先手每一次决定。
     *
     * 由于石子的堆数为偶数，对于先手而言：每一次的决策局面，都能「自由地」选择奇数还是偶数的序列，从而限制后手下一次「只能」奇数还是偶数石子。
     *
     * 具体的，对于本题，由于石子堆数为偶数，因此先手的最开始局面必然是 [奇数, 偶数][奇数,偶数]，即必然是「奇偶性不同的局面」；当先手决策完之后，交到给后手的要么是 [奇数,奇数][奇数,奇数] 或者 [偶数,偶数][偶数,偶数]，即必然是「奇偶性相同的局面」；后手决策完后，又恢复「奇偶性不同的局面」交回到先手 ...
     *
     * 不难归纳推理，这个边界是可以应用到每一个回合。
     *
     * 因此先手只需要在进行第一次操作前计算原序列中「奇数总和」和「偶数总和」哪个大，然后每一次决策都「限制」对方只能选择「最优奇偶性序列」的对立面即可。
     *
     * 同时又由于所有石子总和为奇数，堆数为偶数，即没有平局，所以先手必胜。
     *
     * @param piles
     * @return
     */
    public static boolean stoneGame2(int[] piles) {
        return true;
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(peakIndexInMountainArray1(new int[]{0,1,0})==1,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}