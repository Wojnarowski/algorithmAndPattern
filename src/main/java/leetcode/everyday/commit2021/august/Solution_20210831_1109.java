package leetcode.everyday.commit2021.august;


import java.util.*;

/**
 * 1109   航班预订统计
 *
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，其中 answer[i] 是航班 i 上预订的座位总数。
 *
 *  
 *
 * 示例 1：
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 * 示例 2：
 *
 * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
 * 输出：[10,25]
 * 解释：
 * 航班编号        1   2
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       15
 * 总座位数：      10  25
 * 因此，answer = [10,25]
 *  
 *
 * 提示：
 * 1 <= n <= 2 * 104
 * 1 <= bookings.length <= 2 * 104
 * bookings[i].length == 3
 * 1 <= firsti <= lasti <= n
 * 1 <= seatsi <= 104
 * 通过次数36,241提交次数67,817
 *
 *
 */

/**
 * 此处可以再总结一下（加粗字体为最佳方案）：
 *
 * 数组不变，区间查询：<前缀和>、树状数组、线段树；
 * 数组单点修改，区间查询：<树状数组>、线段树；
 * 数组区间修改，单点查询：<差分>、线段树；
 * 数组区间修改，区间查询：<线段树>。
 *
 */
public class Solution_20210831_1109 {


    /**
     * 暴力超时了
     * @param bookings
     * @param n
     * @return
     */
    public static  int[] corpFlightBookings(int[][] bookings, int n) {

        // key  为i value 为i对应最大
        Map<Integer, List<Integer>> map = new TreeMap<>();
        //行
        for(int i=0;i<bookings.length;i++){
            //列
            int left=bookings[i][0];
            int right=bookings[i][1];
            int value=bookings[i][2];
            for(int j=left;j<=right;j++){
                List<Integer> temp =map.getOrDefault(j,new ArrayList<>());
                temp.add(value);
                map.put(j,temp);
            }
        }

        int[] ans = new int[n];

        for(int i=1;i<=n;i++){
            List<Integer> value = map.get(i);
            if(value==null){
                ans[i-1]=0;
            }else{
                Integer tempValue=value.stream().mapToInt(Integer::byteValue).sum();
                ans[i-1]=tempValue;

            }
        }
        return ans;

    }

    /**
     * 暴力，可以通过
     * @param bookings
     * @param n
     * @return
     */
    public static  int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            for (int i = booking[0]; i <= booking[1]; i++) {
                ans[i - 1] += booking[2];
            }
        }
        return ans;

    }


    /**
     * 查分数组
     * https://leetcode-cn.com/problems/corporate-flight-bookings/solution/tong-ge-lai-shua-ti-la-yi-ti-liang-jie-t-0qse/
     * @param bookings
     * @param n
     * @return
     */
    public static  int[] corpFlightBookings3(int[][] bookings, int n) {
        // 先计算差分数组，再计算前缀和，注意下标的处理
        int[] arr = new int[n];
        //构建查分数组
        for (int[] booking : bookings) {
            arr[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                arr[booking[1]] -= booking[2];
            }
        }
        //计算前缀和
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }
        return arr;
    }


    public static void main(String[] args) {

        System.out.println("-------------开始执行-------------");
//        int[][] bookings= new int[][]{
//                {1,2,10},
//                {2,3,20},
//                {2,5,25}
//
//        };
        int[][] bookings= new int[][]{
                {2,3,30},
                {2,3,45},
                {2,3,15},
                {1,3,15},

        };
        int n=4;
        int [] ans = corpFlightBookings(bookings,n);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
        //Assert.isTrue(,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
