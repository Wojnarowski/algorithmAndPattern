package leetcode.everyday.october;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *q 869  重新排序得到 2 的幂
 *
 *
 *
 */
public class Solution_20211028_869 {

    /**
     * 打表+DFS
     * @param n
     * @return
     */

    static Set<Integer> set = new HashSet<>();
    static {
        for (int i = 1; i < (int)1e9+10; i *= 2) set.add(i);
    }
    int m;
    int[] cnts = new int[10];

    public boolean reorderedPowerOf2(int n) {
        while (n != 0) {
            cnts[n % 10]++;
            n /= 10;
            m++;
        }
        return dfs(0, 0);
    }
    boolean dfs(int u, int cur) {
        if (u == m) return set.contains(cur);
        for (int i = 0; i < 10; i++) {
            if (cnts[i] != 0) {
                cnts[i]--;
                if ((i != 0 || cur != 0) && dfs(u + 1, cur * 10 + i)) return true;
                cnts[i]++;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
//        int [] num1= new int[]{4,1,2};
////        int [] num2= new int[]{1,3,4,2};
        int [] num1= new int[]{2,4};
        int [] num2= new int[]{1,2,3,4};
        //int [] ans = nextGreaterElement(num1,num2);
        //System.out.println(Arrays.toString(ans));

        //Assert.isTrue(arrangeCoins(5)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
