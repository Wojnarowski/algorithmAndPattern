package leetcode.everyday.commit2022.december;

/**
 * 1764. 通过连接另一个数组的子数组得到一个数组
 *
 */
public class Solution_20221217_1764 {
    public boolean canChoose(int[][] groups, int[] nums) {
        int p1 = 0, p2, n = nums.length;
        for (int[] g : groups) {
            p2 = 0;
            while (p2 < g.length && p1 < n) {
                if (nums[p1++] == g[p2]) p2++;
                else {p1 -= p2; p2 = 0;} //回到开头的下一个数字重新开始
            }
            if (p1 >= n && p2 != g.length) return false;
        }
        return true;
    }
}

