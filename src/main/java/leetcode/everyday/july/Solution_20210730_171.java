package leetcode.everyday.july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 *  171  Excel表列序号
 *
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 * 输入: "A"
 * 输出: 1
 *
 *
 * 示例 2:
 * 输入: "AB"
 * 输出: 28
 *
 *
 * 示例 3:
 * 输入: "ZY"
 * 输出: 701
 * 致谢：
 * 特别感谢 @ts 添加此问题并创建所有测试用例。
 *
 *
 *
 */
public class Solution_20210730_171 {

    /**
     * 解题思路
     * 标签：字符串遍历，进制转换
     * 初始化结果 ans = 0，遍历时将每个字母与 A 做减法，因为 A 表示 1，所以减法后需要每个数加 1，计算其代表的数值 num = 字母 - ‘A’ + 1
     * 因为有 26 个字母，所以相当于 26 进制，每 26 个数则向前进一位
     * 所以每遍历一位则ans = ans * 26 + num
     * 以 ZY 为例，Z 的值为 26，Y 的值为 25，则结果为 26 * 26 + 25=701
     * 时间复杂度：O(n)O(n)
     *
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for(int i=0;i<columnTitle.length();i++) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(isCovered(test,1,50)==true,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
