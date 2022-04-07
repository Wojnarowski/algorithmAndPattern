package leetcode.everyday.commit2022.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 796  旋转字符串
 *
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 *
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。 
 *
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 *  
 *
 * 提示:
 *
 * 1 <= s.length, goal.length <= 100
 * s 和 goal 由小写英文字母组成
 * 通过次数59,416提交次数95,579
 * 请问您在哪类招聘中遇到此题？
 *
 *
 */
public class Solution_20220407_796 {

    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (goal + goal).contains(s);
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
