package leetcode.everyday.commit2023.january;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 1806. 还原排列的最少操作步数
 */
public class Solution_202230111_2283 {

    public boolean digitCount(String num) {
        int[] mp = new int[10];
        for (char c : num.toCharArray()) mp[c - '0']++;
        for (int i = 0; i < num.length(); i++) if (mp[i] != num.charAt(i) - '0')  return false;
        return true;
    }
}
