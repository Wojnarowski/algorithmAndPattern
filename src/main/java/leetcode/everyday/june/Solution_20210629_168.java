package leetcode.everyday.june;

import org.springframework.util.Assert;

import java.util.*;

/**
 *q 168  Excel表列名称
 *
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 *
 * 例如：
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *  
 *
 * 示例 1：
 *
 * 输入：columnNumber = 1
 * 输出："A"
 * 示例 2：
 *
 * 输入：columnNumber = 28
 * 输出："AB"
 * 示例 3：
 *
 * 输入：columnNumber = 701
 * 输出："ZY"
 * 示例 4：
 *
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 *  
 *
 * 提示：
 *
 * 1 <= columnNumber <= 231 - 1
 *
 *
 */
public class Solution_20210629_168 {


    /**
     * 思路 进制转换
     * @param columnNumber
     * @return
     */
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        sb.reverse();
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(convertToTitle(1).equals("A"),"程序异常");
        //Assert.isTrue(convertToTitle(28).equals("AB"),"程序异常");
        Assert.isTrue(convertToTitle(701).equals("ZY"),"程序异常");
        //Assert.isTrue(convertToTitle(2147483647).equals("FXSHRXW"),"程序异常");



        System.out.println("-------------运行通过-------------");
    }
}
