package leetcode.everyday;

import org.springframework.util.Assert;

/**
 *1052. 爱生气的书店老板
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 *
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 *
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 *
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *  
 *
 * 示例：
 *
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *  
 *
 */


public class Solution_20210223_1052 {

    /**
     * 思路
     * 1.先将原本就满意的客户加入答案,同时将对应的 customers[i] 变为 0。
     * 2.之后的问题转化为：在 customers 中找到连续一段长度为 x 的子数组，使得其总和最大。
     *  这部分就是我们应用技巧所得到的客户。(利用滑动窗口)
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public static  int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int ans=0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0){
                ans=ans+customers[i];
                customers[i]=0;
            }
        }
        System.out.println("原本满意的人共有"+ans+"人");

        int max=0,curMax=0;
        for(int i=0,j=0;i<customers.length;i++){
            curMax+=customers[i];
            if(i-j+1>X){
                curMax=curMax-customers[j];
                j++;
            }
            max=Math.max(max,curMax);
        }
        ans=ans+max;
        return ans;

    }

    public static void main(String[] args) {
        int [] customers  = new int[]{1,0,1,2,1,1,7,5};
        int [] grumpy  = new int[]{0,1,0,1,0,1,0,1};
        int X=3;

        System.out.println("-------------开始执行-------------");
        Assert.isTrue(maxSatisfied(customers,grumpy,X)==16,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
