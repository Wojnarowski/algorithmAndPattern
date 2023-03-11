package leetcode.everyday.commit2023.march;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.05. 字母与数字
 */
public class Solution_202230311_1705 {
    public String[] findLongestSubarray(String[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = array.length;
        int charCount = 0;      // 记录前缀字母个数C[i]
        int numberCount = 0;    // 记录前缀数字个数N[i]
        int longest = 0;        // 记录最长子数组长度
        int start = 0;          // 记录最长子数组的起点位置
        int value;
        int a;
        int s;
        map.put(0, -1);         // 初始化字典
        for(int i = 0; i < len; i++){
            // 判断当前字符是字母还是数字
            value = array[i].charAt(0) - '0';
            if(value >= 0 && value <= 9){
                numberCount++;
            }else{
                charCount++;
            }
            a = charCount - numberCount;    // 计算A值
            if(map.containsKey(a)){
                // 存在与当前位置一样A值的位置，且区间长度更大，更新最长长度和起点
                if(i - (s = map.get(a)) > longest){
                    longest = i - s;
                    start = s + 1;  // 存的坐标为s，表示的区间为[s+1, i]
                }
            }else{
                // 不存在这个A值，将A值和位置加入哈希表
                map.put(a, i);
            }
        }
        // 根据记录的最长长度和起点，生成子数组
        String[] res = new String[longest];
        for(int i = 0; i < longest; i++){
            res[i] = array[start + i];
        }
        return res;
    }
}
