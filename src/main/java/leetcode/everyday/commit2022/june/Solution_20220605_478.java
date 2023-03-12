//package leetcode.everyday.commit2022.june;
//
//import java.util.*;
//
///**
// * 478    在圆内随机生成点
// *
// *
// * 给定圆的半径和圆心的位置，实现函数 randPoint ，在圆中产生均匀随机点。
// *
// * 实现 Solution 类:
// *
// * Solution(double radius, double x_center, double y_center) 用圆的半径 radius 和圆心的位置 (x_center, y_center) 初始化对象
// * randPoint() 返回圆内的一个随机点。圆周上的一点被认为在圆内。答案作为数组返回 [x, y] 。
// *  
// *
// * 示例 1：
// *
// * 输入:
// * ["Solution","randPoint","randPoint","randPoint"]
// * [[1.0, 0.0, 0.0], [], [], []]
// * 输出: [null, [-0.02493, -0.38077], [0.82314, 0.38945], [0.36572, 0.17248]]
// * 解释:
// * Solution solution = new Solution(1.0, 0.0, 0.0);
// * solution.randPoint ();//返回[-0.02493，-0.38077]
// * solution.randPoint ();//返回[0.82314,0.38945]
// * solution.randPoint ();//返回[0.36572,0.17248]
// *  
// *
// * 提示：
// *
// * 0 < radius <= 108
// * -107 <= x_center, y_center <= 107
// * randPoint 最多被调用 3 * 104 次
// * 通过次数18,709提交次数40,336
// *
// *
// */
//
//
//public class Solution_20220605_478 {
//
//    double r, x, y;
//    Random random = new Random();
//    public Solution_20220605_478(double radius, double x_center, double y_center) {
//        r = radius; x = x_center; y =y_center;
//    }
//
//    public double[] randPoint() {
//        double len = Math.sqrt(random.nextDouble(r * r)), ang = random.nextDouble(2 * Math.PI);
//        double nx = x + len * Math.cos(ang), ny = y + len * Math.sin(ang);
//        return new double[]{nx, ny};
//    }
//
//
//    public static void main(String[] args) {
//        int [] a = new int[]{0,1,0};
//
//    }
//}
