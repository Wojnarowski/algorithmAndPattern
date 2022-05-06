package leetcode.everyday.commit2022.may;

/**
 * 933   最近的请求次数
 *
 * 写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 *
 * 请你实现 RecentCounter 类：
 *
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["RecentCounter", "ping", "ping", "ping", "ping"]
 * [[], [1], [100], [3001], [3002]]
 * 输出：
 * [null, 1, 2, 3, 3]
 *
 * 解释：
 * RecentCounter recentCounter = new RecentCounter();
 * recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
 * recentCounter.ping(100);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
 * recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
 * recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
 *  
 *
 * 提示：
 *
 * 1 <= t <= 109
 * 保证每次对 ping 调用所使用的 t 值都 严格递增
 * 至多调用 ping 方法 104 次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-recent-calls
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Solution_20220506_933 {


    class RecentCounter {

        class Node {
            // ls 和 rs 分别代表当前节点（区间）的左右子节点在 tr 的下标
            // val 代表在当前节点（区间）所包含的数的个数
            int ls, rs, val;
        }
        int N = (int)1e9, M = 800010, idx = 1;
        Node[] tr = new Node[M];
        void update(int u, int lc, int rc, int x, int v) {
            if (lc == x && rc == x) {
                tr[u].val += (rc - lc + 1) * v;
                return ;
            }
            lazyCreate(u);
            int mid = lc + rc >> 1;
            if (x <= mid) update(tr[u].ls, lc, mid, x, v);
            else update(tr[u].rs, mid + 1, rc, x, v);
            pushup(u);
        }
        int query(int u, int lc, int rc, int l, int r) {
            if (l <= lc && rc <= r) return tr[u].val;
            lazyCreate(u);
            int mid = lc + rc >> 1, ans = 0;
            if (l <= mid) ans = query(tr[u].ls, lc, mid, l, r);
            if (r > mid) ans += query(tr[u].rs, mid + 1, rc, l, r);
            return ans;
        }
        void lazyCreate(int u) {
            if (tr[u] == null) tr[u] = new Node();
            if (tr[u].ls == 0) {
                tr[u].ls = ++idx;
                tr[tr[u].ls] = new Node();
            }
            if (tr[u].rs == 0) {
                tr[u].rs = ++idx;
                tr[tr[u].rs] = new Node();
            }
        }
        void pushup(int u) {
            tr[u].val = tr[tr[u].ls].val + tr[tr[u].rs].val;
        }
        public int ping(int t) {
            update(1, 1, N, t, 1);
            return query(1, 1, N, t - 3000, t);
        }

    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
