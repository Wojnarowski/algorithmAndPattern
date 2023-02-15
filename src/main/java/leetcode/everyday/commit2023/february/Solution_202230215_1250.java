package leetcode.everyday.commit2023.february;

/**
 * 1234. 替换子串得到平衡字符串
 */
public class Solution_202230215_1250 {

    public boolean isGoodArray(int[] nums) {
        final int n = nums.length;
        int s = nums[0];
        for (int i = 1; i < n; i++) {
            s = gcd(s, nums[i]);
            if (s == 1) {
                return true;
            }
        }
        return s == 1;
    }

    private int gcd(int a, int b) {
        if (b == 0)  return a;
        return gcd(b, a % b);
    }

}
