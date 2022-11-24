package leetcode.everyday.commit2022.november;

/**
 * 1742. 盒子中小球的最大数量
 *
 */
public class Solution_20221122_1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int ans = 0;
        int[] cnts = new int[50];
        for (int i = lowLimit; i <= highLimit; i++) {
            int j = i, cur = 0;
            while (j != 0) {
                cur += j % 10; j /= 10;
            }
            if (++cnts[cur] > ans) ans = cnts[cur];
        }
        return ans;
    }
}
