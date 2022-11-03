package leetcode.everyday.commit2022.november;

/**
 * 1620. 网络信号最好的坐标
 *
 */
public class Solution_20221103_1668 {

    public int maxRepeating(String sequence, String word) {
        int ans = 0;
        char[] cs = sequence.toCharArray();
        char[] ws = word.toCharArray();
        int p = 0;
        while (p < cs.length) {
            if (cs[p] == ws[0]) {
                int k = 0, t = p, i = 0;
                while (t < cs.length && cs[t] == ws[i]) {
                    t++;
                    if (i + 1 < ws.length) {
                        i += 1;
                    } else {
                        i = 0;
                        k++;
                    }
                }
                ans = Math.max(ans, k);
            }
            p++;
        }
        return ans;

    }
}
