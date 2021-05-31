package leetcode.everyday.may;

/**
 *q 342  4的幂
 *
 *给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 16
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：true
 *  
 *
 * 提示：
 *
 * -231 <= n <= 231 - 1
 *  
 *
 *
 */
public class Solution_20210531_342 {

    /**
     * 类似于暴力解
     * @param n
     * @return
     */
    public boolean isPowerOfFour(int n) {
        if(n>0){
            while(n%4==0){
                n=n/4;
            }
            return n==1;
        }
        else{
            return false;
        }

    }

    /**
     * 转换成2的幂求解 就和231题一样了
     * @param n
     * @return
     */
    public boolean isPowerOfFour2(int n) {
        if(n<0){
            return false;
        }
        int x = (int) Math.sqrt(n);
        return ((x*x ==n)  && ((x &(x-1))==0));


    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行------ -------");
        //Assert.isTrue(strangePrinter("aba")==2,"程序异常");
        //topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2);
        System.out.println("-------------运行通过-------------");

    }
}
