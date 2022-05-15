package leetcode.everyday.commit2022.may;

import java.util.Arrays;

/**
 * 812   最大三角形面积
 *
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 *
 * 示例:
 * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出: 2
 * 解释:
 * 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
 *
 *
 * 注意:
 *
 * 3 <= points.length <= 50.
 * 不存在重复的点。
 *  -50 <= points[i][j] <= 50.
 * 结果误差值在 10^-6 以内都认为是正确答案。
 *
 *
 *
 */


public class Solution_20220515_812 {

    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int cur = cross(points[j][0] - points[i][0], points[j][1] - points[i][1], points[k][0] - points[i][0], points[k][1] - points[i][1]);
                    ans = Math.max(ans, Math.abs(cur / 2.0));
                }
            }
        }
        return ans;

    }
    int cross(int a, int b, int c, int d) {
        return a * d - c * b;
    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
