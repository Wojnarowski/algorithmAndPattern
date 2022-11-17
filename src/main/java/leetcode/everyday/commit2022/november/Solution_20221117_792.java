package leetcode.everyday.commit2022.november;

/**
 * 792. 匹配子序列的单词数
 *
 */
public class Solution_20221117_792 {

    /**
     * 多指针优化 对于解法一，每个words中的字符串都会对s进行一次比较，
     * 那么其实可以反向思维一下，我们在s字符串上进行移动，
     * 我们给每一个word里面的字符串都加上一个指针，指针最开始的字符。
     * 若s当前的字符为c,那么所有words里面指针指向c这个字符的指针都应该往后移动，
     * 若移动到末尾，那么代表找到一个子序列。
     * 按照这个思路可以很简单写出如下代码。
     *
     * @param s
     * @param words
     * @return
     */
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        int[] p = new int[words.length]; //每个字符串的指针
        for (char c : s.toCharArray()) { // O(n)
            for (int i = 0; i < p.length; i++) if (p[i] < words[i].length() && words[i].charAt(p[i]) == c) p[i]++; //O(m)
        }
        for (int i = 0; i < p.length; i++) if (p[i] == words[i].length()) ans++;
        return ans;
    }
}
