package leetcode.everyday.commit2023.february;

/**
 * 1234. 替换子串得到平衡字符串
 */
public class Solution_202230213_1234 {

    public int balancedString(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'A']++;
        }
        int len = s.length();
        int l = 0, r = 0;
        int ans = len;
        int targetQ = Math.max(0, cnt['Q' - 'A'] - len / 4);
        int targetW = Math.max(0, cnt['W' - 'A'] - len / 4);
        int targetE = Math.max(0, cnt['E' - 'A'] - len / 4);
        int targetR = Math.max(0, cnt['R' - 'A'] - len / 4);
        int[] cur = new int[26];
        while (l < len) {
            while (r < len && (cur['Q' - 'A'] < targetQ || cur['W' - 'A'] < targetW || cur['E' - 'A'] < targetE || cur['R' - 'A'] < targetR)) {
                cur[s.charAt(r) - 'A']++;
                r++;
            }
            if (cur['Q' - 'A'] >= targetQ && cur['W' - 'A'] >= targetW && cur['E' - 'A'] >= targetE && cur['R' - 'A'] >= targetR) {
                ans = Math.min(ans, r - l);

            }
            cur[s.charAt(l++) - 'A']--;
        }
        return ans;
    }
}
