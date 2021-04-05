package leetcode.everyday.april;

import org.springframework.util.Assert;

import java.util.Arrays;

/**
 *q 88   合并两个有序数组
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 * 通过次数314,870提交次数626,976
 *
 */
public class Solution_20210405_88 {


    /**
     * 思路1：创建一个和 nums1 等长的数组 arr，使用双指针将 num1 和 nums2的数据迁移到 arr。
     * 最后再将 arr复制到 nums1 中。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int total = m+n;
        int [] arr=new int[total];
        int idx=0;
        for(int i=0,j=0;i<m||j<n;){
            if(i<m && j<n){
                arr[idx++]=nums1[i]<nums2[j]?nums1[i++]:nums2[j++];
            }
            else if(i<m){
                arr[idx++] = nums1[i++];
            }
            else if(j<n){
                arr[idx++] = nums2[j++];
            }
        }
        System.arraycopy(arr,0,nums1,0,total);

    }

    /**
     * 先合并在排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 原地合并 从后往前
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1;
        int idx=m+n-1;
        while(j>=0 || i>=0){
            if(i>=0 && j>=0){
                nums1[idx--]=nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
            }else if (i >= 0) {
                nums1[idx--] = nums1[i--];
            } else {
                nums1[idx--] = nums2[j--];
            }
        }

    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(merge(new int[]{1, 1, 2})==5,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
