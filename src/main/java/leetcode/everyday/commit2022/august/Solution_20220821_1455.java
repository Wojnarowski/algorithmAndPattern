package leetcode.everyday.commit2022.august;

import leetcode.everyday.TreeNode;

/**
 * 1455 检查单词是否为句中其他单词的前缀
 *
 *
 *
 */
public class Solution_20220821_1455 {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] ss = sentence.split(" ");
        int n = ss.length, m = searchWord.length();
        for (int i = 0; i < n; i++) {
            if (ss[i].length() < m) continue;
            boolean ok = true;
            for (int j = 0; j < m && ok; j++) {
                if (ss[i].charAt(j) != searchWord.charAt(j)) ok = false;
            }
            if (ok) return i + 1;
        }
        return -1;

    }

}
