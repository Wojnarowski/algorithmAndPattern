package leetcode.everyday.novemer;

/**
 *
 * 299 猜数字游戏
 *
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 *
 * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
 *
 * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls", 公牛），
 * 有多少位属于数字猜对了但是位置不对（称为 "Cows", 奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
 * 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
 *
 * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
 *
 * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: secret = "1807", guess = "7810"
 * 输出: "1A3B"
 * 解释: 数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
 * "1807"
 *   |
 * "7810"
 * 示例 2:
 *
 * 输入: secret = "1123", guess = "0111"
 * 输出: "1A1B"
 * 解释: 数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
 * "1123"        "1123"
 *   |      or     |
 * "0111"        "0111"
 * 注意，两个不匹配的 1 中，只有一个会算作奶牛（数字猜对位置不对）。通过重新排列非公牛数字，其中仅有一个 1 可以成为公牛数字。
 * 示例 3：
 *
 * 输入：secret = "1", guess = "0"
 * 输出："0A0B"
 * 示例 4：
 *
 * 输入：secret = "1", guess = "1"
 * 输出："1A0B"
 *  
 *
 */
public class Solution_20211108_299 {

    public String getHint(String secret, String guess) {
        int n = secret.length();
        int a = 0, b = 0;
        int[] cnt1 = new int[10], cnt2 = new int[10];
        for (int i = 0; i < n; i++) {
            int c1 = secret.charAt(i) - '0', c2= guess.charAt(i) - '0';
            if (c1 == c2) {
                a++;
            } else {
                cnt1[c1]++;
                cnt2[c2]++;
            }
        }
        for (int i = 0; i < 10; i++) b += Math.min(cnt1[i], cnt2[i]);
        return a + "A" + b + "B";
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{0,1};
        //Assert.isTrue(missingNumber(array)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
