package leetcode.everyday.commit2023.february;

/**
 * 1247. 交换字符使得字符串相同
 */
public class Solution_202230225_1247 {

    public int minimumSwap(String s1, String s2) {
        // 低10位代表不同的字符对中s1字符为x的数量，高位代表不同的字符对数
        int diff = 0;
        for (int i = s1.length() - 1; i >= 0; --i) {
            char c = s1.charAt(i);
            if (c != s2.charAt(i)) {
                diff += c == 'x' ? 1025 : 1024;
            }
        }
        return (diff & 1024) == 1024 ? -1 : (diff >>> 11) + (diff & 1);
    }
}
