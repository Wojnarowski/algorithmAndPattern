package leetcode.everyday.commit2022.october;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1768. 交替合并字符串
 */
public class Solution_20221023_1768 {

    public String mergeAlternately(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int i=0,j=0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i<n || j<m){
            if(i<n){
                stringBuilder.append(word1.charAt(i++));
            }
            if(j<n){
                stringBuilder.append(word2.charAt(j++));
            }
        }
        return stringBuilder.toString();
    }
}
