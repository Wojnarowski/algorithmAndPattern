package leetcode.everyday.commit2023.january;

/**
 * 2315. 统计星号
 */
public class Solution_202230129_2315 {
    public int countAsterisks(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int cnt = 0;
        char[] str = s.toCharArray();
        int N = str.length;
        boolean inRange = false;
        for (int i = 0; i < N; i++) {
            if(str[i] == '|') {
                inRange = !inRange;
            } else if(str[i] == '*') {
                if(!inRange) { // 不在||之间
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
