package leetcode.everyday.commit2021.september;

/**
 *q 371 两整数之和
 *
 *
 *
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
 *
 *  
 *
 * 示例 1：
 * 输入：a = 1, b = 2
 * 输出：3
 *
 *
 * 示例 2：
 * 输入：a = 2, b = 3
 * 输出：5
 *
 */
public class Solution_20210926_371 {

    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{1,2,3,1};
        //Assert.isTrue(findPeakElement(array)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
