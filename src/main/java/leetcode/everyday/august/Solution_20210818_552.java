package leetcode.everyday.august;


/**
 *552 学生出勤记录 II
 *
 * 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 *
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 109 + 7 取余 的结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：8
 * 解释：
 * 有 8 种长度为 2 的记录将被视为可奖励：
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * 只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：3
 * 示例 3：
 *
 * 输入：n = 10101
 * 输出：183236316
 *  
 *
 *
 *
 */


public class Solution_20210818_552 {


    public int checkRecord(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 3;
        if(n == 2)
            return 8;

        //下面至少3个连续的评价
        //INIT
        long[][] dp = new long[n + 1][6];
        int max = 1000000007;
        int index = 3;

        dp[2][0] = 1;//含有A，且以L结尾
        dp[2][1] = 0;//含有A，且以LL结尾
        dp[2][2] = 3;//含有A的其他情况

        dp[2][3] = 1;//不含有A，且以L结尾
        dp[2][4] = 1;//不含有A，且以LL结尾
        dp[2][5] = 2;//不含有A的其他情况


        while(index <= n) {
            dp[index][0] = dp[index-1][2]%max;
            dp[index][1] = dp[index-1][0]%max;
            dp[index][2] = (dp[index-1][0]+dp[index-1][1]+dp[index-1][2]+dp[index-1][3]+dp[index-1][4]+dp[index-1][5])%max;

            dp[index][3] = dp[index-1][5]%max;
            dp[index][4] = dp[index-1][3]%max;
            dp[index][5] = (dp[index-1][3]+dp[index-1][4]+dp[index-1][5])%max;

            index++;
        }

        return (int)((dp[n][0]+dp[n][1]+dp[n][2]+dp[n][3]+dp[n][4]+dp[n][5])%max);

    }

    public static void main(String[] args) {
        int [] arr = new int[]{2,2,3,4};

        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(tribonacci(3)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
