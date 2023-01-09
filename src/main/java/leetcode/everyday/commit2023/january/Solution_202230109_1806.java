package leetcode.everyday.commit2023.january;

/**
 * 1806. 还原排列的最少操作步数
 */
public class Solution_202230109_1806 {

    public int reinitializePermutation(int n) {
        int ans = 1, pos =1;
        pos = n/2 + (pos-1)/2;
        while(pos != 1){
            pos  = (pos%2 == 0)? pos/2 : (n/2 +(pos-1)/2);
            ans++;
        }
        return ans;
    }
}
