package leetcode.everyday.commit2021.august;


/**
 *551 学生出勤记录
 *
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 *
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 *
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 * 输入：s = "PPALLP"
 * 输出：true
 * 解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
 *
 *
 * 示例 2：
 * 输入：s = "PPALLL"
 * 输出：false
 * 解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。
 *
 *
 */


public class Solution_20210817_551 {


    public boolean checkRecord(String s) {
       int n=s.length();
       char[] cs = s.toCharArray();
       for(int i=0,cnt=0;i<n;){
           char c = cs[i];
           if (c == 'A') {
               cnt++;
               if(cnt>=2){
                   return false;
               }
           }
           else if(c == 'L'){
                int j=i;
                while(j<n&&cs[j]=='L'){
                    j++;
                }
                int len=j-i;
                if(len>=3){
                    return false;
                }
                i=j;
                continue;
           }
           i++;
       }
        return true;

    }

    public static void main(String[] args) {
        int [] arr = new int[]{2,2,3,4};

        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(tribonacci(3)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
