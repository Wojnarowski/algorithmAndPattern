package leetcode.everyday.april;

import org.springframework.util.Assert;

/**
 *q 27 移除元素
 *
 *实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle
 * 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 *  
 *
 * 说明：
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。
 * 这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 *
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 *
 * 输入：haystack = "", needle = ""
 * 输出：0
 *  
 *
 * 提示：
 *
 * 0 <= haystack.length, needle.le
 *
 *
 *  
 *解题答案
 * https://leetcode-cn.com/problems/implement-strstr/solution/shua-chuan-lc-shuang-bai-po-su-jie-fa-km-tb86/
 *
 */
public class Solution_20210420_28 {

    /**
     * 朴素解法
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if(needle=="" || needle==null || needle.length()==0){
            return 0;
        }
        int n=haystack.length();
        int m=needle.length();
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();

        /**
         * 限制条件为n - m
         * 举例 haystack为 bba  needle为aa
         *  如果到haystack为下标1处b还和a不相等，没有必要在循环haystack了
         */
        for(int i=0;i<=n-m;i++){
           int a=i,b=0;
           while(b<m && s[a]==p[b]){
               a++;
               b++;
           }
           if(b==m){
               return i;
           }
        }
        return -1;
    }
        public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(strStr("hello","ll")==2,"程序异常");
        //Assert.isTrue(strStr("aaaaa","bba")==-1,"程序异常");
        //Assert.isTrue(strStr(" "," ")==0,"程序异常");
        Assert.isTrue(strStr("baa","aa")==1,"程序异常");

        System.out.println("-------------运行通过-------------");
    }
}
