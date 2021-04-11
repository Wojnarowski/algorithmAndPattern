package leetcode.github.monotonousStack;

import org.springframework.util.Assert;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 柱状图中最大的矩形
 *给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *  
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *  
 *
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *  
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 *
 */
public class Solution402 {

    public static int largestRectangleArea(int[] heights) {
        //特判
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        //单调栈 数组下标
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int res=0;
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
                int curHeight  = heights[stack.pollLast()];
                while(!stack.isEmpty() && heights[stack.peekLast()]==curHeight){
                    stack.pollLast();
                }
                int cutWidth=0;
                if(stack.isEmpty()){
                    cutWidth=i;
                }
                else{
                    cutWidth=i-stack.peekLast()-1;
                }
                res=Math.max(res,curHeight*cutWidth);
            }
            stack.addLast(i);
        }
        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;


    }

    public static int largestRectangleArea2(int[] heights) {
        // 这里为了代码简便，在柱体数组的头和尾加了两个高度为 0 的柱体。
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);

        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i < tmp.length; i++) {
            // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                area = Math.max(area, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }

        return area;
    }


    public static void main(String[] args) {
        //Assert.isTrue(largestRectangleArea(new int[]{2,1,5,6,2,3})==10,"程序异常");
        Assert.isTrue(largestRectangleArea2(new int[]{2,1,5,6,2,3})==10,"程序异常");

    }
}
