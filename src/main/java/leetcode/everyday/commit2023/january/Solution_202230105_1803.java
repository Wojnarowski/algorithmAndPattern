package leetcode.everyday.commit2023.january;

/**
 * 1803. 统计异或值在范围内的数对有多少
 */
public class Solution_202230105_1803 {

    public int countPairs(int[] nums, int low, int high) {
        return calc(nums, high) - calc(nums, low - 1);
    }

    public int calc(int[] nums, int border) {
        Trie root = new Trie();
        int ans = 0;
        for (int num : nums) {
            Trie u = root;
            int now = 0;
            int j;
            for (j = 16; j >= 0; -- j) {
                int cur = num >> j & 1;
                if (now + (1 << j) > border) {
                    if (u.children[cur] != null) {
                        u = u.children[cur];
                    } else {
                        break;
                    }
                } else if (now + (1 << j) <= border) {
                    if (u.children[cur] != null) {
                        ans += u.children[cur].cnt;
                    }
                    if (u.children[cur ^ 1] != null) {
                        u = u.children[cur ^ 1];
                        now += (1 << j);
                    } else {
                        break;
                    }
                }
            }
            if (j == -1) ans += u.cnt;
            u = root;
            for (j = 16; j >= 0; -- j) {
                int cur = num >> j & 1;
                if (u.children[cur] == null) {
                    u.children[cur] = new Trie();
                }
                u = u.children[cur];
                u.cnt ++ ;
            }
        }
        return ans;
    }
}

class Trie {
    Trie[] children;
    int cnt;
    Trie() {
        children = new Trie[2];
        cnt = 0;
    }

}
