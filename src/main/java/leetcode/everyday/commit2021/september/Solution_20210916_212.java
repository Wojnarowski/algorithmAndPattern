package leetcode.everyday.commit2021.september;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *q 212   单词搜索 II
 *
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 *  
 *
 * 示例 1：
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 *
 *
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 * 通过次数50,935提交次数111,616
 *
 *
 */
public class Solution_20210916_212 {

    private static final int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};


    public List<String> findWords(char[][] board, String[] words) {
        // 记录表格中每一个字符出现的位置
        Map<Character, List<int[]>> mapper = new HashMap<>();
        int n = board.length, m = board[0].length;
        // 对位置进行记录
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; ++c) {
                char v = board[r][c];
                if (mapper.containsKey(v)) {
                    List<int[]> list = mapper.get(v);
                    list.add(new int[]{r, c});
                    mapper.put(v, list);
                } else {
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{r, c});
                    mapper.put(v, list);
                }
            }
        }
        // 返回值
        List<String> ans = new ArrayList<>();
        // 对每一个单词进行深度优先搜索
        for (String word : words) {
            // 如果哈希表中没有记录当前单词第一个字母出现的位置，说明整个表中都没有这个字符，此时直接跳过就好了，没必要搜索了
            if (!mapper.containsKey(word.charAt(0))) continue;
            // 对所有出现的位置进行一次深度优先搜索
            for (int[] start : mapper.get(word.charAt(0))) {
                boolean[][] visited = new boolean[n][m];
                // 先把起始点标记成已访问
                visited[start[0]][start[1]] = true;
                if (dfs(board, visited, word, 1, start[0], start[1])) {
                    ans.add(word);
                    // 只要找到了，就进行下一个单词的查找
                    break;
                }
            }
        }
        return ans;
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, int pos, int x, int y) {
        // 如果位置来到了单词的末尾，说明已经查找完毕，直接返回 true
        if (pos >= word.length()) return true;
        // 否则就对四个方向进行深度优先搜索
        for (int i = 0; i < 4; ++i) {
            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];
            // 确保新的坐标合法，而且没有访问过
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && !visited[nx][ny] && board[nx][ny] == word.charAt(pos)) {
                // 先标记成访问过
                visited[nx][ny] = true;
                // 递归
                if (dfs(board, visited, word, pos + 1, nx, ny)) return true;
                // 回溯，再标记成没访问过
                visited[nx][ny] = false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{1,2,3,1};
        //Assert.isTrue(findPeakElement(array)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
