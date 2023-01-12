package leetcode.everyday.commit2023.january;

import java.util.*;

/**
 * 1806. 还原排列的最少操作步数
 */
public class Solution_202230112_1807 {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> mp = new HashMap<>();
        for (List<String> t : k) mp.put(t.get(0), t.get(1));
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                StringBuilder tem = new StringBuilder();
                while (arr[++i] != ')') tem.append(arr[i]); //截取()之间的字符
                sb.append(mp.getOrDefault(tem.toString(), "?")); //若不存在添加?
            } else sb.append(arr[i]);
        }
        return sb.toString();

    }
}
