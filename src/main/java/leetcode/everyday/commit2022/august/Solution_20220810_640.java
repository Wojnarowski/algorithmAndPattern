package leetcode.everyday.commit2022.august;

/**
 * 640  求解方程
 *
 *
 * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
 *
 * 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
 *
 * 如果方程中只有一个解，要保证返回值 'x' 是一个整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: equation = "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * 示例 2:
 *
 * 输入: equation = "x=x"
 * 输出: "Infinite solutions"
 * 示例 3:
 *
 * 输入: equation = "2x=x"
 * 输出: "x=0"
 *
 *
 *
 */
public class Solution_20220810_640 {

    public String solveEquation(String equation) {
        equation += "="; // 为了实现对末尾的统一处理
        char[] equ = equation.toCharArray();
        int index = 0; // 等号的位置
        while(equ[index] != '=')
            index++;

        // 分别对等号两边进行解析
        int[] left = parse(equ, 0, index); // 解析等号左边
        int[] right = parse(equ, index + 1, equ.length - 1); // 解析等号右边

        // 判断解的情况，
        int k = right[0] - left[0], b = left[1] - right[1];
        if(k == 0 && b != 0)
            return "No solution";
        if(k == 0 && b == 0)
            return "Infinite solutions";
        return "x=" + b / k ;
    }

    // 这里的解析，是先记录数字，当遇到非数字时，根据情况将该数字累加到系数k或常数项b上
    // 注意start,end构成的是一个闭区间
    // 该区间以等号结尾，这是为了实现对末尾的统一处理，因为只有遇到非数字时，才进行一次处理
    int[] parse(char[] equ, int start, int end){
        // k为x的系数之和，b为常数项之和
        int k = 0, b = 0;
        // num记录当前数字，这个数字不带符号，他可能是一个系数，也可能是一个常数项
        // sign为num的符号，需要随着加减号进行变化
        int num = 0, sign = 1;
        // 细节：由于x的系数为1时会忽略不写，也就是x前面没有数字，故需要设置flag，当其为true时，表明当前x的系数为1，而不是0
        // 测试用例中有一个“0x=x“，也就是x的系数可能为0
        boolean flag = true;
        for(int i = start; i <= end; ++i){
            char now = equ[i];
            if(Character.isDigit(now)){
                num *= 10;
                num += now - '0'; // 维护数字num
                flag = false; // 此时x的系数已经不可能为1
            }
            else{
                if(now == 'x'){
                    if(num == 0 && flag == true)
                        num = 1; // 此时虽然num等于0，但flag为true，当前x的系数应该为1
                    k += sign * num; // 累加到系数
                }
                else{
                    b += sign * num; // 累加到常数项
                    sign = now=='+'? 1: -1; // 更新符号
                }
                num = 0; // 重置num为0
                flag = true; // 重置flag为true
            }
        }
        return new int[]{k, b};
    }

}
