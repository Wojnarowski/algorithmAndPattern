package leetcode.everyday.commit2022.april;

import java.util.*;

/**
 * 386  字典序排数
 *
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 *
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 5 * 104
 * 通过次数32,670提交次数43,089
 * 请问您在哪类招聘中遇到此题？
 *
 *
 *
 *
 *
 */
public class Solution_20220418_386 {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int cur = 1;
        for(int i = 0; i < n; i++) {
            ans.add(cur);
            if(cur * 10 <= n)
                cur *= 10;
            else {
                // 枚举到当前前缀的最深处了，需要回到上一层并到下一个同层节点
                while(cur % 10 == 9 || cur >= n)
                    cur /= 10;
                cur++;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
