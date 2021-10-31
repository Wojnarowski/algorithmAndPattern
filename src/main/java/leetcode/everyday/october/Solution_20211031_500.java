package leetcode.everyday.october;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.util.*;

/**
 *q 500  键盘行
 *
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 *
 * 美式键盘 中：
 *
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * 示例 2：
 *
 * 输入：words = ["omk"]
 * 输出：[]
 * 示例 3：
 *
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] 由英文字母（小写和大写字母）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_20211031_500 {

    public static String[] findWords(String[] words) {
        List<String> ans = new ArrayList<String>();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        String str1="qwertyuiop";
        String str2="asdfghjkl";
        String str3="zxcvbnm";
        for(char ch:str1.toCharArray()){
            map.put(ch,1);
        }
        for(char ch:str2.toCharArray()){
            map.put(ch,2);
        }
        for(char ch:str3.toCharArray()){
            map.put(ch,3);
        }
        out:for(String str:words){

            int res=-1;
            for(char ch:str.toCharArray()){
                ch = Character.toLowerCase(ch);
                if (res == -1){
                    res = map.get(ch);
                }
                else if  (res !=map.get(ch)){
                    continue out;
                }else{
                    continue ;
                }
            }
            ans.add(str);
        }
        return ans.toArray(new String[ans.size()]);

    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
//        int [] num1= new int[]{4,1,2};
////        int [] num2= new int[]{1,3,4,2};
        String [] str= new String[]{"Hello","Alaska","Dad","Peace"};
        String [] ans = findWords(str);
        System.out.println(Arrays.toString(ans));

        //Assert.isTrue(findWords(5)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
