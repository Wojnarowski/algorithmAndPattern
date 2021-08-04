package leetcode.everyday.august;

import org.springframework.util.Assert;

import java.util.Arrays;


/**
 * 611 有效三角形的个数
 *
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 示例 1:
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 *
 * 注意:
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 *
 *
 */


public class Solution_20210804_611 {


    /**
     * 根据三角形特性两边和大于第三边
     * https://leetcode-cn.com/problems/valid-triangle-number/solution/pai-xu-er-fen-fa-by-zc19930508-l6rw/
     * @param nums
     * @return
     */
    public  static int triangleNumber(int[] nums) {
        if(nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        int ans =0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int index=binarySearch(nums,j+1,nums.length-1,nums[i]+nums[j]);
                ans+=index-j-1;
            }
        }
        return ans;
    }

    public static int binarySearch(int[] nums, int left, int right, int target) {
        while(left<right){
            int mid = left+((right-left) >>1);
//            if(nums[mid]==target){
//                return mid;
//            }
//            else
            if(nums[mid]>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }

//    public static int binarySearch(int[] nums, int left, int right, int target) {
//        while (left <= right) {
//            int mid = (right + left) / 2;
//            if (nums[mid] < target) {
//                left = mid + 1;
//            } else {
//                right = mid-1;
//            }
//        }
//        return left;
//    }


    /**
     * 两边之和大于第三边 暴力
     * @param nums
     * @return
     */
    public int triangleNumber2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (nums[j] + nums[k] > nums[i]) ans++;
                }
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        int [] arr = new int[]{2,2,3,4};

        System.out.println("-------------开始执行-------------");
        Assert.isTrue(triangleNumber(arr)==3,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
