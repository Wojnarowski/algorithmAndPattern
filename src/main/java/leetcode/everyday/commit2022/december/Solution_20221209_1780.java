package leetcode.everyday.commit2022.december;

/**
 * 1780. 判断一个数字是否可以表示成三的幂的和
 *
 */
public class Solution_20221209_1780 {
    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 == 0 || n % 3 == 1) n = n / 3; // 满足三进制
            else return false; // 不满足三进制，返回false
        }
        return true;
    }
}
