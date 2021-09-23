package leetcode.everyday.september;

import leetcode.everyday.ListNode;

/**
 *q 326 3的幂
 *
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 *  
 *
 * 示例 1：
 * 输入：n = 27
 * 输出：true
 *
 *
 * 示例 2：
 * 输入：n = 0
 * 输出：false
 *
 *
 * 示例 3：
 * 输入：n = 9
 * 输出：true
 *
 *
 * 示例 4：
 * 输入：n = 45
 * 输出：false
 *
 * 提示：
 * -231 <= n <= 231 - 1
 *
 */
public class Solution_20210923_326 {

    public boolean isPowerOfThree(int n) {
        if(n==1){
            return true;
        }
        while(n>3){
            if(n%3==0){
                n=n/3;
            }else{
                return false;
            }
        }
        return n==3;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{1,2,3,1};
        //Assert.isTrue(findPeakElement(array)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
