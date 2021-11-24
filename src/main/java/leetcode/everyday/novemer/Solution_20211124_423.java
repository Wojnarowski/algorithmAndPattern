package leetcode.everyday.novemer;

import java.util.Arrays;

/**
 *
 * 423   从英文中重建数字
 *
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "owoztneoer"
 * 输出："012"
 * 示例 2：
 *
 * 输入：s = "fviefuro"
 * 输出："45"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
 * s 保证是一个符合题目要求的字符串
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-original-digits-from-english
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Solution_20211124_423 {

    static String[] ss = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static int[] priority = new int[]{0, 8, 6, 3, 2, 7, 5, 9, 4, 1};
    /**
     * 题目要求我们将打乱的英文单词重建为数字。
     *
     * 我们可以先对 s 进行词频统计，然后根据「英文单词中的字符唯一性」确定构建的顺序，最后再对答案进行排序即可。
     *
     * 具体的，zero 中的 z 在其余所有单词中都没出现过，我们可以先统计 zero 的出现次数，并构建 00；然后观察剩余数字，其中 eight 中的 g 具有唯一性，构建 88；再发现 six 中的 x 具有唯一性，构建 66；发现 three 中的 h 具有唯一性（利用在此之前 eight 已经被删除干净，词频中仅存在 three 对应的 h)，构建 33 ...
     *
     * 最终可以确定一个可行的构建序列为 0, 8, 6, 3, 2, 7, 5, 9, 4, 1。
     *
      * @param s
     * @return
     */
    public String originalDigits(String s) {
        int n = s.length();
        int[] cnts = new int[26];
        for (int i = 0; i < n; i++) cnts[s.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i : priority) {
            int k = Integer.MAX_VALUE;
            for (char c : ss[i].toCharArray()) k = Math.min(k, cnts[c - 'a']);
            for (char c : ss[i].toCharArray()) cnts[c - 'a'] -= k;
            while (k-- > 0) sb.append(i);
        }
        char[] cs = sb.toString().toCharArray();
        Arrays.sort(cs);
        return String.valueOf(cs);

    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{0,1};
        //Assert.isTrue(missingNumber(array)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
