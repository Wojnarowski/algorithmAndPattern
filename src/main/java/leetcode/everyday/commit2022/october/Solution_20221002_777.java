package leetcode.everyday.commit2022.october;

/**
 *777. 在LR字符串中交换相邻字符
 *
 *
 */
public class Solution_20221002_777 {

    public boolean canTransform(String start, String end) {
        int len = start.length();
        int sR = 0, sL = 0, j = 0;
        int eR = 0, eL = 0, k = 0;
        for(int i = 0; i < len; ++i){
            while(j<len && start.charAt(j) == 'X') j++;
            while(k<len && end.charAt(k) == 'X') k++;
            if( j<len && k<len && start.charAt(j++) != end.charAt(k++)) {
                return false;
            }
            if(start.charAt(i) == 'L'){
                sL++;
            } else if(start.charAt(i) == 'R'){
                sR++;
            }
            if(end.charAt(i) == 'L'){
                eL++;
            } else if(end.charAt(i) == 'R'){
                eR++;
            }
            if(eL < sL || eR > sR) {
                return false;
            }
        }
        while(j < len){
            if(start.charAt(j++) != 'X') return false;
        }
        while(k < len){
            if(end.charAt(k++) != 'X') return false;
        }
        return true;
    }
}
