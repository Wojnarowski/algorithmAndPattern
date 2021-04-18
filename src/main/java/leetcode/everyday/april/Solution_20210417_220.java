package leetcode.everyday.april;

import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.TreeSet;

/**
 *q 220 存在重复元素 III
 *
 *
 * 给你一个整数数组 nums 和两个整数 k 和 t 。
 * 请你判断是否存在 两个不同下标 i 和 j，
 * 使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 *
 *
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 *
 *
 * 示例 3：
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 *  
 *
 *
 */
public class Solution_20210417_220 {


    private static long w;

    /**
     * 暴力 超时
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public  static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(Math.abs((long)nums[i] - (long)nums[j]) <= t && Math.abs(i - j) <= k ){
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 桶排序
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public  static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        /*
            k --- index     1
            t ---- value    2147483647
        */
        if(nums.length == 0 || t < 0)        return false;
        //long ---id    long value
        HashMap<Long, Long> map = new HashMap<>();
        w = (long)t + 1;

        for(int i = 0; i < nums.length; i++)
        {
            if(i - k - 1 >= 0 && map.containsKey(getID(nums[i - k - 1])))
                map.remove(getID(nums[i - k - 1]));
            if(map.containsKey(getID(nums[i])))
                return true;
            if(map.containsKey(getID(nums[i]) - 1)
                    && Math.abs(map.get(getID(nums[i]) - 1) - (long)nums[i]) <= t)
                return true;
            if(map.containsKey(getID(nums[i]) + 1)
                    && Math.abs(map.get(getID(nums[i]) + 1) - (long)nums[i]) <= t)
                return true;
            map.put(getID(nums[i]), (long)nums[i]);
        }
        return false;
    }

    private static long getID(long num)
    {
        if(num >= 0)    return (long) num / w;
        else            return (long) (num - 1) / w - 1;
    }

    /**
     * 滑动窗口3 宫水三叶
     * https://leetcode-cn.com/problems/contains-duplicate-iii/solution/gong-shui-san-xie-yi-ti-shuang-jie-hua-d-dlnv/
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public  static boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long u = nums[i] * 1L;
            // 从 ts 中找到小于等于 u 的最大值（小于等于 u 的最接近 u 的数）
            Long l = ts.floor(u);
            // 从 ts 中找到大于等于 u 的最小值（大于等于 u 的最接近 u 的数）
            Long r = ts.ceiling(u);
            if(l != null && u - l <= t) return true;
            if(r != null && r - u <= t) return true;
            // 将当前数加到 ts 中，并移除下标范围不在 [max(0, i - k), i) 的数（维持滑动窗口大小为 k）
            ts.add(u);
            if (i >= k) ts.remove(nums[i - k] * 1L);
        }
        return false;
    }
        public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(containsNearbyAlmostDuplicate(new int[]{1,2,3,1},3,0)==true,"程序异常");
        //Assert.isTrue(containsNearbyAlmostDuplicate(new int[]{1,0,1,1},1,2)==true,"程序异常");
        //Assert.isTrue(containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9},2,3)==false,"程序异常");
        Assert.isTrue(containsNearbyAlmostDuplicate(new int[]{-2147483648,2147483647},1,1)==false,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
