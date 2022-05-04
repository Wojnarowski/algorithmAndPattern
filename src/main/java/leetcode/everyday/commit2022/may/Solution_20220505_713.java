package leetcode.everyday.commit2022.may;

/**
 * 713   乘积小于 K 的子数组
 *给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * 示例 2：
 *
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 *  
 *
 * 提示: 
 *
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 * 通过次数44,422提交次数99,135
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-product-less-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution_20220505_713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        //left：滑动窗口左边界; right：滑动窗口右边界;
        //这里把left置为-1，为了便于计算窗口大小
        //cur当前窗口内数的乘积; ans：满足条件的子数组数量;
        int left = -1 , right = 0 , cur = 1, ans = 0;
        while(right < n){
            //若当前子数组乘积小于k，右边界右滑
            if(nums[right]*cur < k){
                cur *= nums[right];
                //ans 收集 counts；这里的counts就是 滑动窗口中所有含有元素nums[right]的子数组的数量
                ans += right-left;
                right++;
            }
            //若当前子数组乘积小于k
            else{
                //若当前窗口大小为1，说明当前右边界元素大于k，则左右边界一起右移
                if(right == left+1){
                    left++; right++;
                }
                //否则左边界右移且 除去左边界元素
                else cur /= nums[++left];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
