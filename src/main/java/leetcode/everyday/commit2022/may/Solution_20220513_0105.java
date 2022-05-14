package leetcode.everyday.commit2022.may;

/**
 * 0105 一次编辑
 *
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 * 通过次数51,635提交次数153,178
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */


public class Solution_20220513_0105 {

    public boolean oneEditAway(String first, String second) {        int n = first.length(), m = second.length();
        if (Math.abs(n - m) > 1) return false;
        if (n > m) return oneEditAway(second, first);
        int i = 0, j = 0, cnt = 0;
        while (i < n && j < m && cnt <= 1) {
            char c1 = first.charAt(i), c2 = second.charAt(j);
            if (c1 == c2) {
                i++; j++;
            } else {
                if (n == m) {
                    i++; j++; cnt++;
                } else {
                    j++; cnt++;
                }
            }
        }
        return cnt <= 1;


    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
