package leetcode.everyday.commit2023.january;

/**
 * 2180. 统计各位数字之和为偶数的整数个数
 */
public class Solution_202230106_2180 {

    public int countEven(int num) {
        int ans = 0, t, s;
        for (int i = 2; i <= num; i++) {
            for (s = 0, t = i; t > 0; t /= 10) s += t % 10;
            ans += s & 1 ^ 1; // s & 1若为偶数则为0，若为奇数则为1, 再^1
        }
        return ans;
    }
}
