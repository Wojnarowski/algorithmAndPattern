package leetcode.everyday.commit2022.november;

/**
 *1758. 生成交替二进制字符串的最少操作数
 *
 */
public class Solution_20221129_1758 {

    public int minOperations(String s) {
        int z = 0, o = 0; 	// 以0开头的，以1开头的，不相符计数
        for (int i = 0, flag = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' == flag) {	// flag视作010101..交替序列，相同则z开头相符
                o++;	// 0开头不相符
            } else {
                z++;	// z开头不相符
            }
            flag = 1 - flag;
        }
        return Math.min(z, o);
    }
}
