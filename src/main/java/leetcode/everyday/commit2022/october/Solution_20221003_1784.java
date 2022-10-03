package leetcode.everyday.commit2022.october;

/**
 *1784  检查二进制字符串字段
 *
 *
 */
public class Solution_20221003_1784 {

    public boolean checkOnesSegment(String s) {
        int n = s.length(), cnt = 0, idx = 0;
        while (idx < n && cnt <= 1) {
            while (idx < n && s.charAt(idx) == '0') idx++;
            if (idx < n) {
                while (idx < n && s.charAt(idx) == '1') idx++;
                cnt++;
            }
        }
        return cnt <= 1;

    }
}
