package leetcode.everyday.commit2023.april;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 驼峰式匹配
 */
public class Solution_202230414_1023 {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        return Arrays.stream(queries)
                .map(query->helper(query, pattern))
                .collect(Collectors.toList());
    }

    private Boolean helper(String query, String pattern){
        int m = query.length(), n = pattern.length();

        int j = 0;// j 代表 query 被匹配到的位置
        for(int i = 0; i < m; i++){ // 遍历 pattern，i 代表被遍历到的位置
            char c = query.charAt(i);
            if(j < n && c == pattern.charAt(j))j++;
            else if(c >= 'A' && c <= 'Z'){
                return false;
            }
        }
        return j == n;
    }

}
