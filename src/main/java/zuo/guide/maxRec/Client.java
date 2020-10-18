package zuo.guide.maxRec;

import java.util.Stack;

/**
 * 求最大子矩阵
 * 给定一个整型矩阵 map，其中的值只有0和1两种，求其中全是1的所有矩形区域中
 * ，最大的矩形区域为1的数量。
 *  例如∶11 1 0 其中，最大的矩形区域有3个1，所以返回3。
 * 再如∶ 
 *      1 0 1 1
 *      1 1 1 1
 *      1 1 1 0
 *  其中，最大的矩形区域有6个1，所以返回6。
 *
 * 思路 ： 按照每行切割 ，最终切割成的数组为
 *  height={3,2,3,0}
 *  最大 子矩阵为   (p2-p1-1)*height[i]   p2为向右小于当前值的位置，p1为向左，
 */
public class Client {
    public static void main(String[] args) {

    }

    public int maxRecFromBottom(int [] height){
        if(height == null|| height.length==0){
            return 0;
        }
        int maxArea=0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty()&&height[i]<=height[stack.peek()]){
                int j=stack.pop();
                int k = stack.isEmpty()?-1:stack.peek();
                int curArea= (i-k-1)*height[j];
                maxArea=Math.max(maxArea,curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int j=stack.pop();
            int k = stack.isEmpty()?-1:stack.peek();
            int curArea = (height.length-k-1)*height[j];
            maxArea=Math.max(maxArea,curArea);
        }
        return maxArea;
    }

}
