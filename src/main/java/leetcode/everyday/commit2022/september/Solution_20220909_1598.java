package leetcode.everyday.commit2022.september;

/**
 * 1598     文件夹操作日志搜集器
 *
 *
 *
 */
public class Solution_20220909_1598 {

    public int minOperations(String[] logs) {
        int depth = 0;
        for (String s : logs) {
            if (s.equals("../")) depth = Math.max(0, depth - 1);
            else if (!s.equals("./")) depth++;
        }
        return depth;
    }


}
