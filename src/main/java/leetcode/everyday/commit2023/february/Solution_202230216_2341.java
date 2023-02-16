package leetcode.everyday.commit2023.february;

import java.util.*;

/**
 * 1234. 替换子串得到平衡字符串
 */
public class Solution_202230216_2341 {

    public int[] numberOfPairs(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i : nums) if(!s.add(i)) s.remove(i);
        return new int[]{(nums.length - s.size()) / 2, s.size()};
    }

}
