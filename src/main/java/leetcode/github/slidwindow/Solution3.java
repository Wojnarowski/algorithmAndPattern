package leetcode.github.slidwindow;

import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * q3_无重复字符的最长子串
 */
public class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        int left=0,ans=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                left=Math.max(left,map.get(c)+1);
            }
            map.put(c,i);
            ans=Math.max(ans,i-left+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(lengthOfLongestSubstring("abcabcbb")==3,"程序异常");
        Assert.isTrue(lengthOfLongestSubstring("bbbbb")==1,"程序异常");
        Assert.isTrue(lengthOfLongestSubstring("pwwkew")==3,"程序异常");
        Assert.isTrue(lengthOfLongestSubstring("")==0,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
