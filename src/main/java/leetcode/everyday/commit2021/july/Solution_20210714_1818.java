package leetcode.everyday.commit2021.july;

import java.util.Arrays;

/**
 *q 1818  绝对差值和
 *
 * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 *
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 *
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 *
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
 *
 * |x| 定义为：
 *
 * 如果 x >= 0 ，值为 x ，或者
 * 如果 x <= 0 ，值为 -x
 *  
 *
 * 示例 1：
 * 输入：nums1 = [1,7,5], nums2 = [2,3,5]
 * 输出：3
 * 解释：有两种可能的最优方案：
 * - 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
 * - 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
 * 两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
 *
 *
 * 示例 2：
 * 输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * 输出：0
 * 解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
 *
 *
 * 示例 3：
 * 输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * 输出：20
 * 解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
 * 绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 *  
 *
 * 提示：
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 105
 * 1 <= nums1[i], nums2[i] <= 105
 *
 *
 */
public class Solution_20210714_1818 {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        //复制一个nums1
        int [] n=new int [nums1.length];
        for(int i=0;i<n.length;i++){
            n[i]=nums1[i];
        }
        //对n排序是使用二分的前提
        Arrays.sort(n);
        //用max储存Max(abs(ai-ci)-abs(ai-bi))(i=0,1,2,…，n-1)
        int max=0;
        //求max
        for(int i=0;i<nums1.length;i++){
            //fun返回最优的abs(a-b)
            max=Math.max(max,Math.abs(nums1[i]-nums2[i])-fun(n,nums2[i]));
        }
        //长整型防溢出
        long ans=0;
        for(int i=0;i<nums1.length;i++){
            ans+=Math.abs(nums1[i]-nums2[i]);
        }
        //减去max就好了
        ans-=max;
        ans=ans%1000000007;

        return (int)ans;
    }


    int fun(int [] n,int a){
        int l=0,r=n.length-1,mid;
        int la=n[l],ra=n[r];
        while(l<=r){
            mid=(r+l)/2;
            if(n[mid]==a){
                return 0;
            }else if(n[mid]<a){
                l=mid+1;
                la=n[mid];
            }else{
                r=mid-1;
                ra=n[mid];
            }
        }

        return Math.min(Math.abs(a-la),Math.abs(a-ra));
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(majorityElement(new int[]{1,2,5,9,5,9,5,5,5})==5,"程序异常");
        //Assert.isTrue(majorityElement(new int[]{3,2})==-1,"程序异常");

        System.out.println("-------------运行通过-------------");
    }
}
