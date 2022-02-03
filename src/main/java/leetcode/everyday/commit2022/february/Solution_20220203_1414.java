package leetcode.everyday.commit2022.february;

import org.springframework.util.Assert;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 1414  和为 K 的最少斐波那契数字数目
 *
 * 给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
 *
 * 斐波那契数字定义为：
 *
 * F1 = 1
 * F2 = 1
 * Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
 * 数据保证对于给定的 k ，一定能找到可行解。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：k = 7
 * 输出：2
 * 解释：斐波那契数字为：1，1，2，3，5，8，13，……
 * 对于 k = 7 ，我们可以得到 2 + 5 = 7 。
 * 示例 2：
 *
 * 输入：k = 10
 * 输出：2
 * 解释：对于 k = 10 ，我们可以得到 2 + 8 = 10 。
 * 示例 3：
 *
 * 输入：k = 19
 * 输出：3
 * 解释：对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19 。
 *  
 *
 * 提示：
 *
 * 1 <= k <= 10^9
 * 通过次数21,410提交次数30,956
 *
 */
public class Solution_20220203_1414 {
    static List<Integer> list = new ArrayList<>();
    static {
        list.add(1);
        int a = 1, b = 1;
        while (b <= (int)1e9) {
            int c = a + b;
            a = b; b = c;
            list.add(c);
        }
    }


    public int findMinFibonacciNumbers(int k) {
        int ans = 0;
        while (k != 0) {
            int l = 0, r = list.size() - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (list.get(mid) <= k) l = mid;
                else r = mid - 1;
            }
            k -= list.get(r);
            ans++;
        }
        return ans;

    }

    public static void main(String[] args) {


        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(reversePrefix("abcd",'z').equals("abcd"),"程序异常");

        System.out.println("-------------运行通过-------------");

    }
}
