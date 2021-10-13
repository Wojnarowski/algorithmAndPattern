package leetcode.everyday.october;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 *q 441 排列硬币
 *
 *
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 *
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 * 示例 2：
 *
 *
 * 输入：n = 8
 * 输出：3
 * 解释：因为第四行不完整，所以返回 3 。
 *  
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 * 通过次数72,992提交次数160,105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arranging-coins
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution_20211010_441 {


    public static int arrangeCoins(int n) {
        int ans =0;
        for(int i=0;i<n;i++){
            if(n>=i+1){
                ans++;
                n=n-i-1;
            }
            //ans++;
        }
        return ans;
    }

    /**
     * 二分法
     * @param n
     * @return
     */
    public static int arrangeCoins2(int n) {
        long l = 1, r = n;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (mid * (mid + 1) / 2 <= n) l = mid;
            else r = mid - 1;
        }
        return (int)r;
    }
    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{1,2,3,1};
        Assert.isTrue(arrangeCoins(5)==2,"程序异常");

        System.out.println("-------------运行通过-------------");
    }
}