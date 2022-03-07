package leetcode.everyday.commit2022.march;

import java.util.ArrayList;
import java.util.List;

/**
 * 504 七进制数
 *
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: num = 100
 * 输出: "202"
 * 示例 2:
 *
 * 输入: num = -7
 * 输出: "-10"
 *  
 *
 * 提示：
 *
 * -107 <= num <= 107
 * 通过次数44,048提交次数85,690
 * 请问您在哪类招聘中遇到此题？
 *
 *
 */
public class Solution_20220307_504 {


    public String convertToBase7(int num) {
        boolean flag = num < 0;
        if (flag) num = -num;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(num % 7);
            num /= 7;
        } while (num != 0);
        sb.reverse();
        return flag ? "-" + sb.toString() : sb.toString();

    }


    public static void main(String[] args) {


        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
