package leetcode.everyday.september;

/**
 *q 517  超级洗衣机
 *
 *
 *
 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。

 在每一步操作中，你可以选择任意 m (1 <= m <= n) 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。

 给定一个整数数组 machines 代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的 最少的操作步数 。如果不能使每台洗衣机中衣物的数量相等，则返回 -1 。



 示例 1：

 输入：machines = [1,0,5]
 输出：3
 解释：
 第一步:    1     0 <-- 5    =>    1     1     4
 第二步:    1 <-- 1 <-- 4    =>    2     1     3
 第三步:    2     1 <-- 3    =>    2     2     2
 示例 2：

 输入：machines = [0,3,0]
 输出：2
 解释：
 第一步:    0 <-- 3     0    =>    1     2     0
 第二步:    1     2 --> 0    =>    1     1     1
 示例 3：

 输入：machines = [0,2,0]
 输出：-1
 解释：
 不可能让所有三个洗衣机同时剩下相同数量的衣物。


 提示：

 n == machines.length
 1 <= n <= 104
 0 <= machines[i] <= 105
 通过次数5,276提交次数11,254
 */
public class Solution_20210929_517 {

    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int sum = 0;
        for (int i : machines) sum += i;
        if (sum % n != 0) return -1;
        int t = sum / n;
        int ls = 0, rs = sum;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            rs -= machines[i];
            // a 表示「从位置 i 左边的衣服移动到位置 i 右边的数量」
            // b 表示「从位置 i 右边的衣服移动到位置 i 左边的数量」
            int a = Math.max(i * t - ls, 0);
            int b = Math.max((n - i - 1) * t - rs, 0);
            ans = Math.max(ans, a + b);
            ls += machines[i];
        }
        return ans;

    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{1,2,3,1};
        //Assert.isTrue(findPeakElement(array)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
