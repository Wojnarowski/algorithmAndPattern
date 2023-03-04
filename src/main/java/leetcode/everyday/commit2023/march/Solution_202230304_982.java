package leetcode.everyday.commit2023.march;

/**
 * 2351. 第一个出现两次的字母
 */
public class Solution_202230304_982 {

    public int countTriplets(int[] nums) {
        int[] count = new int[1 << 16];
        for (int i : nums) {
            for (int j : nums) {
                count[i & j]++;
            }
        }
        int ans = 0;
        for (int k : nums) {
            for (int mask = 0; mask < (1 << 16); ++mask) {
                if ((k & mask) == 0) {
                    ans += count[mask];
                }
            }
        }
        return ans;
    }
}
