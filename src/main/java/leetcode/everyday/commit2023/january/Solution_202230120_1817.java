package leetcode.everyday.commit2023.january;

import java.util.*;

/**
 * 1817. 查找用户活跃分钟数
 */
public class Solution_202230120_1817 {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int[] log : logs){
            HashSet<Integer> set = map.getOrDefault(log[0], new HashSet<>());
            set.add(log[1]);
            map.put(log[0], set);
        }
        int[] answer = new int[k];
        for(HashSet<Integer> set: map.values()){
            answer[set.size() - 1]++;
        }
        return answer;
    }
}
