package leetcode.everyday.commit2023.hot100;

import java.util.*;

/**
 * 1. 两数之和
 */
public class Hot100_1 {
    public static int[] twoSum(int[] nums, int target) {
        /**
         * 遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
         * 如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
         *
         */
        //定义map  key 为nums[i]  value 为nums下标 i
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            if(map.get(target-nums[i])!=null){
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
//       int[]  nums =new int[]{2,7,11,15};
//       int target =9;
        int[]  nums =new int[]{3,3};
        int target =6;
        int[] ints = twoSum(nums, target);;

    }
}
