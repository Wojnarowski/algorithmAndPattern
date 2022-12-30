package leetcode.everyday.commit2022.december;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 855. 考场就座
 *
 */
public class Solution_20221229_855 {


}

class ExamRoom {
    TreeSet<Integer> set;
    int n;

    public ExamRoom(int n) {
        this.n = n;
        set = new TreeSet<>();
    }

    public int seat() {
        if (set.size() == 0) {set.add(0); return 0;} //没有人时，一定返回0
        int pre = set.first(), ans = set.first(), idx = 0; //初始话为选择最左的长度
        for (int x : set) {
            if (ans < (x - pre) / 2) {
                ans = (x - pre) / 2;
                idx = (x + pre) / 2;
            }
            pre = x;
        }
        //最右进行判断
        int d = n - 1 - set.last();
        if (ans < d) {ans = d; idx = n - 1;}
        set.add(idx);
        return idx;
    }

    public void leave(int p) {
        set.remove(p);
    }
}

