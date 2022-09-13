package leetcode.everyday.commit2022.september;

/**
 * 670     最大交换
 *
 *
 *
 */
public class Solution_20220913_670 {

    public int maximumSwap(int num) {
        int[] nums = new int[10];
        int p = 0;
        while (num > 0) {
            nums[p++] = num % 10;
            num /= 10;
        }
        for (int i = p - 1; i > 0; i--) {
            int cur = nums[i];
            int big = cur, index = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] >= big) {
                    big = nums[j];
                    index = j;
                }
            }
            if (index != -1 && nums[i] != nums[index]) {
                nums[i] = nums[index];
                nums[index] = cur;
                break;
            }
        }
        int ans = 0;
        for (int i = p - 1; i >= 0; i--) {
            ans = ans * 10 + nums[i];
        }
        return ans;

    }

}
