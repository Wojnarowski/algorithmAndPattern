package leetcode.everyday.commit2021.august;


/**
 * 1480   一维数组的动态和
 *
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 *
 * 请返回 nums 的动态和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * 示例 3：
 *
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 *
 *
 */


public class Solution_20210828_1480 {

    public static int[] runningSum(int[] nums) {
        int [] sum = new int[nums.length];
        int temp =0;
        for(int i=0;i<nums.length;i++){
            temp+=nums[i];
            sum[i]=temp;
        }
        return sum;

    }


    public static void main(String[] args) {

        System.out.println("-------------开始执行-------------");
        int [] num=new int[]{1,2,3,4};
        int[] result = runningSum(num);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
        //Assert.isTrue(,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
