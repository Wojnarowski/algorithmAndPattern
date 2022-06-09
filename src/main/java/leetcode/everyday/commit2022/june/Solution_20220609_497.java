package leetcode.everyday.commit2022.june;

import java.util.Random;

/**
 * 497    非重叠矩形中的随机点
 *
 *
 * 给定一个由非重叠的轴对齐矩形的数组 rects ，其中 rects[i] = [ai, bi, xi, yi] 表示 (ai, bi) 是第 i 个矩形的左下角点，(xi, yi) 是第 i 个矩形的右上角角点。设计一个算法来随机挑选一个被某一矩形覆盖的整数点。矩形周长上的点也算做是被矩形覆盖。所有满足要求的点必须等概率被返回。
 *
 * 在一个给定的矩形覆盖的空间内任何整数点都有可能被返回。
 *
 * 请注意 ，整数点是具有整数坐标的点。
 *
 * 实现 Solution 类:
 *
 * Solution(int[][] rects) 用给定的矩形数组 rects 初始化对象。
 * int[] pick() 返回一个随机的整数点 [u, v] 在给定的矩形所覆盖的空间内。
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入:
 * ["Solution","pick","pick","pick","pick","pick"]
 * [[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
 * 输出:
 * [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]
 *
 * 解释：
 * Solution solution = new Solution([[-2, -2, 1, 1], [2, 2, 4, 6]]);
 * solution.pick(); // 返回 [1, -2]
 * solution.pick(); // 返回 [1, -1]
 * solution.pick(); // 返回 [-1, -2]
 * solution.pick(); // 返回 [-2, -2]
 * solution.pick(); // 返回 [0, 0]
 *  
 *
 * 提示：
 *
 * 1 <= rects.length <= 100
 * rects[i].length == 4
 * -109 <= ai < xi <= 109
 * -109 <= bi < yi <= 109
 * xi - ai <= 2000
 * yi - bi <= 2000
 * 所有的矩形不重叠。
 * pick 最多被调用 104 次。
 * 通过次数5,555提交次数13,394
 * 请问您在哪类招聘中遇到此题？
 *
 *
 *
 */


public class Solution_20220609_497 {

    int[][] rects;
    public Solution_20220609_497(int[][] rects) {
        this.rects = rects;
    }

    public int[] pick() {
        int index = -1, n = 0; //分别记录抽到的矩形下标、当前点的总数
        Random random = new Random();
        for (int i = 0; i < rects.length; i++) {
            int k = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1); //当前矩形包含的点数量
            n += k;
            if (random.nextInt(n) < k) index = i; //当前矩形有k/n的概率被保留
        }
        int[] rec = rects[index]; //抽到矩形后，再从这个矩形中随机抽取x、y的值
        int x1 = rec[0], x2 = rec[2], y1 = rec[1], y2 = rec[3];
        return new int[]{x1 + random.nextInt(x2 - x1 + 1), y1 + random.nextInt(y2 - y1 + 1)};

    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
