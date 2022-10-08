package leetcode.everyday.commit2022.october;

import java.util.TreeMap;

/**
 * 870. 优势洗牌
 *
 *
 */
public class Solution_20221088_870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        //存放num1的元素
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] ans = new int[n];
        //遍历num2
        for (int i = 0; i < nums2.length; i++) {
            //找到大于 nums[i]的最小元素 略胜一筹
            Integer higher = map.higherKey(nums2[i]);
            //没有取 num1 中的最小值
            if (higher == null) {
                higher = map.firstKey();
            }
            ans[i] = higher;
            if (map.get(higher) == 1) {
                map.remove(higher);
            } else {
                map.put(higher, map.get(higher) - 1);
            }
        }
        return ans;
    }
}
