package leetcode.everyday.commit2023.february;

import java.util.*;

/**
 * 2351. 第一个出现两次的字母
 */
public class Solution_202230202_1129 {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        final int RED = 0, BLUE = 1;
        List<Integer>[][] adjacentArr = new List[n][2];
        for (int i = 0; i < n; i++) {
            adjacentArr[i][RED] = new ArrayList<Integer>();
            adjacentArr[i][BLUE] = new ArrayList<Integer>();
        }
        for (int[] redEdge : redEdges) {
            adjacentArr[redEdge[0]][RED].add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            adjacentArr[blueEdge[0]][BLUE].add(blueEdge[1]);
        }
        int[][] distances = new int[n][2];
        for (int i = 1; i < n; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{0, RED});
        queue.offer(new int[]{0, BLUE});
        while (!queue.isEmpty()) {
            int[] nodeColor = queue.poll();
            int node = nodeColor[0], color = nodeColor[1];
            int distance = distances[node][color];
            int nextColor = color ^ 1;
            int nextDistance = distance + 1;
            List<Integer> adjacent = adjacentArr[node][nextColor];
            for (int next : adjacent) {
                if (nextDistance < distances[next][nextColor]) {
                    distances[next][nextColor] = nextDistance;
                    queue.offer(new int[]{next, nextColor});
                }
            }
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int distance = Math.min(distances[i][RED], distances[i][BLUE]);
            answer[i] = distance != Integer.MAX_VALUE ? distance : -1;
        }
        return answer;
    }
}
