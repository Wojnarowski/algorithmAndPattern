package leetcode.everyday.commit2021.novemer;

import org.springframework.util.Assert;

/**
 *
 * 367 效的完全平方数
 *
 *  
 *给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 *
 * 输入：num = 14
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= num <= 2^31 - 1
 * 通过次数87,153提交次数196,803
 *
 *
 */
public class Solution_20211104_367 {

    /**
     * 二分找到中点
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        long l=0,r=num;
        while(l<=r){
            long mid = l+((r-l)>>1);
            if(mid * mid<num){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return l*l==num;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{1,2,3,1};
        Assert.isTrue(isPerfectSquare(16)==true,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
