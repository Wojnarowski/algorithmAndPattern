package leetcode.everyday.commit2022.january;

/**
 * 913 猫和老鼠
 * 两位玩家分别扮演猫和老鼠，在一张 无向 图上进行游戏，两人轮流行动。
 *
 * 图的形式是：graph[a] 是一个列表，由满足 ab 是图中的一条边的所有节点 b 组成。
 *
 * 老鼠从节点 1 开始，第一个出发；猫从节点 2 开始，第二个出发。在节点 0 处有一个洞。
 *
 * 在每个玩家的行动中，他们 必须 沿着图中与所在当前位置连通的一条边移动。例如，如果老鼠在节点 1 ，那么它必须移动到 graph[1] 中的任一节点。
 *
 * 此外，猫无法移动到洞中（节点 0）。
 *
 * 然后，游戏在出现以下三种情形之一时结束：
 *
 * 如果猫和老鼠出现在同一个节点，猫获胜。
 * 如果老鼠到达洞中，老鼠获胜。
 * 如果某一位置重复出现（即，玩家的位置和移动顺序都与上一次行动相同），游戏平局。
 * 给你一张图 graph ，并假设两位玩家都都以最佳状态参与游戏：
 *
 * 如果老鼠获胜，则返回 1；
 * 如果猫获胜，则返回 2；
 * 如果平局，则返回 0 。
 *  
 * 示例 1：
 *
 *
 * 输入：graph = [[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
 * 输出：0
 * 示例 2：
 *
 *
 * 输入：graph = [[1,3],[0],[3],[0,2]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 3 <= graph.length <= 50
 * 1 <= graph[i].length < graph.length
 * 0 <= graph[i][j] < graph.length
 * graph[i][j] != i
 * graph[i] 互不相同
 * 猫和老鼠在游戏中总是移动
 * 通过次数3,029提交次数6,422
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cat-and-mouse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution_20220104_913 {

    int N = 51;
    int[][][] f = new int[2 * N * N][N][N];
    int[][] g;
    int n;

    public int catMouseGame(int[][] graph) {
        g = graph;
        n = graph.length;
        for (int k = 0; k < n * n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    f[k][i][j] = -1;
                }
            }
        }
        return dfs(0, 1, 2);

    }

    // 0:draw / 1:mouse / 2:cat
    int dfs(int k, int a, int b) {
        int ans = f[k][a][b];
        if (a == 0) {
            ans = 1;
        } else if (a == b) {
            ans = 2;
        } else if (k >= 2 * n * n) {
            ans = 0;
        } else if (ans == -1) {
            if (k % 2 == 0) { // mouse
                boolean win = false, draw = false;
                for (int ne : g[a]) {
                    int t = dfs(k + 1, ne, b);
                    if (t == 1) win = true;
                    else if (t == 0) draw = true;
                    if (win) break;
                }
                if (win) ans = 1;
                else if (draw) ans = 0;
                else ans = 2;
            } else { // cat
                boolean win = false, draw = false;
                for (int ne : g[b]) {
                    if (ne == 0) continue;
                    int t = dfs(k + 1, a, ne);
                    if (t == 2) win = true;
                    else if (t == 0) draw = true;
                    if (win) break;
                }
                if (win) ans = 2;
                else if (draw) ans = 0;
                else ans = 1;
            }
        }
        f[k][a][b] = ans;
        return ans;
    }



    public static void main(String[] args) {


        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");

        System.out.println("-------------运行通过-------------");

    }
}
