package leetcode.everyday.commit2021.april;

import org.springframework.util.Assert;

/**
 *q 154 丑数
 *
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 *  
 *
 * 示例 1：
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 *
 *
 * 示例 2：
 * 输入：n = 8
 * 输出：true
 * 解释：8 = 2 × 2 × 2
 *
 *
 *
 * 示例 3：
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 *
 *
 * 示例 4：
 * 输入：n = 1
 * 输出：true
 * 解释：1 通常被视为丑数。
 *  
 *
 * 提示：
 *
 * -231 <= n <= 231 - 1
 * 通过次数78,246提交次数153,199
 *
 */
public class Solution_20210410_263 {


    public static boolean isUgly(int n) {
        if(n<=0){
            return false;
        }
        while (n%2==0) n=n/2;
        while (n%3==0) n=n/3;
        while (n%5==0) n=n/5;
        return n==1;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(isUgly(6)==true,"程序异常");
        Assert.isTrue(isUgly(8)==true,"程序异常");
        Assert.isTrue(isUgly(14)==false,"程序异常");
        Assert.isTrue(isUgly(1)==true,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
