package leetcode.everyday.commit2022.october;

import java.util.*;

/**
 * 784. 字母大小写全排列
 */
public class Solution_20221030_784 {

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, res);
        return res;
    }
    private void dfs(char[] charArray, int index, List<String> res) {
        if (index == charArray.length) {
            res.add(new String(charArray));
            return;
        }

        dfs(charArray, index + 1, res);
        if (Character.isLetter(charArray[index])) {
            charArray[index] ^= 1 << 5;
            dfs(charArray, index + 1, res);
        }
    }
}
