package leetcode.everyday.commit2023.january;

import java.util.HashMap;
import java.util.Map;

/**
 * 2185. 统计包含给定前缀的字符串
 */
public class Solution_202230108_12185 {

    public int prefixCount(String[] words, String pref) {
        int ans =0;
        for(int i=0;i<words.length;i++){
            if(words[i].startsWith(pref)){
                ans++;
            }
        }
        return ans;

    }
}
