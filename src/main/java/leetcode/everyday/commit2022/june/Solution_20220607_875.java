package leetcode.everyday.commit2022.june;

/**
 * 875    爱吃香蕉的珂珂
 *
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * 示例 2：
 *
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * 示例 3：
 *
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 *  
 *
 * 提示：
 *
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 * 通过次数97,253提交次数190,564
 *
 *
 *
 */


public class Solution_20220607_875 {

    public int minEatingSpeed(int[] piles, int h) {
        int maxVal = 1;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }

        // 速度最小的时候，耗时最长
        int left = 1;
        // 速度最大的时候，耗时最短
        int right = maxVal;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (calculateSum(piles, mid) > h) {
                // 耗时太多，说明速度太慢了，下一轮搜索区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;

    }

    private int calculateSum(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            // 上取整可以这样写
            sum += (pile + speed - 1) / speed;
        }
        return sum;
    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
