package leetcode.everyday.commit2022.may;

import java.util.*;

/**
 *442 数组中重复的数据
 *
 */


public class Solution_20220508_442 {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                res.add(Math.abs(num));
            } else {
                nums[Math.abs(num) - 1] *= -1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
