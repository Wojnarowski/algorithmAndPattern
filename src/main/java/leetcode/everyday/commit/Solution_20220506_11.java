package leetcode.everyday.commit;

import java.util.HashMap;
import java.util.Map;

/**
 *11
 *
 */


public class Solution_20220506_11 {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j) {
            res=height[i]<height[j]?Math.max(res,(j-i)*height[i++]):Math.max(res,(j-i)*height[j--]);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
