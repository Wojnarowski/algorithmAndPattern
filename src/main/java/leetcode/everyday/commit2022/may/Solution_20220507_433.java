package leetcode.everyday.commit2022.may;

import java.util.*;

/**
 *11
 *
 */


public class Solution_20220507_433 {
    static char[] items = new char[]{'A', 'C', 'G', 'T'};
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        for (String s : bank) set.add(s);
        Deque<String> d = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        d.addLast(start);
        map.put(start, 0);
        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                String s = d.pollFirst();
                char[] cs = s.toCharArray();
                int step = map.get(s);
                for (int i = 0; i < 8; i++) {
                    for (char c : items) {
                        if (cs[i] == c) continue;
                        char[] clone = cs.clone();
                        clone[i] = c;
                        String sub = String.valueOf(clone);
                        if (!set.contains(sub)) continue;
                        if (map.containsKey(sub)) continue;
                        if (sub.equals(end)) return step + 1;
                        map.put(sub, step + 1);
                        d.addLast(sub);
                    }
                }
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
