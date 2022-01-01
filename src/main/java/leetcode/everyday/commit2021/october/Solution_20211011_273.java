package leetcode.everyday.commit2021.october;

/**
 *q 273 整数转换英文表示
 *
 *
 * 将非负整数 num 转换为其对应的英文表示。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：num = 123
 * 输出："One Hundred Twenty Three"
 * 示例 2：
 *
 * 输入：num = 12345
 * 输出："Twelve Thousand Three Hundred Forty Five"
 * 示例 3：
 *
 * 输入：num = 1234567
 * 输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 示例 4：
 *
 * 输入：num = 1234567891
 * 输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *  
 *
 * 提示：
 *
 * 0 <= num <= 231 - 1
 * 通过次数14,267提交次数43,147
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-english-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution_20211011_273 {

    private final String[] num119 = new String[] { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen" };
    private final String[] num2090 = new String[] { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety" };

    private final int billion = 1_000_000_000;
    private final int million = 1_000_000;
    private final int thousand = 1_000;
    private final int hundred = 100;

    private final int[] partsNum = new int[] { billion, million, thousand, hundred };
    private final String[] partsStr = new String[] { "Billion", "Million", "Thousand", "Hundred" };
    private final char blank = ' ';


    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            num = this.part(num, i, ans);
        }
        ans.append(hundred(num));
        return ans.toString();

    }


    public int part(int num, int partIndex, StringBuffer ans) {
        int part = this.partsNum[partIndex];
        if (num >= part) {
            ans.append(this.hundred(num / part)).append(this.blank).append(this.partsStr[partIndex]);
            num = num % part;
            if (num != 0)
                ans.append(this.blank);
        }
        return num;
    }

    public String hundred(int num) {
        StringBuffer ans = new StringBuffer();
        if (num >= hundred) {
            int hnum = num / hundred;
            ans.append(num119[hnum]).append(this.blank).append(this.partsStr[3]);
            num = num % hundred;
            if (num != 0)
                ans.append(this.blank);
        }
        if (num > 19) {
            int hnum = num / 10;
            ans.append(num2090[hnum]);
            num = num % 10;
            if (num != 0) {
                ans.append(this.blank);
            }
        }
        if (num != 0)
            ans.append(num119[num]);
        return ans.toString();
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{1,2,3,1};
        //Assert.isTrue(arrangeCoins(5)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
