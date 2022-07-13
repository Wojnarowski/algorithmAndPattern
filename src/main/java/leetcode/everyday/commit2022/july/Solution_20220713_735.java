package leetcode.everyday.commit2022.july;

import java.util.Stack;

/**
 * 735  行星碰撞
 *
 *给定一个整数数组 asteroids，表示在同一行的行星。
 *
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * 示例 2：
 *
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * 示例 3：
 *
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 *  
 *
 * 提示：
 *
 * 2 <= asteroids.length <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 * 通过次数34,102提交次数81,183
 *
 *
 *
 */


public class Solution_20220713_735 {


    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int a = asteroids[i];
            while (a < 0 && !stack.isEmpty() && stack.peek() > 0 && Math.abs(stack.peek()) < Math.abs(a)) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() * a > 0 || (stack.peek() < 0 && a > 0)) {
                stack.add(a);
            } else if (stack.peek() > 0 && Math.abs(stack.peek()) == Math.abs(a)) {
                stack.pop();
            }
        }
        int[] ans = new int[stack.size()];
        int p = ans.length - 1;
        while (!stack.isEmpty()) {
            ans[p--] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
