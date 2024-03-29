package leetcode.everyday.commit2023.hot100;

import leetcode.everyday.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 无重复字符的最长子串
 */
public class Hot100_3 {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length(),ans=0;
        Map<Character,Integer> map = new HashMap<>();
        for(int end=0,start=0;end<n;end++){
            char alpha = s.charAt(end);
            if(map.containsKey(alpha)){
                start=Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}
