package leetcode.everyday.commit2022.november;

import java.util.*;

/**
 * 895. 最大频率栈
 *
 */
public class Solution_20221130_895 {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Map<Integer, Integer> cnts = new HashMap<>();
    int max;

    public Solution_20221130_895() {

    }

    public void push(int val) {
        cnts.put(val, cnts.getOrDefault(val, 0) + 1);
        int c = cnts.get(val);
        List<Integer> list = map.getOrDefault(c, new ArrayList<>());
        list.add(val);
        map.put(c, list);
        max = Math.max(max, c);

    }

    public int pop() {
        List<Integer> list = map.get(max);
        int ans = list.remove(list.size() - 1);
        cnts.put(ans, cnts.get(ans) - 1);
        if (list.size() == 0) max--;
        return ans;
    }
}
