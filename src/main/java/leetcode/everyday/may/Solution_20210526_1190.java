package leetcode.everyday.may;

/**
 *q 1190 反转每对括号间的子串
 *
 *
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 *
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 *
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 *
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 *
 */
public class Solution_20210526_1190 {

    /**
     * 双指针
     * @param s
     * @return
     */
    public static String reverseParentheses(String s) {
        int left=0;
        int right=0;
        left=s.lastIndexOf("(");
        right=s.indexOf(")",left);
        System.out.println("left="+left);
        System.out.println("right="+right);
        String ans="";
        int count=0;
        for(int i=left;i>=0;i--){ //一定是成对的，所以就控制一个左就行
           if(s.charAt(i)=='('){
               count++;
               int j=getRight(i,count,s);
               ans=reverse(i,j,s);
           }
        }
        System.out.println(ans);
        return ans;
    }

    private static int getRight(int left, int count, String s) {
        int right=0;
        for(int i=0;i<count;i++){
            right=getRight(left,count,s);
        }
        return right;
    }

    private static String reverse(int i, int j, String s) {
        StringBuilder sb=new StringBuilder();
        for(int tempI=i+1;tempI<j;tempI++){
            sb.append(s.charAt(tempI));
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(strangePrinter("aba")==2,"程序异常");
        //topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2);
        reverseParentheses("(u(love)i)");
        System.out.println("-------------运行通过-------------");

    }
}
