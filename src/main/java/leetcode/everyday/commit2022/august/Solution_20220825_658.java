package leetcode.everyday.commit2022.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 658 找到 K 个最接近的元素
 *
 *
 *
 */
public class Solution_20220825_658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;

        int left = 0;
        int right = size - 1;

        int removeNums = size - k;
        while (removeNums > 0) {
            if (x - arr[left] <= arr[right] - x) {
                right--;
            } else {
                left++;
            }
            removeNums--;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;

    }

}
