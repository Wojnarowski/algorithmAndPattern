package leetcode.everyday.commit2022.october;

import leetcode.everyday.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 940. 不同的子序列 II
 *
 */
public class Solution_20221014_940 {

    public int distinctSubseqII(String s) {
        int mod = (int) 1e9 + 7;
        int n = s.length();
        //之前新增的个数
        int[] preCount = new int[26];
        int curAns = 1;
        char[] chs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            //新增的个数
            int newCount = curAns;
            //当前序列的个数 = 之前的 + 新增的 - 重复的
            curAns = ((curAns + newCount) % mod - preCount[chs[i] - 'a'] % mod + mod) % mod;
            //记录当前字符的 新增值
            preCount[chs[i] - 'a'] = newCount;
        }
        //减去空串
        return curAns - 1;
    }
}
