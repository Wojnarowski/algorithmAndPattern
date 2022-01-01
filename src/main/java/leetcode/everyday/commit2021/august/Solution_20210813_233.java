package leetcode.everyday.commit2021.august;


/**
 * 233   数字 1 的个数
 *
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 *  
 *
 * 示例 1：
 * 输入：n = 13
 * 输出：6
 *
 *
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 *  
 *
 * 提示：
 * 0 <= n <= 2 * 109
 * 通过次数20,095提交次数46,826
 * 请问您在哪类招聘中遇到此题？
 *
 *
 */


public class Solution_20210813_233 {

    public int countDigitOne(int n) {
        if(n<1)return 0;
        int[] f = new int[10];
        f[0] = 1;
        for(int i=1;i<f.length;i++)f[i] = f[i-1]*10;
        int ans = 0;
        String s = String.valueOf(n+"");
        for(int i=0;i<s.length();i++){
            for(int j=0;j<i;j++){
                ans += (s.charAt(j)-'0')*f[s.length()-j-2];
            }
            if(s.charAt(i) > '1'){
                ans += f[s.length()-i-1];
            }else if(s.charAt(i) == '1'){
                if(i<s.length()-1)ans += Integer.parseInt(s.substring(i+1))+1;
                else ans++;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int [] arr = new int[]{2,2,3,4};

        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(tribonacci(3)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
