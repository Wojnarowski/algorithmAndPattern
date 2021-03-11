package leetcode.everyday;

import org.springframework.util.Assert;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 *  
 *
 * 示例 1：
 * 输入：s = "3+2*2"
 * 输出：7
 *
 *
 * 示例 2：
 * 输入：s = " 3/2 "
 * 输出：1
 *
 *
 * 示例 3：
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 *
 *
 *
 */
public class Solution_20210311_227 {


    /**
     * 思路有 +， - ，*，/ 四种运算符；
     * 没有括号。
     * 既然包含 4 种运算符，那么就有运算符优先级的问题：先 *，/ ，再 +， - 。本题解的思路就是把所有的 *，/ 先计算出来，最后计算只有 +， - 运算符的表达式。
     *
     * 使用一个「栈」只保存需要进行 +， - 运算符的所有数字（把- 运算符改成负数放到栈中）。
     *
     * 如果遇到 *，/ 运算，则需要把结果先计算出来，也放到栈里；
     *
     * 在把所有乘除法计算完成之后，最后对栈内数字求和。
     *
     * 但是注意栈顶元素由于后面可能遇到 *，/ 运算符，所以栈顶元素有可能还会被弹出来，跟后面的运算符做计算。
     *
     * 思路是不是很简单？
     *
     * 具体实现的时候，按照下面的思路来考虑。
     *
     * 一个运算符表达式分为三个部分，可以用下面的情况表示：
     *
     * 数字①， 运算符②， 数字③
     * 数字①，运算符②，数字③
     *
     * 数字①，在栈中保存，为栈顶的元素；
     * 运算符②，用一个变量 pre_op 保存；
     * 数字③，用一个变量 num 保存。
     * 操作情况：
     * 运算符②，决定了现在的操作：
     *
     * 如果 运算符② 为 +， - ：如果是+，是把数字③入栈；如果 -，是把 数字③取反 入栈。
     * 如果 运算符② 为 *，/ ，则需要计算 数字① 运算符② 数字③，然后把结果 入栈。
     * 这样遍历一次后，优先把所有的 *，/ 都计算出来，而且与需要做加减运算的数字一起，全都都放到了栈中，对栈求和，即为最终的结果。
     *
     * @param s
     * @return
     */
    public static int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num=0;
        char preSign='+';
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(Character.isDigit(chars[i])){
                num=num*10+chars[i]-'0';
            }
            if(!Character.isDigit(chars[i]) && chars[i]!=' '  || i==chars.length-1){
                if(preSign=='+'){
                    stack.push(num);
                }
                else if(preSign=='-'){
                    stack.push(-num);
                }
                else if(preSign=='*'){
                    stack.push(stack.pop()*num);
                }
                else if(preSign=='/'){
                    stack.push(stack.pop()/num);
                }
                preSign = chars[i];
                num = 0;
            }

        }
        int res=0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return  res;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(calculate("3+2*2")==7,"程序异常");
        Assert.isTrue(calculate("3/2")==1,"程序异常");
        Assert.isTrue(calculate("3+5 / 2")==5,"程序异常");
        System.out.println("-------------运行通过-------------");


    }
}
