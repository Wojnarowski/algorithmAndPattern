package leetcode.everyday.commit;

import java.util.*;

/**
 *942 增减字符串匹配
 *
 *
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 *
 * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I' 
 * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D' 
 * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 *
 * 输入：s = "III"
 * 输出：[0,1,2,3]
 * 示例 3：
 *
 * 输入：s = "DDI"
 * 输出：[3,2,0,1]
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s 只包含字符 "I" 或 "D"
 * 通过次数43,422提交次数56,734
 *
 */


public class Solution_20220509_942 {

    public int[] diStringMatch(String s) {
        int n = s.length(), l = 0, r = n, idx = 0;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ans[idx++] = s.charAt(i) == 'I' ? l++ : r--;
        }
        ans[idx] = l;
        return ans;
    }


    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
