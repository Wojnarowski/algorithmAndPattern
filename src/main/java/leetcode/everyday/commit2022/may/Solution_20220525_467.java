package leetcode.everyday.commit2022.may;

import leetcode.everyday.TreeNode;

/**
 * 467  绕字符串中唯一的子字符串
 *
 * 把字符串 s 看作是 “abcdefghijklmnopqrstuvwxyz” 的无限环绕字符串，所以 s 看起来是这样的：
 *
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." . 
 * 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。 
 *
 *  
 *
 * 示例 1:
 *
 * 输入: p = "a"
 * 输出: 1
 * 解释: 字符串 s 中只有一个"a"子字符。
 * 示例 2:
 *
 * 输入: p = "cac"
 * 输出: 2
 * 解释: 字符串 s 中的字符串“cac”只有两个子串“a”、“c”。.
 * 示例 3:
 *
 * 输入: p = "zab"
 * 输出: 6
 * 解释: 在字符串 s 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。
 *  
 *
 * 提示:
 *
 * 1 <= p.length <= 105
 * p 由小写英文字母构成
 * 通过次数13,008提交次数27,961
 *
 *
 *
 */


public class Solution_20220525_467 {

    public int findSubstringInWraproundString(String p) {
        int[] cs = new int[26];
        int n = p.length();
        for(int i = 0; i < n; ){
            int j = i;
            cs[p.charAt(i)-'a'] = Math.max(cs[p.charAt(i)-'a'],1);
            while (j+1<n&&(p.charAt(j+1)-p.charAt(j)==1 || p.charAt(j)=='z'&&p.charAt(j+1)=='a')){
                ++j;
                int index = p.charAt(j)-'a';
                cs[index] = Math.max(cs[index],j-i+1);
            }

            i = j+1;
        }
        int sum = 0;
        for(int v:cs) sum+=v;

        return sum;

    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
