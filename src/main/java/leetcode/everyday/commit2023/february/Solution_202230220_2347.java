package leetcode.everyday.commit2023.february;

/**
 * 1792. 最大平均通过率
 */
public class Solution_202230220_2347 {

    public String bestHand(int[] ranks, char[] suits) {
        if (isFlush(suits)) {
            return "Flush";
        }

        boolean isPair = false;
        int cnt = 0;
        for (int rank : ranks) {
            int mark = 1 << (rank - 1 << 1);
            if ((cnt & mark << 1) != 0) {
                return "Three of a Kind";
            }

            isPair |= (cnt & mark) != 0;
            cnt += mark;
        }
        return isPair ? "Pair" : "High Card";
    }

    private static boolean isFlush(char[] suits) {
        for (int c = suits[0], i = suits.length - 1; i > 0; i--) {
            if (suits[i] != c) {
                return false;
            }
        }
        return true;
    }

}
