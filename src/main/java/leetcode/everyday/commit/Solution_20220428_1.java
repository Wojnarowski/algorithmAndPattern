package leetcode.everyday.commit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 */


public class Solution_20220428_1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            else{
                map.put(nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
