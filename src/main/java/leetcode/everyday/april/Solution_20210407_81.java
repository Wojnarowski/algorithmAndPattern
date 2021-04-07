package leetcode.everyday.april;

import static leetcode.everyday.april.Solution_20210406_80.removeDuplicates;

/**
 *q 81   搜索旋转排序数组 II
 *
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 *
 *
 * 示例 2：
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 *
 *
 *
 */
public class Solution_20210407_81 {


    public static boolean search(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }

    private static boolean binarySearch(int[] nums, int target, int left, int right) {
        // 如果二分搜索左右边界都遇到了，意味着搜索到了最后一个元素，看看这个数和 target 是否相同
        if(left>=right){
            return nums[left]==target;
        }
        //否则查找中点的位置
        int mid = left+(right-left)/2;
        if(nums[mid] == target){
            return true;
        }
        else if(nums[mid]<target){
            // 如果偏小了，那么有两种情况需要递归
            //首先是如果 [left, right] 不是整体有序的话（nums[left] >= nums[right]），就需要再对整体分别递归
            if(nums[left]>=nums[right]){
                return binarySearch(nums,target,left,mid) || binarySearch(nums, target, mid + 1, right);
            }
            else{
                // 如果 [left, right] 已经整体有序了（走到了非递减子序列中），那么使用普通的二分查找就好了
                return binarySearch(nums, target, mid + 1, right);
            }
        }
        else{
            if (nums[left] >= nums[right]) {
                return binarySearch(nums, target, left, mid) || binarySearch(nums, target, mid + 1, right);
            }
            else{
                return binarySearch(nums, target, left, mid);
            }

        }


    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(merge(new int[]{1, 1, 2})==5,"程序异常");
        int result = removeDuplicates(new int[]{1,1,1,2,2,3});
        System.out.println(result);
        System.out.println("-------------运行通过-------------");
    }
}
