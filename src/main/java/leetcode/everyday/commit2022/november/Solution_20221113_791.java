package leetcode.everyday.commit2022.november;

/**
 * 791. 自定义字符串排序
 *
 */
public class Solution_20221113_791 {
    public String customSortString(String order, String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (cnt[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (cnt[i]-- > 0) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();

    }
}
