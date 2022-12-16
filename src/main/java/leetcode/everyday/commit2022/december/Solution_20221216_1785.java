package leetcode.everyday.commit2022.december;

/**
 * 1785. 构成特定和需要添加的最少元素
 *
 */
public class Solution_20221216_1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }
        if(sum == goal) return 0;
        long target = Math.abs(goal - sum);
        return (int)((target + limit - 1) / limit);
    }
}

