package leetcode.everyday.commit2023.february;

import java.util.*;

/**
 * 1233. 删除子文件夹
 */
public class Solution_202230208_1233 {

    public List<String> removeSubfolders(String[] folder) {
        Set<String> set = new HashSet<>();
        for (String f : folder) {
            set.add(f);
        }

        List<String> ans = new ArrayList<>();
        for (String f : folder) {
            boolean subFolder = false;

            // 判断父目录是否存在
            for (int i = 1; i < f.length(); i++) {
                if (f.charAt(i) == '/') {
                    String parentFolder = f.substring(0, i);
                    if (set.contains(parentFolder)) {
                        subFolder = true;
                        break;
                    }
                }
            }

            if (!subFolder) ans.add(f);
        }
        return ans;
    }

}
