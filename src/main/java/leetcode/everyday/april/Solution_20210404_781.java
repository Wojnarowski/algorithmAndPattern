package leetcode.everyday.april;

import org.springframework.util.Assert;

/**
 *q 781   森林中的兔子
 *
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。
 * 我们将这些回答放在 answers 数组里。
 *
 * 返回森林中兔子的最少数量。
 *
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 *
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 *
 * 输入: answers = []
 * 输出: 0
 * 说明:
 *
 * answers 的长度最大为1000。
 * answers[i] 是在 [0, 999] 范围内的整数。
 *
 *
 */
public class Solution_20210404_781 {


    public static int numRabbits(int[] answers) {
        //m[i]>0   先前已经记录到有回答i的兔子,这次遇到只需容量减1
        //m[i]==0  第一次遇到回答i的兔子或者上一次遇到回答i的兔子时创建颜色的容量已经用完.
        //创建新的颜色,容量为i,并将这一波兔子数量加到结果中
        int[] m = new int[1000];
        int result = 0;
        for (int i : answers) {
            if (m[i] > 0) {
                m[i]--;
            } else {
                m[i] = i;
                result += i + 1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(numRabbits(new int[]{1, 1, 2})==5,"程序异常");
        Assert.isTrue(numRabbits(new int[]{10, 10, 10})==11,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
