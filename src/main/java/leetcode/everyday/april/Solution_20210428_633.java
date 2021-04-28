package leetcode.everyday.april;

import org.springframework.util.Assert;

/**
 *q 633 平方数之和
 *
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 *
 * 示例 2：
 * 输入：c = 3
 * 输出：false
 *
 *
 *
 * 示例 3：
 * 输入：c = 4
 * 输出：true
 *
 *
 * 示例 4：
 * 输入：c = 2
 * 输出：true
 *
 *
 * 示例 5：
 * 输入：c = 1
 * 输出：true
 *  
 *
 * 提示：
 *
 * 0 <= c <= 231 - 1
 *
 *
 */
public class Solution_20210428_633 {

    public static  boolean judgeSquareSum(int c) {
      int max =(int) Math.sqrt(c);
      for(int a=0;a<=max;a++){
        int b = (int) Math.sqrt(c-a*a);
        if(a*a+b*b==c){
            return true;
        }
      }
      return false;
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(judgeSquareSum(5)==true,"程序异常");
        Assert.isTrue(judgeSquareSum(3)==false,"程序异常");

        System.out.println("-------------运行通过-------------");
    }
}
