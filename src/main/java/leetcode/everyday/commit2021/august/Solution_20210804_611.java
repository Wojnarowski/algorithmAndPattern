package leetcode.everyday.commit2021.august;

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
     * 1、首先排序
     * 2、用二分法找到这个k 使得满足不等式nums[i] + nums[j] > nums[k]
     * 3、最后将 k-j-1 累加入答案
     * 4、这个二分法找的是与nums[i] + nums[j]最靠近的一个数 如果不存在这个数则会找到比他大的一个数 所以答案是 k-j-1;
     *
     * @param nums
     * @return
     */
    public  static int triangleNumber1(int[] nums) {
        if(nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        int n=nums.length;
        int ans =0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                int index=binarySearch(nums,j+1,n-1,nums[i]+nums[j]);
                    ans+=index-j;
            }
        }
        return ans;
    }

    public static int binarySearch(int[] nums, int left, int right, int target) {
        while(left<=right){
            int mid = left+((right-left) >>1);
            if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return right;
    }

//    public static int binarySearch(int[] nums, int left, int right, int target) {
//        while (left <= right) {
//            int mid = (right + left) / 2;
//            //int mid = left+((right-left) >>1);
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


    /**
     * 双指针
     * @param nums
     * @return
     */
    public int triangleNumber3(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1, k = 0; k < j; j--) {
                while (k < j && nums[k] + nums[j] <= nums[i]) k++;
                ans += j - k;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        int [] arr = new int[]{2,2,3,4};

        System.out.println("-------------开始执行-------------");
        Assert.isTrue(triangleNumber1(arr)==3,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
