package leetcode.everyday.commit2022.may;

/**
 *1728 猫和老鼠 II
 *
 * 一只猫和一只老鼠在玩一个叫做猫和老鼠的游戏。
 *
 * 它们所处的环境设定是一个 rows x cols 的方格 grid ，其中每个格子可能是一堵墙、一块地板、一位玩家（猫或者老鼠）或者食物。
 *
 * 玩家由字符 'C' （代表猫）和 'M' （代表老鼠）表示。
 * 地板由字符 '.' 表示，玩家可以通过这个格子。
 * 墙用字符 '#' 表示，玩家不能通过这个格子。
 * 食物用字符 'F' 表示，玩家可以通过这个格子。
 * 字符 'C' ， 'M' 和 'F' 在 grid 中都只会出现一次。
 * 猫和老鼠按照如下规则移动：
 *
 * 老鼠 先移动 ，然后两名玩家轮流移动。
 * 每一次操作时，猫和老鼠可以跳到上下左右四个方向之一的格子，他们不能跳过墙也不能跳出 grid 。
 * catJump 和 mouseJump 是猫和老鼠分别跳一次能到达的最远距离，它们也可以跳小于最大距离的长度。
 * 它们可以停留在原地。
 * 老鼠可以跳跃过猫的位置。
 * 游戏有 4 种方式会结束：
 *
 * 如果猫跟老鼠处在相同的位置，那么猫获胜。
 * 如果猫先到达食物，那么猫获胜。
 * 如果老鼠先到达食物，那么老鼠获胜。
 * 如果老鼠不能在 1000 次操作以内到达食物，那么猫获胜。
 * 给你 rows x cols 的矩阵 grid 和两个整数 catJump 和 mouseJump ，双方都采取最优策略，如果老鼠获胜，那么请你返回 true ，否则返回 false 。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/cat-and-mouse-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Solution_20220510_1728 {
    static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        int M = grid.length, N = grid[0].length();
        int mouse = 0, cat = 0, food = 0;
        for (int x = 0; x < M; ++x) {
            for (int y = 0; y < N; ++y) {
                char ch = grid[x].charAt(y);
                if (ch == 'M') mouse = x * N + y;
                else if (ch == 'C') cat = x * N + y;
                else if (ch == 'F') food = x * N + y;
            }
        }
        // mdp[i][j] 表示 老鼠和猫分别在 i,j 点时，老鼠的胜负状态
        // cdp[i][j] 表示 老鼠和猫分别在 i,j 点时，猫的胜负状态
        // 状态分三种 1必胜 -1必败 0未知
        int[][] mdp = new int[M * N][M * N], cdp = new int[M * N][M * N];
        // 初始化结束边界状态
        for (int i = 0; i < M * N; ++i) {
            if (i == food) continue;
            // 两者到达同一点，老鼠必败，猫必胜
            mdp[i][i] = -1;
            cdp[i][i] = 1;
            // 老鼠到达食物，老鼠必胜，猫必败
            mdp[food][i] = 1;
            cdp[food][i] = -1;
            // 猫到达食物，老鼠必败，猫必胜
            mdp[i][food] = -1;
            cdp[i][food] = 1;
        }
        // 时光倒流大法，从结束状态，往前转移，最终目标是求初始状态mdp[mouse][cat]是否必胜
        for (int round = 0; round < 1000; ++round) {
            boolean changed = false;// 标记这一轮是否有状态发生了改变
            for (int i = 0; i < M * N; ++i) {
                int mx = i / N, my = i % N;
                if (grid[mx].charAt(my) == '#') continue;
                for (int j = 0; j < M * N; ++j) {
                    int cx = j / N, cy = j % N;
                    if (grid[cx].charAt(cy) == '#') continue;
                    if (mdp[i][j] == 0) {// 老鼠的回合
                        boolean win = false, lose = true;
                        // 四个方向搜索相邻猫的状态，因为老鼠跳完了，就轮到猫了
                        // 根据相邻的猫的状态，转移到当前老鼠的状态
                        for (int[] d : DIRECTIONS) {
                            for (int jump = 0; jump <= mouseJump; ++jump) {
                                int mx2 = mx + d[0] * jump, my2 = my + d[1] * jump;
                                if (mx2 < 0 || mx2 >= M || my2 < 0 || my2 >= N) break;
                                if (grid[mx2].charAt(my2) == '#') break;
                                int k = mx2 * N + my2;
                                lose &= cdp[k][j] == 1;// 对方全部必胜，我们则必败
                                if (cdp[k][j] == -1) {// 对方只要有一个必败，我们则必胜
                                    win = true;
                                    break;
                                }
                            }
                            if (win) break;
                        }
                        mdp[i][j] = win ? 1 : lose ? -1 : 0;
                        if (win || lose) changed = true;
                    }
                    if (cdp[i][j] == 0) {// 猫的回合，与上面同理
                        boolean win = false, lose = true;
                        for (int[] d : DIRECTIONS) {
                            for (int jump = 0; jump <= catJump; ++jump) {
                                int cx2 = cx + d[0] * jump, cy2 = cy + d[1] * jump;
                                if (cx2 < 0 || cx2 >= M || cy2 < 0 || cy2 >= N) break;
                                if (grid[cx2].charAt(cy2) == '#') break;
                                int k = cx2 * N + cy2;
                                lose &= mdp[i][k] == 1;
                                if (mdp[i][k] == -1) {
                                    win = true;
                                    break;
                                }
                            }
                            if (win) break;
                        }
                        cdp[i][j] = win ? 1 : lose ? -1 : 0;
                        if (win || lose) changed = true;
                    }
                }
            }
            if (mdp[mouse][cat] == 1) return true;
            if (mdp[mouse][cat] == -1) return false;
            // 优化时间的关键点，200+ms --> 30+ms
            // 如果这一轮没有任何状态发生改变，那么没必要继续下一轮了，下一轮肯定还是不会变
            if (!changed) return false;
        }
        return false;// 跑满1000轮，实际上跑不满

    }


    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
