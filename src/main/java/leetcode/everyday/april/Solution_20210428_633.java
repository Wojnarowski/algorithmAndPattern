package leetcode.everyday.april;

import org.springframework.util.Assert;

/**
 *q 633 平方数之和
 *
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 *
 * 示例 2：
 * 输入：c = 3
 * 输出：false
 *
 *
 *
 * 示例 3：
 * 输入：c = 4
 * 输出：true
 *
 *
 * 示例 4：
 * 输入：c = 2
 * 输出：true
 *
 *
 * 示例 5：
 * 输入：c = 1
 * 输出：true
 *  
 *
 * 提示：
 *
 * 0 <= c <= 231 - 1
 *
 *
 */
public class Solution_20210428_633 {

       public static  boolean judgeSquareSum(int c) {
        int max =(int) Math.sqrt(c);
        for(int a=0;a<=max;a++){
            int b = (int) Math.sqrt(c-a*a);
            if(a*a+b*b==c){
                return true;
            }
        }
        return false;
    }

    /**
     * 双指针
     * @param c
     * @return
     */
    public static  boolean judgeSquareSum2(int c) {
       int a=0,b=(int)Math.sqrt(c);
       while(a<b){
           int cur = a*a+b*b;
           if(cur==c){
               return true;
           }
           else if(cur<c){
                a++;
           }
           else{
               b--;
           }
       }
       return false;
    }

    /**
     * 费马平方和
     * 费马平方和 : 奇质数能表示为两个平方数之和的充分必要条件是该质数被 4 除余 1 。
     *
     * 翻译过来就是：当且仅当一个自然数的质因数分解中，满足 4k+3 形式的质数次方数均为偶数时，该自然数才能被表示为两个平方数之和。
     *
     * 因此我们对 c 进行质因数分解，再判断满足 4k+3 形式的质因子的次方数是否均为偶数即可。
     *
     * @param c
     * @return
     */
    public static  boolean judgeSquareSum3(int c) {
        for (int i = 2, cnt = 0; i * i <= c; i++, cnt = 0) {
            while (c % i == 0 && ++cnt > 0) c /= i;
            if (i % 4 == 3 && cnt % 2 != 0) return false;
        }
        return c % 4 != 3;
    }



    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(judgeSquareSum(5)==true,"程序异常");
        Assert.isTrue(judgeSquareSum(3)==false,"程序异常");

        System.out.println("-------------运行通过-------------");
    }
}
