package leetcode.everyday.may;

/**
 *q 461 汉明距离
 *
 *两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 *
 */
public class Solution_20210527_461 {

    /**
     * 通过右移
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int ans =0;
        for(int i=0;i<32;i++){
            int a=(x>>i)&1,b=(y>>i)&1;
            ans+=a^b;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(strangePrinter("aba")==2,"程序异常");
        //topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2);
        System.out.println("-------------运行通过-------------");

    }
}
