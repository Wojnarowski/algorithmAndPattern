package leetcode.everyday.commit2022.october;

import java.util.TreeMap;

/**
 * 801. 使序列递增的最小交换次数
 *
 *
 */
public class Solution_20221010_870 {

    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] min = new int[n];//记录每个位置的最小值
        int[] max = new int[n];//记录每个位置的最大值
        for(int i=0; i<n; i++){
            min[i] = Math.min(nums1[i],nums2[i]);
            max[i] = Math.max(nums1[i],nums2[i]);
        }
        int cnt1=0, cnt2=0;//分别记录数组一较大或数组二较大时需要的最小操作数
        if(nums1[0]>nums2[0]){//边界处理
            if(nums1[0]>=min[1]){
                cnt2++;
            }
        }else if(nums1[0]<nums2[0]){
            if(nums2[0]>=min[1]){
                cnt1++;
            }
        }
        for(int i=1; i<n-1; i++){
            if(nums1[i]>nums2[i]){
                if(nums1[i]>=min[i+1] || nums2[i]<=max[i-1]){
                    cnt2++;//满足如上条件时，将数组二作为较大数组的最小操作数+1
                }
            }else if(nums1[i]<nums2[i]){
                if(nums2[i]>=min[i+1] || nums1[i]<=max[i-1]){
                    cnt1++;//满足如上条件时，将数组一作为较大数组的最小操作数+1
                }
            }
            if(max[i]<min[i+1]){//条件满足时，可将数组分为两段分别寻找最小操作数，此时，将cnt1，cnt2同步为较小的一个值即可
                int t = Math.min(cnt1,cnt2);
                cnt1 = cnt2 = t;
            }
        }
        if(nums1[n-1]>nums2[n-1]){//边界处理
            if(nums2[n-1]<=max[n-2]){
                cnt2++;
            }
        }else if(nums1[n-1]<nums2[n-1]){
            if(nums1[n-1]<=max[n-2]){
                cnt1++;
            }
        }
        return Math.min(cnt1,cnt2);
    }
}
