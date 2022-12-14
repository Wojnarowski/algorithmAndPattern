package leetcode.everyday.commit2022.december;

import java.util.Arrays;

/**
 * 1832. 判断句子是否为全字母句
 *
 */
public class Solution_20221213_1832 {
    public boolean checkIfPangram(String sentence) {
        int[] mp = new int[26];
        for (char c : sentence.toCharArray()) mp[c - 'a'] = 1;
        return Arrays.stream(mp).sum() == 26;
    }
}

