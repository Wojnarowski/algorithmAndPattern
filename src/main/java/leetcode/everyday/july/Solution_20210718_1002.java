package leetcode.everyday.july;

import java.util.*;

/**
 * 面试题 10.02. 变位词组
 *
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 *
 * 注意：本题相对原题稍作修改
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 通过次数23,528提交次数32,429
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Solution_20210718_1002 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = String.valueOf(cs);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        for (String key : map.keySet()) ans.add(map.get(key));
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(majorityElement(new int[]{1,2,5,9,5,9,5,5,5})==5,"程序异常");
        //Assert.isTrue(majorityElement(new int[]{3,2})==-1,"程序异常");

        System.out.println("-------------运行通过-------------");
    }
}
