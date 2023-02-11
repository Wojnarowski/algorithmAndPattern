package leetcode.everyday.commit2023.february;

import java.util.Arrays;

/**
 * 2335. 装满杯子需要的最短总时长
 */
public class Solution_202230211_2335 {

    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if(amount[0]+amount[1]<=amount[2]){
            return amount[2];
        }
        amount[0]--;
        amount[1]--;
        return fillCups(amount)+1;

    }
}
