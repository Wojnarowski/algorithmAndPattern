package leetcode.github.slidwindow;

import org.springframework.util.Assert;

/**
 *q_121. 买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * 提示：
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 * 通过次数396,274提交次数703,408
 *
 */
public class Solution121 {

    /**
     * 思路：相当于找到数组中的最小值，和该最小值后面的最大值，两者做差
     * TODO 超时了
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if(prices==null|| prices.length==0){
            return 0;
        }

        int ans=0;
        for(int i=0;i<prices.length;i++){
            int right=i+1;
            while(right<prices.length){
                if(prices[right]>prices[i]){
                    ans=Math.max(ans,prices[right]-prices[i]);
                }
                right++;
            }
        }
        return ans;
    }

    public static int maxProfit2(int[] prices) {
        if(prices==null|| prices.length==0){
            return 0;
        }

        int ans=0;
        int minPrice=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }
            else{
                ans=Math.max(ans,prices[i]-minPrice);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(maxProfit(new int[]{7,1,5,3,6,4})==5,"程序异常");
        Assert.isTrue(maxProfit(new int[]{7,6,4,3,1})==0,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
