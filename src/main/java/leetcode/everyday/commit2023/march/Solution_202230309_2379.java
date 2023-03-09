package leetcode.everyday.commit2023.march;

/**
 * 2351. 第一个出现两次的字母
 */
public class Solution_202230309_2379 {
    public int minimumRecolors(String blocks, int k) {
        //前k个中w的数量
        int bmum=0;
        for (int i = 0; i <k; i++) {
            if (blocks.charAt(i)=='W'){
                bmum++;
            }
        }
        int min = bmum;
        //字符串从0 开始计数，
        //计算i=k计算的是第k+1和第一个字符之间的w数量
        for (int i = k; i <blocks.length(); i++) {
            if (blocks.charAt(i)=='W'){
                bmum++;
            }
            if (blocks.charAt(i-k)=='W'){
                bmum--;
            }
            min =  Math.min(min,bmum);
        }
        return min;
    }
}
