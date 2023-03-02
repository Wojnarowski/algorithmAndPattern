package leetcode.everyday.commit2023.march;

/**
 * 2351. 第一个出现两次的字母
 */
public class Solution_202230302_0502 {

    public String printBin(double num) {
        StringBuffer sb = new StringBuffer("0.");
        int i=0;
        while (num!=0&&i<6){
            num =  num*2;

            if (num>=1){
                //取小数部分
                num= num-1;
                sb.append("1");
            }else {
                sb.append("0");
            }
            i++;
        }
        //循环结束后num不为0 ，直接返回ERROR
        if (num!=0){
            return "ERROR";
        }
        return sb.toString();
    }
}
