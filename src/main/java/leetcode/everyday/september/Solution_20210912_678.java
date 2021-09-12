package leetcode.everyday.september;

/**
 *q 678  有效的括号字符串
 *
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 *
 * 输入: "()"
 * 输出: True
 * 示例 2:
 *
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 *
 * 输入: "(*))"
 * 输出: True
 * 注意:
 *
 * 字符串大小将在 [1，100] 范围内。
 *
 *
 */
public class Solution_20210912_678 {

    public boolean checkValidString(String s) {
        int min = 0, max = 0; // 维护当前左括号的数量范围：[min, max]
        char[] chars = s.toCharArray();
        for(char i : chars) {
            if(i == '(') {
                min++;
                max++;
            }else if(i == ')') {
                //min > 0才--
                if(min > 0) min--;
                if(max-- == 0) return false;
            }else {
                //min > 0才--
                if(min > 0) min--;
                max++;
            }
        }
        return min == 0;

    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //int [] array= new int[]{-1,0,3,5,9,12};
        //int target =2;
        //Assert.isTrue(search(array,target)==-1,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
