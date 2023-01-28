package leetcode.everyday.commit2023.january;

import java.util.HashSet;
import java.util.Set;

/**
 * 1664. 生成平衡数组的方案数
 */
public class Solution_202230128_1664 {
    public int waysToMakeFair(int[] nums) {
        //差分数组，奇数个
        int n = nums.length;
        int temp = 0;
        int m = n;
        //如果是偶数个数组, 那么如果和跟最后一个相等就行了
        if (n%2 == 0) {
            temp = nums[n-1];
            //去掉最后一个数
            m--;
        }
        int[] diff = new int[m];
        diff[0] = nums[0];
        //sum1就是去掉第一个元素的时候
        int sum1 = 0;
        for(int i=1;i<m;i++) {
            diff[i] = nums[i] - nums[i-1];
            if (i%2 == 0) {
                sum1+=diff[i];
            }
        }
        int[] dp = new int[m];
        dp[0] = sum1;
        int ans = sum1 == temp?1:0;
        for(int i=1; i<m; i++) {
            if (i%2 == 0) {
                dp[i] = dp[i-1]-diff[i];
            } else {
                dp[i] = dp[i-1]+diff[i];
            }
            ans+=dp[i] == temp?1:0;
        }
        return ans;
    }
}
