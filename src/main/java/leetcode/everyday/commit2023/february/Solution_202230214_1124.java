package leetcode.everyday.commit2023.february;

import java.util.ArrayDeque;
import java.util.*;

/**
 * 1234. 替换子串得到平衡字符串
 */
public class Solution_202230214_1124 {

    public int longestWPI(int[] hours) {
        int preSum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            preSum += hours[i] > 8 ? 1 : -1;
            if (preSum > 0) {// 从数组第一个元素到目前位置组成的子数组就是「表现良好时间段」
                res = i + 1;
            } else {
                // 因为求最大长度，所以这里不能覆盖，key如果存在就不在存储
                map.putIfAbsent(preSum, i);
                // 查找区间和为1的子数组
                if (map.containsKey(preSum - 1))
                    res = Math.max(res, i - map.get(preSum - 1));
            }
        }
        return res;

    }


}
