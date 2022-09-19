package leetcode.everyday.commit2022.september;

import java.util.*;

/**
 * 1636. 按照频率将数组升序排序
 *
 *
 *
 */
public class Solution_20220919_1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int num : nums) {
            cnts.put(num, cnts.getOrDefault(num, 0) + 1);
        }
        Integer[] sort = new Integer[nums.length];
        for (int i = 0; i < sort.length; i++) {
            sort[i] = nums[i];
        }
        Arrays.sort(sort, (a, b) -> cnts.get(a) - cnts.get(b) == 0 ? b - a : cnts.get(a) - cnts.get(b));
        for (int i = 0; i < sort.length; i++) {
            nums[i] = sort[i];
        }
        return nums;

    }
}
