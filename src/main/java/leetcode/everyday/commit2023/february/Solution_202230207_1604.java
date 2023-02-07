package leetcode.everyday.commit2023.february;

import leetcode.everyday.TreeNode;

import java.util.*;

/**
 * 2331. 计算布尔二叉树的值
 */
public class Solution_202230207_1604 {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        String[][] nameTime = this.zip(keyName, keyTime);
        Arrays.sort(nameTime, (a, b) -> a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));
        List<String> ans = new ArrayList<>();
        String who = "";
        boolean add = false;
        int[] times = new int[3];
        for (int i = 0, cnt = 0; i < nameTime.length; i++) {
            String name = nameTime[i][0];
            int time = this.time(nameTime[i][1]);
            if (name.equals(who)) {
                if (!add) {
                    times[cnt % 3] = time;
                    if (cnt > 1 && times[cnt % 3] - times[(cnt + 2) % 3] <= 60
                            && times[cnt % 3] - times[(cnt + 1) % 3] <= 60) {
                        ans.add(name);
                        add = true;
                    }
                    cnt++;
                }
            } else {
                add = false;
                who = name;
                cnt = 0;
                times[cnt++] = time;
            }
        }
        return ans;
    }

    private int time(String time) {
        return Integer.valueOf(time.substring(0, 2)) * 60 + Integer.valueOf(time.substring(3, 5));
    }

    public String[][] zip(String[] keyName, String[] keyTime) {
        int len = keyName.length;
        String[][] zip = new String[len][2];
        for (int i = 0; i < zip.length; i++) {
            zip[i][0] = keyName[i];
            zip[i][1] = keyTime[i];
        }
        return zip;
    }


}
