package leetcode.everyday.commit2022.september;

import java.util.ArrayList;
import java.util.List;

/**
 * 1475   商品折扣后的最终价格
 *
 *
 *
 */
public class Solution_20220901_1475 {

    public int[] finalPrices(int[] prices) {
        int[] nums=new int[prices.length];
        for(int i=0;i<prices.length;i++){
            for(int j=i;j<prices.length;j++){
                if(j>i&&prices[j]<=prices[i]){
                    nums[i]=prices[i]-prices[j];
                    break;
                }
                nums[i]=prices[i];


            }
        }
        return nums;
    }
}
