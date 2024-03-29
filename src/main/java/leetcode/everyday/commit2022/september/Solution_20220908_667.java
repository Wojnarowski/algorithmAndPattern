package leetcode.everyday.commit2022.september;

/**
 * 667    优美的排列 II
 *
 *
 *
 */
public class Solution_20220908_667 {

    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int i = 0;
        //p从小到大 q从大到小
        int p = 1, q = n;
        //构造前k个数组 k-1个不同的整数
        //奇数位从大到小，偶数位从小到大
        for (int j = 0; j < k; j++) {
            if (j % 2 == 0) {
                ans[i++] = p++;
            } else {
                ans[i++] = q--;
            }
        }
        //构造剩下的绝对值为1的序列
        if (k % 2 == 0) {
            //偶数时，降序
            while (i < n) {
                ans[i++] = q--;
            }
        } else {
            //奇数时，升序
            while (i < n) {
                ans[i++] = p++;
            }
        }
        return ans;

    }
}
