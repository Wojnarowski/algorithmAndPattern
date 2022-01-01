package leetcode.everyday.commit2021.april;

import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Stack;

/**
 *面试题 17.21. 直方图的水量
 *
 *给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 通过次数12,189提交次数19,299
 *
 *
 */
public class Solution_20210402_1721 {


    /**
     * 思路一: 单调栈
     * https://leetcode-cn.com/problems/volume-of-histogram-lcci/solution/dong-hua-ti-jie-fei-chang-rong-yi-li-jie-dan-diao-/
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();

        int water =0;
        //特判
        if(height.length<3){
            return 0;
        }
        for(int i=0;i<height.length;i++){
            //数组中数据大于栈顶元素
            while(!stack.isEmpty() && height[i]>height[stack.peek()]){
                //栈顶元素
                int popnum=stack.pop();
                //相同元素的情况
                while(!stack.isEmpty()&&height[popnum] == height[stack.peek()]){
                    stack.pop();
                }
                //计算该层的水的单位
                if(!stack.isEmpty()){
                    //栈顶元素值
                    int temp = height[stack.peek()];
                    //高
                    int hig = Math.min(temp-height[popnum],height[i]-height[popnum]);
                    //宽
                    int wid = i-stack.peek()-1;
                    water +=hig * wid;
                }
            }
            //这里入栈的是索引
            stack.push(i);
        }

        return water;
    }


    /**
     * 思路2
     * 核心精神：总体积减去柱子体积就是水的容量
     *
     * 利用左右指针的下标差值计算出每一层雨水和柱子的体积。如下图，第一层体积为11，第二层为8，第三层为1。累加得到整体体积volume = 20
     * （注意：每一层从左边第一个方格到右边最后一个方格之间一定是被蓝黑两种颜色的方格填满，不会存在空白，所以我们可以这么求值）
     * 计算柱子的总体积Sum，就是height：[0,1,0,2,1,0,1,3,2,1,2,1]数组之和14
     * 返回结果volume − Sum就是雨水的体积。
     *
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        //获取柱子总体积
        int sum = Arrays.stream(height).sum();
        System.out.println("总体积 sum ="+sum);
        //初始化总体积和高度
        int volume=0;
        int high=1;
        int size =height.length;
        //初始化双指针
        int left=0,right=size-1;
        while(left<=right){
           while (left<=right && height[left]<high){
                left++;
            }

           while (left<=right &&height[right]<high){
                right--;
            }
            volume+=right-left+1; //叠加当前层面积
            high++; //高度加一
        }

        return volume-sum;
    }

    public static void main(String[] args) {


        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})==6,"程序异常");
        Assert.isTrue(trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})==6,"程序异常");

        System.out.println("-------------运行通过-------------");

    }
}
