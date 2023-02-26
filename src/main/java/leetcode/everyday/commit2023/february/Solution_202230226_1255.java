package leetcode.everyday.commit2023.february;

import java.util.Arrays;

/**
 * 1255. 得分最高的单词集合
 */
public class Solution_202230226_1255 {

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        // 统计letters中各个字母出现的次数
        int[] map = new int[26];
        for(char letter : letters){
            map[letter-'a']++;
        }
        int n = words.length;
        // 取words的子集，每个单词都有两种状态，取或者不取
        int res = 0;
        for(int i=1;i< 1<<n;i++){
            // 因为我们判断每个子集的时候都需要字母次数的原始记录，所以不能直接在map上进行操作
            int[] mapTemp = Arrays.copyOf(map,26);
            // 选取每一个子集的初始分数
            int scores = 0;
            flag : for(int j=0;j<n;j++){
                if((1 & (i >> j)) == 1){
                    // 找到每个子集中所选取到的单词
                    String word = words[j];
                    for(int k=0;k<word.length();k++){
                        // 判断字母个数是否够用，也即是否是合理的子集选取，不合理的话先把分数置0，然后退出当前子集状态
                        // 不置零的话res = Math.max(res,scores)会把此前已经记录的分数给计算进去
                        if(mapTemp[word.charAt(k)-'a']==0){
                            scores = 0;
                            break flag;
                        }
                        // 将能够选取的个数减去1
                        mapTemp[word.charAt(k)-'a']--;
                        // 分数加上选取的字母的分数
                        scores += score[word.charAt(k)-'a'];
                    }
                }

            }
            // 找得分最高的结果集
            res = Math.max(res,scores);
        }
        return res;
    }
}
