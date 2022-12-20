package leetcode.everyday.commit2022.december;

/**
 * 1760. 袋子里最少数目的球
 *
 */
public class Solution_20221220_1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int ans = 0;
        int l = 1, r = 1000000000;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            int cut = 0;
            for (int num : nums) {
                if (num > m) {
                    cut += num / m;
                    if (num % m == 0) {
                        cut -= 1;
                    }
                    if (cut > maxOperations) {
                        break;
                    }
                }
            }
            if (cut > maxOperations) {
                l = m + 1;
            } else {
                ans = m;
                r = m - 1;
            }
        }
        return ans;
    }
}

