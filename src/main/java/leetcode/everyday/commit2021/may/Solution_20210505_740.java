package leetcode.everyday.commit2021.may;

/**
 *q 740 删除并获得点数
 *
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 *
 *
 *
 * 示例 2：
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 *  
 *
 */
public class Solution_20210505_740 {

    public static  int deleteAndEarn(int[] nums) {
        int n = nums.length;        //获取数组
        if (n == 0 || nums == null) return 0;
        if (n == 1) return nums[0];
        /*
         * 要将本题改为打家劫舍问题的题型，首先需要明确这个题与打家劫舍问题的联系与区别
         * 首先回想“打家劫舍”，打劫了一间房子，则左右相邻的房子不能取。
         * 再看本题，若取一个数，则左右相邻的数不能取，是不是很相似，却又有那么点不一样，
         * 因为本题中“本该相邻的房子”并不相邻，即数字是乱序的；
         * 另外，存在“同样的房子”，即有相同的数字
         * 因此首要任务就是将“本该相邻而并不相邻的房子 ”转换成为 “相邻的房子”
         * */
        int maxNum = nums[0];
        //  用来获取整个数组的最大值，即桶的个数，因为相同的数字可能出现不止一次，因此使用下标为0-max的数组记录其出现次数
        for (int i = 1; i < nums.length; i++) {
            maxNum = Math.max(maxNum, nums[i]);

        }
        int[] dp = new int[maxNum + 1];     //创建桶数组
        for (int each : nums) {
            //  将元素和它对应的桶关联起来，且数组元素的值为其出现次数*下标元素
            //  例如：2出现了2次，3出现了3次，4出现了1次
            //  则 dp[2] = 2*2 = 4 ;
            //  dp[3] = 3*3 = 9
            //  dp[4] = 1*4 = 4
            dp[each] += each;

        }
        int res = 0;        //记录最大结果

        for (int i = 2; i < dp.length; i++) {   //打家劫舍思想，不能偷相邻的房子
            dp[i] = Math.max(dp[i - 2] + dp[i], dp[i - 1]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(judgeSquareSum(5)==true,"程序异常");
        System.out.println(2^2);
        System.out.println("-------------运行通过-------------");
    }
}
