package leetcode.everyday.commit2021.july;

/**
 *
 * 1736 替换隐藏数字得到的最晚时间
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 *
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 *
 * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：time = "2?:?0"
 * 输出："23:50"
 * 解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
 * 示例 2：
 *
 * 输入：time = "0?:3?"
 * 输出："09:39"
 * 示例 3：
 *
 * 输入：time = "1?:22"
 * 输出："19:22"
 *  
 *
 * 提示：
 *
 * time 的格式为 hh:mm
 * 题目数据保证你可以由输入的字符串生成有效的时间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 */
public class Solution_20210724_1736 {


    public String maximumTime(String time) {
        StringBuilder sb = new StringBuilder();
        sb.append(time.charAt(0) == '?' ? (time.charAt(1) == '?' || time.charAt(1) < '4') ? '2' : '1' : time.charAt(0));
        sb.append(time.charAt(1) == '?' ? sb.charAt(0) == '2' ? '3' : '9' : time.charAt(1));
        sb.append(':');
        sb.append(time.charAt(3) == '?' ? '5' : time.charAt(3));
        sb.append(time.charAt(4) == '?' ? '9' : time.charAt(4));
        return sb.toString();

    }



    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //int test[][] = new int[][]{{1,2},{3,4},{5,6}};
        //Assert.isTrue(isCovered(test,2,5)==true,"程序异常");
        int test[][] = new int[][]{{1,2}};
        //Assert.isTrue(isCovered(test,1,50)==true,"程序异常");



        System.out.println("-------------运行通过-------------");
    }
}
