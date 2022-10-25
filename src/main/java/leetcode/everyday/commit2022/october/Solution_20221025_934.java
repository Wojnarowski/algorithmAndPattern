package leetcode.everyday.commit2022.october;

import java.util.*;

/**
 * 934. 最短的桥
 */
public class Solution_20221025_934 {

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int n;
    int[][] grid;

    public int shortestBridge(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
        int total = n * n;
        int startRow = -1, startCol = -1;
        for (int i = 0; i < total; i++) {
            int row = i / n, col = i % n;
            if (grid[row][col] == 1) {
                startRow = row;
                startCol = col;
                break;
            }
        }
        List<int[]> island = getIsland(startRow, startCol);
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque<int[]>();
        for (int[] cell : island) {
            int row = cell[0], col = cell[1];
            visited[row][col] = true;
            queue.offer(cell);
        }
        int distance = -1;
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];
                for (int[] dir : dirs) {
                    int newRow = row + dir[0], newCol = col + dir[1];
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                        if (grid[newRow][newCol] == 0) {
                            visited[newRow][newCol] = true;
                            queue.offer(new int[]{newRow, newCol});
                        } else {
                            return distance;
                        }
                    }
                }
            }
        }
        return -1;
    }
    public List<int[]> getIsland(int startRow, int startCol) {
        List<int[]> island = new ArrayList<int[]>();
        boolean[][] visited = new boolean[n][n];
        visited[startRow][startCol] = true;
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{startRow, startCol});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            island.add(cell);
            int row = cell[0], col = cell[1];
            for (int[] dir : dirs) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        return island;
    }

}
