package leetcode.everyday.commit2021.december;

import java.util.*;

/**
 *q 1610  可见点的最大数目
 *
 * 给你一个点数组 points 和一个表示角度的整数 angle ，你的位置是 location ，其中 location = [posx, posy] 且 points[i] = [xi, yi] 都表示 X-Y 平面上的整数坐标。
 *
 * 最开始，你面向东方进行观测。你 不能 进行移动改变位置，但可以通过 自转 调整观测角度。换句话说，posx 和 posy 不能改变。你的视野范围的角度用 angle 表示， 这决定了你观测任意方向时可以多宽。设 d 为你逆时针自转旋转的度数，那么你的视野就是角度范围 [d - angle/2, d + angle/2] 所指示的那片区域。
 *
 * 对于每个点，如果由该点、你的位置以及从你的位置直接向东的方向形成的角度 位于你的视野中 ，那么你就可以看到它。
 *
 * 同一个坐标上可以有多个点。你所在的位置也可能存在一些点，但不管你的怎么旋转，总是可以看到这些点。同时，点不会阻碍你看到其他点。
 *
 * 返回你能看到的点的最大数目。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：points = [[2,1],[2,2],[3,3]], angle = 90, location = [1,1]
 * 输出：3
 * 解释：阴影区域代表你的视野。在你的视野中，所有的点都清晰可见，尽管 [2,2] 和 [3,3]在同一条直线上，你仍然可以看到 [3,3] 。
 * 示例 2：
 *
 * 输入：points = [[2,1],[2,2],[3,4],[1,1]], angle = 90, location = [1,1]
 * 输出：4
 * 解释：在你的视野中，所有的点都清晰可见，包括你所在位置的那个点。
 * 示例 3：
 *
 *
 *
 * 输入：points = [[1,0],[2,1]], angle = 13, location = [1,1]
 * 输出：1
 * 解释：如图所示，你只能看到两点之一。
 *  
 *
 * 提示：
 *
 * 1 <= points.length <= 105
 * points[i].length == 2
 * location.length == 2
 * 0 <= angle < 360
 * 0 <= posx, posy, xi, yi <= 100
 * 通过次数5,482提交次数13,927
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-visible-points
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Solution_20211216_1610 {


    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        // 算出每一个坐标相对于location位置与x轴的夹角（弧度制），扔到List中排序
        // 然后对于每一个点，使用二分或滑动窗口找出小于这个点+angle（转成弧度制）的最大坐标点
        // 两者之间的下标差就是从这个点出发，辐射angle角度的点数量
        // 注意，与location点相同的点的特殊处理

        int same = 0;
        List<Double> list = new ArrayList<>();
        int x = location.get(0), y = location.get(1);
        for (List<Integer> point : points) {
            int a = point.get(0), b = point.get(1);
            if (a == x && b == y) {
                // 与location同点
                same++;
            } else {
                // 计算角度（弧度制）
                list.add(Math.atan2(b - y, a - x));
            }
        }

        // 排序
        Collections.sort(list);

        // 把前面所有的数添加一遍到后面，类似于于循环数组的使用
        int size = list.size();
        for (int i = 0; i < size; i++) {
            // 加 360度，然后范围相当于变成了 [-pi, 3*pi]
            list.add(list.get(i) + 2 * Math.PI);
        }

        double angleDegree = angle * Math.PI / 180;
        int max = 0;
        int i = 0, j = 0;
        while (i < size) {
            // 滑动窗口，简单点，list是有序的，使用二分查找也是可以的
            while (j < 2 * size && list.get(j) - list.get(i) <= angleDegree) {
                j++;
            }
            max = Math.max(max, j - i);
            i++;
        }

        return max + same;


    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{1,2,3,1};
        //Assert.isTrue(maxPower("leet")==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }


}
