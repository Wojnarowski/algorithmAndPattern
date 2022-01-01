package leetcode.everyday.commit2021.september;

import org.springframework.util.Assert;

/**
 *q 704 二分查找
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *  
 *
 * 提示：
 *
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 * 通过次数234,274提交次数419,633
 *
 *
 *
 */
public class Solution_20210906_704 {


    public static  int search(int[] nums, int target) {
        int left=0,right=nums.length;
        while (left<right){
            int mid =left+((right-left)>>2);
            if(target==nums[mid]){
                return mid;
            }
            else{
                if(nums[mid]<target){
                    left=mid+1;
                }
                else{
                    right=mid;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{-1,0,3,5,9,12};
        int target =2;
        Assert.isTrue(search(array,target)==-1,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
