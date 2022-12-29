package leetcode.everyday.commit2022.december;

import java.util.ArrayList;
import java.util.List;

/**
 * 2032. 至少在两个数组中出现的值
 *
 */
public class Solution_20221228_2032 {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ret = new ArrayList<>();
        int[] cnt1 = new int[101];
        int[] cnt2 = new int[101];
        int[] cnt3 = new int[101];
        for (int num : nums1) cnt1[num] = 1;
        for (int num : nums2) cnt2[num] = 1;
        for (int num : nums3) cnt3[num] = 1;
        for (int i = 1; i < 101;  i++) if (cnt1[i] + cnt2[i] + cnt3[i]> 1) ret.add(i);
        return ret;
    }
}

