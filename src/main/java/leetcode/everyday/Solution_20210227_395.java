package leetcode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 
 * 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 *  
 *
 * 示例 1：
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 *
 *
 *
 *
 * 示例 2：
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由小写英文字母组成
 * 1 <= k <= 105
 *
 */


public class Solution_20210227_395 {

    /**
     * 思路1：递归
     * @param s
     * @param k
     * @return
     */
    public static int longestSubstring1(String s, int k) {
        if(s.length()<k){
            return 0;
        }
        HashMap<Character, Integer> counter= new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(char c:counter.keySet()){
            if(counter.get(c)<k){
                int res = 0 ;
                for(String t:s.split(String.valueOf(c))){
                    res=Math.max(res,longestSubstring1(t,k));
                }
                return res;
            }
        }
        return s.length();


    }

    public static void main(String[] args) {
        String s="ababbc";
        int k=2;
        System.out.println("-------------开始执行-------------");
        int result = longestSubstring1(s,k);
        System.out.println(result);
        System.out.println("-------------运行通过-------------");

    }
}
