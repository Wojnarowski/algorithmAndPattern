package leetcode.everyday;

import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 354. 俄罗斯套娃信封问题  困难
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 */
public class Solution_20210304_354 {


    /**
     * 思路一:先排序，然后动态规划
     * @param envelopes
     * @return
     */
    public static int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null){
            return 0;
        }
        //AlgorithmUtil.sysoutDobbleArray(envelopes);
        Arrays.sort(envelopes,(a,b)->a[0]-b[0]);
        //AlgorithmUtil.sysoutDobbleArray(envelopes);

        int n = envelopes.length;
        //f(i)为前i个物品，以i为结尾的最大值
        int[]f=new int[n];
        int ans =1;
        for(int i=0;i<n;i++){
            //对于每个f[i]都满足最小值为1
            f[i]=1;
            //枚举第i-1件物品
            for(int j=i-1;j>=0;j--){
                if(envelopes[j][0]<envelopes[i][0]&&envelopes[j][1]<envelopes[i][1]){
                    f[i]=Math.max(f[i],f[j]+1);
                }
            }
            ans=Math.max(ans,f[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int [][] envelopes=new int[][]{{5,4},{6,4},{6,7},{2,3}};
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(maxEnvelopes(envelopes)==3,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
