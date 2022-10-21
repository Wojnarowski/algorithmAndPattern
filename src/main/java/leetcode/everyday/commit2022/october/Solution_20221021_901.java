package leetcode.everyday.commit2022.october;

/**
 * 901. 股票价格跨度
 */
public class Solution_20221021_901 {

    static int N = 10010, len = 100, idx = 0;
    static int[] nums = new int[N], region = new int[N / len + 10];

    public Solution_20221021_901() {
        for (int i = 0; i <= getIdx(idx); i++) region[i] = 0;
        idx = 0;
    }

    int getIdx(int x) {
        return (x - 1) / len + 1;
    }
    int query(int price) {
        int ans = 0, loc = getIdx(idx), left = (loc - 1) * len + 1, right = idx;
        while (loc >= 1 && region[loc] <= price) {
            ans += right - left + 1;
            loc--; right = left - 1; left = (loc - 1) * len + 1;
        }
        for (int i = right; loc >= 1 && i >= left && nums[i] <= price; i--) ans++;
        return ans;
    }
    public int next(int price) {
        nums[++idx] = price;
        int loc = getIdx(idx);
        region[loc] = Math.max(region[loc], price);
        return query(price);
    }

}
