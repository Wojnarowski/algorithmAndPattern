package leetcode.everyday.commit2023.january;

import java.util.*;

/**
 * 1806. 还原排列的最少操作步数
 */
public class Solution_202230112_1807 {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < knowledge.size(); i++) {
            List<String> know = knowledge.get(i);
            map.put(know.get(0), know.get(1));
        }
        char[] cs = s.toCharArray();
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c == '(') {
                StringBuffer key = new StringBuffer();
                while (cs[++i] != ')') {
                    key.append(cs[i]);
                }
                String value = map.getOrDefault(key.toString(), "?");
                ans.append(value);
            } else {
                ans.append(c);
            }
        }
        return ans.toString();

    }
}
