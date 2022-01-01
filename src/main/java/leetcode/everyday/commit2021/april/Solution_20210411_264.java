package leetcode.everyday.commit2021.april;

import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 *q 154 丑数
 *
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 *
 * 示例 1：
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 *
 *
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 *
 * 提示：
 * 1 <= n <= 1690
 * 通过次数69,007提交次数122,338
 *
 *
 */
public class Solution_20210411_264 {


    /**
     * 思路一 基于前一题 超时了
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        if(!(n>=1 && n<=1690)){
            return 0;
        }
        int index =0;
        int result =0;
        for(int i=1;;i++){
            if(isUgly(i)){
               index++;
                result=i;
               if(index==n){
                   break;
               }
            }
        }
        return result;
    }

    public static boolean isUgly(int n) {
        if(n<=0){
            return false;
        }
        while (n%2==0) n=n/2;
        while (n%3==0) n=n/3;
        while (n%5==0) n=n/5;
        return n==1;
    }

    /**
     * 利用小根堆
     * @param n
     * @return
     */
    public static int nthUglyNumber2(int n) {
        int[] nums = new int[]{2,3,5};
        //记录已经存放过的
        Set<Long> set = new HashSet<Long>();
        Queue<Long> pq = new PriorityQueue<>();
        set.add(1L);
        pq.add(1L);
        for(int i=1;i<=n;i++){
            long x = pq.poll();
            if(i==n){
                return (int)x;
            }
            for(int num:nums){
                long t=num*x;
                if(!set.contains(t)){
                    set.add(t);
                    pq.add(t);
                }
            }

        }
        return -1;
    }


    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int nthUglyNumber3(int n) {
        // ans 用作存储已有丑数（从下标 1 开始存储，第一个丑数为 1）
        int [] ans = new int [n+1];
        ans[1]=1;
        //定义三个指针i2，i3，i5
        for(int i2=1,i3=1,i5=1,idx=2;idx<=n;idx++){
            int a = ans[i2]*2,b=ans[i3]*3,c=ans[i5]*5;
            int min = Math.min(a,Math.min(b,c));
            if(min==a){
                i2++;
            }
            if(min==b){
                i3++;
            }
            if(min==c){
                i5++;
            }

            ans[idx]=min;
        }
        return ans[n];
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(nthUglyNumber(10)==12,"程序异常");
        //Assert.isTrue(nthUglyNumber(1)==1,"程序异常");
        Assert.isTrue(nthUglyNumber2(10)==12,"程序异常");
        Assert.isTrue(nthUglyNumber3(10)==12,"程序异常");

        System.out.println("-------------运行通过-------------");
    }
}
