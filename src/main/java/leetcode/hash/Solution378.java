package leetcode.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 示例：
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 */
public class Solution378 {

    public static int  firstUniqChar(String s) {

        Map<Character,Integer> map = new HashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        for(char ch:chars){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<chars.length;i++){
            if(map.get(chars[i])==1){
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar_3(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar_5(String s) {
        int res = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = s.indexOf(ch);
            if (index != -1 && index == s.lastIndexOf(ch)) {
                res = (res == -1 || res > index) ? index : res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //String str="leetcode";
        String str="loveleetcode";
        //String str="cc";
        //String str="aadadaad";
        System.out.println(firstUniqChar_5(str));
    }
}
