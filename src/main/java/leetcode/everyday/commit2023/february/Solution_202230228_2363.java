package leetcode.everyday.commit2023.february;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1255. 得分最高的单词集合
 */
public class Solution_202230228_2363 {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(items1, (a, b) -> a[0] - b[0]);
        Arrays.sort(items2, (a, b) -> a[0] - b[0]);
        int p1 = 0, p2 = 0;
        while (p1 < items1.length && p2 < items2.length) {
            int v1 = items1[p1][0], v2 = items2[p2][0];
            if (v1 == v2) {
                ans.add(Arrays.asList(new Integer[] { v1, items1[p1][1] + items2[p2][1] }));
                p1++;
                p2++;
            } else if (v1 < v2) {
                ans.add(Arrays.asList(new Integer[] { v1, items1[p1][1] }));
                p1++;
            } else {
                ans.add(Arrays.asList(new Integer[] { v2, items2[p2][1] }));
                p2++;
            }
        }
        while (p1 < items1.length) {
            ans.add(Arrays.asList(new Integer[] { items1[p1][0], items1[p1][1] }));
            p1++;
        }
        while (p2 < items2.length) {
            ans.add(Arrays.asList(new Integer[] { items2[p2][0], items2[p2][1] }));
            p2++;
        }
        return ans;

    }
}
