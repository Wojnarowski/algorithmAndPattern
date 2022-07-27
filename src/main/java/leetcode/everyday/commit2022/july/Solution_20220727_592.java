package leetcode.everyday.commit2022.july;

import java.util.ArrayList;

/**
 * 592     分数加减运算分数加减运算
 *
 *
 * 给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 
 *
 * 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: expression = "-1/2+1/2"
 * 输出: "0/1"
 *  示例 2:
 *
 * 输入: expression = "-1/2+1/2+1/3"
 * 输出: "1/3"
 * 示例 3:
 *
 * 输入: expression = "1/3-1/2"
 * 输出: "-1/6"
 *  
 *
 * 提示:
 *
 * 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
 * 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
 * 输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
 * 输入的分数个数范围是 [1,10]。
 * 最终结果的分子与分母保证是 32 位整数范围内的有效整数。
 *
 */


public class Solution_20220727_592 {

    public String fractionAddition(String expression) {
//定义最大公分母
        int FENMU=3628800;
        //正数集合
        int[] pos=new int[10];
        int indexPos=0;
        //负数集合
        int[] neg=new int[10];
        int indexNeg=0;
        char[] letters=expression.toCharArray();
        //符号记录
        char fuhao='+';
        for(int i=0;i<expression.length();i++){
            //记录第一位的符号情况
            if(i==0 && (letters[0]=='-' || letters[0]=='+')){
                i++;
                fuhao=letters[0];
            }
            //截取分数
            int start=i;
            while(i<expression.length() && (letters[i]!='+' && letters[i]!='-')){
                i++;
            }
            String fenshu=expression.substring(start,i);
            int index=fenshu.indexOf('/');
            //得到分子
            String fenzi=fenshu.substring(0,index);
            //得到分母
            String fenmu=fenshu.substring(index+1);
            //计算用最大公分母表示的分数的分子
            int temp=Integer.valueOf(fenzi)*(FENMU/Integer.valueOf(fenmu));
            if(fuhao=='-'){
                neg[indexNeg++]=temp;
            }else{
                pos[indexPos++]=temp;
            }
            //记录当前符号位
            if(i<expression.length()){
                fuhao=letters[i];
            }
        }
        int sum1=0;
        int sum2=0;
        for(int i=0;i<indexPos;i++){
            sum1+=pos[i];
        }
        for(int i=0;i<indexNeg;i++){
            sum2+=neg[i];
        }
        int sum=sum1-sum2;
        //求最大公约数
        int yueshu=gcb(FENMU,Math.abs(sum));
        StringBuilder sb=new StringBuilder();
        if(sum<0){
            sb.append("-");
        }
        sum=Math.abs(sum);
        //约分
        sb.append(sum/yueshu).append("/").append(FENMU/yueshu);
        return sb.toString();
    }
    public int gcb(int a,int b){
        return b==0? a:gcb(b,a%b);

    }

}
