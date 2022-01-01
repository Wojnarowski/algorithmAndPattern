package leetcode.everyday.commit2021.june;

import org.springframework.util.Assert;

/**
 *q 852 山脉数组的峰顶索引
 *
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [0,1,0]
 * 输出：1
 *
 *
 * 示例 2：
 * 输入：arr = [0,2,1,0]
 * 输出：1
 *
 *
 * 示例 3：
 * 输入：arr = [0,10,5,2]
 * 输出：1
 *
 *
 * 示例 4：
 * 输入：arr = [3,4,5,1]
 * 输出：2
 *
 *
 * 示例 5：
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 *  
 *
 * 提示：
 *
 * 3 <= arr.length <= 104
 * 0 <= arr[i] <= 106
 * 题目数据保证 arr 是一个山脉数组
 *
 *
 */
public class Solution_20210615_852 {

    /**
     * 还是二分
     * @param arr
     * @return
     */
    public static int peakIndexInMountainArray1(int[] arr) {
        if(arr.length<3){
            return 0;
        }

        int l=1,r=arr.length-1;
        while(l<r){
            int mid = (l+r+1)>>1;
            if(arr[mid-1]<arr[mid]){
                l=mid;
            }
            else{
                r=mid-1;
            }
        }
        return r;
    }

    /**
     * 三分法
     * @param arr
     * @return
     */
    public static int peakIndexInMountainArray2(int[] arr) {
        if(arr.length<3){
            return 0;
        }

        int l=1,r=arr.length-1;
        while(l<r){
            int m1 = l+(r-l)/3;
            int m2 = r-(r-l)/3;
            if(arr[m1]>arr[m2]){
                r=m2-1;
            }
            else{
                l=m1+1;
            }
        }
        return r;
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(peakIndexInMountainArray1(new int[]{0,1,0})==1,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
