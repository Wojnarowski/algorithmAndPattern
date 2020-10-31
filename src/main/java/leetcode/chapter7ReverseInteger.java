package leetcode;

/**
 * 整数反转
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2  31,  2  31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class chapter7ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));

    }

    static int reverse(int x){
        if(x<Integer.MIN_VALUE || x>Integer.MAX_VALUE){
            return 0;
        }
        int result = 0;
//        while (Math.abs(x)>10){
//            result=result+x%10*10;
//            x=x%10;
//        }
        while(x!=0){
            //每次取末尾数字
            int pop =x%10;

            //判断是否 大于 最大32位整数
            if (result>214748364 || (result==214748364 && pop>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (result<-214748364 || (result==-214748364 && pop<-8)) {
                return 0;
            }



            result=result*10+pop;
            x=x/10;
        }

        return result;

    }
}
