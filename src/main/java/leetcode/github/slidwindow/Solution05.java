package leetcode.github.slidwindow;

import org.springframework.util.Assert;

import java.util.Arrays;

/**
 *  05.剑指 Offer 05. 替换空格
 *
 *  请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 * 通过次数237,197提交次数311,164
 * 请问您在哪类招聘中遇到此题？
 *
 *
 */
public class Solution05 {

    /**
     * 双指针移动方式
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        if(s.length() == 0){
            return s;
        }
        int blankNum= 0;
        //计算出空格数
        for( int i=0;i<s.length();i++){
            if(s.charAt(i) == 32){
                blankNum++;
            }
        }
        //替换后数组长度
        int newStrLen=s.length() + blankNum*2;
        //扩容原字符串
        char[] chars = Arrays.copyOf(s.toCharArray(),newStrLen);
        int oldEndIndex= s.length()-1;
        int newEndIndex=newStrLen-1;
        for(;oldEndIndex>=0;oldEndIndex--,newEndIndex--){
            if(oldEndIndex == newEndIndex){
                return new String(chars);
            }
            if(s.charAt(oldEndIndex) ==32){
                chars[oldEndIndex]='0';
                chars[--oldEndIndex]='2';
                chars[--oldEndIndex]='%';
            }
            else{
                chars[newEndIndex]=s.charAt(oldEndIndex);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(minSubArrayLen(7,new int[]{2,3,1,2,4,3})==2,"程序异常");

        System.out.println("-------------运行通过-------------");
    }
}
