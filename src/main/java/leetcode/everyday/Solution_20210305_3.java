package leetcode.everyday;

import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 *  
 *
 *
 */
public class Solution_20210305_3 {

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s==null){
            return 0;
        }
        int f[]=new int[s.length()];
        f[0]=1;
        int ans=1;
        for(int i=1;i<s.length();i++){
            for(int j=i-1;j>=0;j--){
                if(s.charAt(i)==s.charAt(j)){
                   break;
                }
                f[i]=Math.max(f[i],f[j]+1);
            }

            ans=Math.max(ans,f[i]);
        }
        return ans;
    }


    /**
     * 1.遍历字符串，用哈希表记录每个字符的索引
     * 2.left用于记录字符串的最左侧索引，maxLen用于记录子串的最大长度
     * 3.如果当前遍历到的字符已在哈希表中存在，说明是个重复字符
     * 子串的左侧索引应该从该字符前一次出现的索引的下一个位置开始
     * 但是因为前一个字符可能已不在子串中，还要和left自身取一下最大值
     * 即，left = max(left, hashmap[c] + 1)
     * 4.子串的长度即为当前索引 i - 左侧索引 left + 1, maxLen取子串长度的最大值
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> hashMap= new HashMap<>();
        int left=0,maxLen=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(hashMap.containsKey(c)){
                left=Math.max(left,hashMap.get(c)+1);
            }
            hashMap.put(c,i);
            maxLen=Math.max(maxLen,i-left+1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(lengthOfLongestSubstring2("abcabcbb")==3,"程序异常");
        Assert.isTrue(lengthOfLongestSubstring2("bbbbb")==1,"程序异常");
        Assert.isTrue(lengthOfLongestSubstring2("pwwkew")==3,"程序异常");
        Assert.isTrue(lengthOfLongestSubstring2("")==0,"程序异常");
        System.out.println("-------------运行通过-------------");
    }


}
