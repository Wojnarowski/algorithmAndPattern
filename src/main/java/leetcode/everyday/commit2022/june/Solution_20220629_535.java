package leetcode.everyday.commit2022.june;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 535   TinyURL 的加密与解密
 *
 *
 * TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk 。请你设计一个类来加密与解密 TinyURL 。
 *
 * 加密和解密算法如何设计和运作是没有限制的，你只需要保证一个 URL 可以被加密成一个 TinyURL ，并且这个 TinyURL 可以用解密方法恢复成原本的 URL 。
 *
 * 实现 Solution 类：
 *
 * Solution() 初始化 TinyURL 系统对象。
 * String encode(String longUrl) 返回 longUrl 对应的 TinyURL 。
 * String decode(String shortUrl) 返回 shortUrl 原本的 URL 。题目数据保证给定的 shortUrl 是由同一个系统对象加密的。
 *  
 *
 * 示例：
 *
 * 输入：url = "https://leetcode.com/problems/design-tinyurl"
 * 输出："https://leetcode.com/problems/design-tinyurl"
 *
 * 解释：
 * Solution obj = new Solution();
 * string tiny = obj.encode(url); // 返回加密后得到的 TinyURL 。
 * string ans = obj.decode(tiny); // 返回解密后得到的原本的 URL 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/encode-and-decode-tinyurl
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */


public class Solution_20220629_535 {
    private Map<String, String> map = new HashMap<>();


    public String encode(String longUrl) {
        //生成一个8位的key 减少Hash冲突的可能 理论上越长越不容易冲突
        String key = getRandomString(8);
        while (map.containsKey(key)) {
            key = getRandomString(8);
        }
        this.map.put(key, longUrl);
        return "http://tinyurl.com/" + key;

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        //拿到key
        int p = shortUrl.lastIndexOf('/') + 1;
        String key = shortUrl.substring(p);
        return map.get(key);

    }

    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
