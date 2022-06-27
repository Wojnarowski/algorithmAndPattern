package leetcode.everyday.commit2022.june;

/**
 * 552    最长特殊序列 II
 *
 *
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。
 *
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
 *
 *  s 的 子序列可以通过删去字符串 s 中的某些字符实现。
 *
 * 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
 *  
 *
 * 示例 1：
 *
 * 输入: strs = ["aba","cdc","eae"]
 * 输出: 3
 * 示例 2:
 *
 * 输入: strs = ["aaa","aaa","aa"]
 * 输出: -1
 *  
 *
 * 提示:
 *
 * 2 <= strs.length <= 50
 * 1 <= strs[i].length <= 10
 * strs[i] 只包含小写英文字母
 * 通过次数12,169提交次数29,889
 * 请问您在哪类招聘中遇到此题？
 *
 *
 */


public class Solution_20220627_552 {

    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        a:
        for(int i = 0; i < n; i++){
            String a = strs[i];
            if(ans >= a.length()) continue;
            int v = 0;
            for(int j = 0; j < n; j++){
                if(i==j) continue;
                String b = strs[j];
                if(b.length()>=a.length()&&isSub(a,b)){
                    continue a;
                }
            }
            ans = a.length();
        }
        return ans;
    }

    private boolean isSub(String a, String b){
        int i=0;
        for(int j=0;i<a.length()&&j<b.length(); j++){
            if(a.charAt(i)==b.charAt(j))++i;
        }
        return i == a.length();
    }


    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
