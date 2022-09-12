package leetcode.everyday.commit2022.september;

import leetcode.everyday.TreeNode;

/**
 * 1608     特殊数组的特征值
 *
 *
 *
 */
public class Solution_20220912_1608 {

    public int specialArray(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] cnt = new int[max + 1];
        for (int num : nums) {
            cnt[num]++;
        }
        int ans = -1,sum = 0;
        for (int i = max; i > 0; i--) {
            if(cnt[i] != 0) {
                sum += cnt[i];
            }
            if(sum == i) {
                ans = i;
                break;
            }
        }
        return ans;

    }

}
