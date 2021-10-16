package leetcode.everyday.october;

import java.util.ArrayList;
import java.util.List;

/**
 *q 282 给表达式添加运算符
 *
 * 给定一个仅包含数字 0-9 的字符串 num 和一个目标值整数 target ，在 num 的数字之间添加 二元 运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: num = "123", target = 6
 * 输出: ["1+2+3", "1*2*3"]
 * 示例 2:
 *
 * 输入: num = "232", target = 8
 * 输出: ["2*3+2", "2+3*2"]
 * 示例 3:
 *
 * 输入: num = "105", target = 5
 * 输出: ["1*0+5","10-5"]
 * 示例 4:
 *
 * 输入: num = "00", target = 0
 * 输出: ["0+0", "0-0", "0*0"]
 * 示例 5:
 *
 * 输入: num = "3456237490", target = 9191
 * 输出: []
 *  
 *
 * 提示：
 *
 * 1 <= num.length <= 10
 * num 仅含数字
 * -231 <= target <= 231 - 1
 * 通过次数16,095提交次数34,053
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/expression-add-operators
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 */
public class Solution_20211016_282 {

    List<String> ans = new ArrayList<>();
    String s;
    int n, t;
    public List<String> addOperators(String num, int target) {
        s = num;
        n = s.length();
        t = target;
        dfs(0, 0, 0, "");
        return ans;
    }
    void dfs(int u, long prev, long cur, String ss) {
        if (u == n) {
            if (cur == t) ans.add(ss);
            return ;
        }
        for (int i = u; i < n; i++) {
            if (i != u && s.charAt(u) == '0') break;
            long next = Long.parseLong(s.substring(u, i + 1));
            if (u == 0) {
                dfs(i + 1, next, next, "" + next);
            } else {
                dfs(i + 1,  next, cur + next, ss + "+" + next);
                dfs(i + 1, -next, cur - next, ss + "-" + next);
                long x = prev * next;
                dfs(i + 1, x, cur - prev + x, ss + "*" + next);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{1,2,3,1};
        //Assert.isTrue(arrangeCoins(5)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
