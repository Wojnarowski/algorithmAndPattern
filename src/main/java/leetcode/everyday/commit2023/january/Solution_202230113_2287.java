package leetcode.everyday.commit2023.january;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1806. 还原排列的最少操作步数
 */
public class Solution_202230113_2287 {

    public int rearrangeCharacters(String s, String target) {
        int[] mp1 = new int[128], mp2 = new int[128];
        for (char c : s.toCharArray()) mp1[c]++;
        for (char c : target.toCharArray()) mp2[c]++;
        int ans = 105;
        for (char c : target.toCharArray()) ans = Math.min(mp1[c] / mp2[c], ans);;
        return ans;
    }


}
