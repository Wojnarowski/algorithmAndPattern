package leetcode.everyday.december;

import java.util.HashSet;
import java.util.Set;

/**
 *q 1044  最长重复子串
 *
 * 给你一个字符串 s ，考虑其所有 重复子串 ：即，s 的连续子串，在 s 中出现 2 次或更多次。这些出现之间可能存在重叠。
 *
 * 返回 任意一个 可能具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "banana"
 * 输出："ana"
 * 示例 2：
 *
 * 输入：s = "abcd"
 * 输出：""
 *  
 *
 * 提示：
 *
 * 2 <= s.length <= 3 * 104
 * s 由小写英文字母组成
 * 通过次数8,182提交次数33,121
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-duplicate-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Solution_20211223_1044 {

    public String longestDupSubstring(String s) {
        String ans = "";
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            int mid = (l + r + 1) / 2;
            String x = find(s, mid);
            if (!x.equals("")) {
                l = mid + 1;
                ans = x;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    private String find(String s, int len) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= s.length() - len; i++) {
            String substr = s.substring(i, i + len);
            int hash = substr.hashCode();
            if (set.contains(hash) && s.indexOf(substr) != i) {
                return substr;
            }
            set.add(hash);
        }
        return "";
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{1,2,3,1};
        //Assert.isTrue(maxPower("leet")==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }


}
