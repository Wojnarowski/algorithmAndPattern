package leetcode.everyday.commit2022.may;

/**
 * 668   乘法表中第k小的数
 *
 *
 * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
 *
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 *
 * 例 1：
 *
 * 输入: m = 3, n = 3, k = 5
 * 输出: 3
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 *
 * 第5小的数字是 3 (1, 2, 2, 3, 3).
 * 例 2：
 *
 * 输入: m = 2, n = 3, k = 6
 * 输出: 6
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 *
 * 第6小的数字是 6 (1, 2, 2, 3, 4, 6).
 * 注意：
 *
 *
 *
 */


public class Solution_20220518_668 {

    public int findKthNumber(int m, int n, int k) {
        int l=0,r=m*n;
        while(l<r)
        {
            int mid=l+(r-l)/2;
            int cnt=0;
            for(int i=0;i<m&&i<mid;i++)
                cnt+=Math.min(mid/(i+1),n);
            if(cnt>=k)
                r=mid;
            else l=mid+1;
        }
        return l;
    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
