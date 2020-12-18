package zuo.db;

/**
 * 编辑距离
 * 给你两个单词 word1 和 word2 ，请你计算出word1 转成 word2 所需要的最少操作数
 * 你可以对一个单词做如下操作
 * 1.插入一个字符
 * 2.删除一个字符
 * 3.替换一个字符
 * 实例 如 word1='horse' ，word2='ros'
 *  解释
 *      horse->rorse (将h替换成r)
 *      rorse->rose （删除r）
 *      rose->ros (删除e)
 *
 *      参考链接
 *      https://www.cnblogs.com/www-helloworld-com/p/10202923.html
 *      https://www.cnblogs.com/happyfan/p/11674636.html
 *
 *
 */
public class MinDistance {

    public static int minDistance(String a,String b){
        int length1=a.length();
        int length2=b.length();
        int [][] dp= new int[length1+1][length2+1];

        //初始化第一列
        for(int row=0;row<length1+1;row++){
            dp[row][0]=row;
        }

        //初始化第一行
        for(int column=0;column<length2+1;column++){
            dp[0][column]=column;
        }

        for(int row=1;row<length1+1;row++){
            for(int column=1;column<length2+1;column++){
                //如果字符相等直接取左上角的值
                if(a.charAt(row-1)==b.charAt(column-1)){
                    dp[row][column]=dp[row-1][column-1];
                }else{
                    //否则取左，上，左上 三个值的最小值 +1
                    dp[row][column]=Math.min(
                            dp[row-1][column-1],
                            Math.min(dp[row][column-1],dp[row-1][column])
                    ) + 1;
                }
            }
        }
        // 递推后，表格最右下方的值就是整个问题的最优解
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        String a = "horse";
        String b = "ros";
        System.out.println("MinDsitance="+minDistance(a,b));
    }


}
