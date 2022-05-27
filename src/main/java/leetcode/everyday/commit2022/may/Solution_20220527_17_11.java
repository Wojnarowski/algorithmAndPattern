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
        int ans = Integer.MAX_VALUE;
        //单词1的位置
        int word1Index = -1;
        //单词2的位置
        int word2Index = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                word1Index = i;
            }
            if (words[i].equals(word2)) {
                word2Index = i;
            }
            //计算距离并去最小值
            if (word1Index != -1 && word2Index != -1) {
                ans = Math.min(Math.abs(word1Index - word2Index), ans);
                //1就是最小
                if (ans == 1) {
                    return ans;
                }
            }
        }
        return ans;


    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
