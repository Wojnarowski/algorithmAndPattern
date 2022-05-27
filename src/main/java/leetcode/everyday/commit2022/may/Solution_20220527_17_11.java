package leetcode.everyday.commit2022.may;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 面试题 17.11. 单词距离
 *
 * 有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 *
 * 示例：
 *
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 * 提示：
 *
 * words.length <= 100000
 * 通过次数23,169提交次数32,660
 * 请问您在哪类招聘中遇到此题？
 *
 *  
 *
 *
 *
 */


public class Solution_20220527_17_11 {

    public int findClosest(String[] words, String word1, String word2) {
        int n = words.length, ans = n;
        for (int i = 0, p = -1, q = -1; i < n; i++) {
            String t = words[i];
            if (t.equals(words)) p = i;
            if (t.equals(word2)) q = i;
            if (p != -1 && q != -1) ans = Math.min(ans, Math.abs(p - q));
        }
        return ans;

    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
