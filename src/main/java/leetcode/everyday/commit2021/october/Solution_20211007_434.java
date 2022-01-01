package leetcode.everyday.commit2021.october;

/**
 *q 434. 字符串中的单词数
 *
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 * 通过次数41,276提交次数108,716
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution_20211007_434 {

    public int countSegments(String s) {
        int ans = 0;
        boolean word = false;// 默认没有单词
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                word = true;// 非空格找到一个单词
                continue;
            }
            if (word) {// 空格前 有单词,计数器+1
                ans++;
                word = false;// 重新找单词
                continue;
            }
        }
        ans += word ? 1 : 0;// 末尾前有没有单词
        return ans;

    }

    public int countSegments2(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; ) {
            if (s.charAt(i) == ' ' && i++ >= 0) continue;
            while (i < n && s.charAt(i) != ' ') i++;
            ans++;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{1,2,3,1};
        //Assert.isTrue(licenseKeyFormatting2("---",3).equals("5F3Z-2E9W"),"程序异常");

        System.out.println("-------------运行通过-------------");
    }
}
