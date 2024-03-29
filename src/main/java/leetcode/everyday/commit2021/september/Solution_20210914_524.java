package leetcode.everyday.commit2021.september;

import java.util.Collections;
import java.util.List;

/**
 *q 524   通过删除字母匹配到字典里最长单词
 *
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 *
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 *
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 * 通过次数46,998提交次数97,507
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Solution_20210914_524 {


    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, (a, b)->{
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });
        int n = s.length();
        for (String ss : dictionary) {
            int m = ss.length();
            int i = 0, j = 0;
            while (i < n && j < m) {
                if (s.charAt(i) == ss.charAt(j)) j++;
                i++;
            }
            if (j == m) return ss;
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //int [] array= new int[]{-1,0,3,5,9,12};
        //int target =2;
        //Assert.isTrue(search(array,target)==-1,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
