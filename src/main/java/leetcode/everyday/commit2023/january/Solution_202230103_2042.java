package leetcode.everyday.commit2023.january;

import java.util.PriorityQueue;

/**
 * 2042. 检查句子中的数字是否递增
 */
public class Solution_202230103_2042 {

    public boolean areNumbersAscending(String s) {
        int pre = -1, cur = 0, i = -1, n = s.length();
        char[] arr = s.toCharArray();
        while (++i < n) {
            if (Character.isDigit(arr[i])) {
                cur = arr[i] - '0';
                while (i + 1 < n && Character.isDigit(arr[i + 1])) cur = cur * 10 + arr[++i] - '0';
                if (cur <= pre) return false;
                pre = cur;
            }
        }
        return true;
    }
}
