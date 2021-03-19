package leetcode.everyday.march;

import java.util.*;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 */
public class Solution_20210307_131 {


    /**
     * 回溯算法
     * 三部曲
     *      1.确定参数
     *      2.确定终止条件
     *      3.单层逻辑
     * @param s
     * @return
     */
    public static List<List<String>> partition(String s) {
        //定义返回值
        List<List<String>> ans =new ArrayList<>();
        LinkedList<String> path= new LinkedList<>();
        //1.设定参数
        backTrack(s,path,ans);

        return ans;

    }

    private static void backTrack(String s, LinkedList<String> path, List<List<String>> ans) {
        //2.设定结束条件
        if(s.length()==0){
            ans.add(new ArrayList<>(path));
            return ;
        }
        //3.单层逻辑
        for(int i=1;i<=s.length();i++){
            String pre=s.substring(0,i);
            if(!isPalindrome(pre)){
                continue;
            }
            path.add(pre);
            backTrack(s.substring(i), path,ans);
            //撤销选择
            path.removeLast();

        }
    }

    private static boolean isPalindrome(String s) {
        int n = s.length();
        if (n <= 1) {
            return true;
        }
        char[] chars = s.toCharArray();
        int l = 0, r = n - 1;
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {

        String temp ="abc";
        System.out.println(temp.substring(0));
        System.out.println(temp.substring(1));
        System.out.println(temp.substring(2));

        System.out.println(temp.substring(0,1));
        System.out.println("-------------------------");
        List<List<String>>  list = partition("aab");
        System.out.println(Arrays.toString(list.toArray()));

    }
}
