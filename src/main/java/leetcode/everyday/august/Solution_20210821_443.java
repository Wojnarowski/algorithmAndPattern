package leetcode.everyday.august;


/**
 *443 压缩字符串
 *
 *给你一个字符数组 chars ，请使用下述算法压缩：
 *
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 *
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 *
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 *
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 *
 *  
 *
 *
 */


public class Solution_20210821_443 {

    public int compress(char[] chars) {
        if(chars.length == 1){
            return 1;
        }
        int left = 0;
        int right = 1;
        int cur =0;

        while(right < chars.length){
            chars[cur] = chars[left];
            cur++;

            while(right<chars.length && chars[right] == chars[left]){
                right++;
            }

            if(right - left > 1){
                char[] num = String.valueOf(right-left).toCharArray();
                System.arraycopy(num, 0, chars, cur, num.length);
                cur += num.length;
            }

            left = right;
        }

        return cur;

    }
    public static void main(String[] args) {
        int [] arr = new int[]{2,2,3,4};

        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(tribonacci(3)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
