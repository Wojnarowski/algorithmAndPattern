package leetcode.everyday.october;

import java.util.*;

/**
 *q 496 下一个更大元素 I
 *
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 *
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *  
 *
 * 提示：
 *
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 *  
 *
 * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
 *
 * 通过次数109,132提交次数158,030
 *
 *
 *
 */
public class Solution_20211026_496 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int [] ans =new int[nums1.length];
        //<值，对nums2位置>
        Map<Integer,Integer>  map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }

        for(int i=0;i<nums1.length;i++){
            Integer pos=map.get(nums1[i]);
            if(pos ==null){
                ans[i]=-1;
            }
            else{
                for(int j=pos+1;j<nums2.length;j++){
                    if(nums2[j]>nums1[i]){
                        ans[i]=nums2[j];
                        break;
                    }
                }
                if(ans[i]==0){
                    ans[i]=-1;
                }

            }
        }
        return ans;
    }


    /**
     * 单调栈
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        Deque<Integer> d = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = m - 1; i >= 0; i--) {
            int x = nums2[i];
            while (!d.isEmpty() && d.peekLast() <= x) d.pollLast();
            map.put(x, d.isEmpty() ? -1 : d.peekLast());
            d.addLast(x);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = map.get(nums1[i]);
        return ans;

    }
    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
//        int [] num1= new int[]{4,1,2};
////        int [] num2= new int[]{1,3,4,2};
        int [] num1= new int[]{2,4};
        int [] num2= new int[]{1,2,3,4};
        int [] ans = nextGreaterElement(num1,num2);
        System.out.println(Arrays.toString(ans));

        //Assert.isTrue(arrangeCoins(5)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
