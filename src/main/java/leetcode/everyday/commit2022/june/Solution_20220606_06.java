package leetcode.everyday.commit2022.june;

import java.util.Random;
import java.util.TreeMap;

/**
 * 732    我的日程安排表 III
 *
 *
 * 当 k 个日程安排有一些时间上的交叉时（例如 k 个日程安排都在同一时间内），就会产生 k 次预订。
 *
 * 给你一些日程安排 [start, end) ，请你在每个日程安排添加后，返回一个整数 k ，表示所有先前日程安排会产生的最大 k 次预订。
 *
 * 实现一个 MyCalendarThree 类来存放你的日程安排，你可以一直添加新的日程安排。
 *
 * MyCalendarThree() 初始化对象。
 * int book(int start, int end) 返回一个整数 k ，表示日历中存在的 k 次预订的最大值。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
 * [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
 * 输出：
 * [null, 1, 1, 2, 3, 3, 3]
 *
 * 解释：
 * MyCalendarThree myCalendarThree = new MyCalendarThree();
 * myCalendarThree.book(10, 20); // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
 * myCalendarThree.book(50, 60); // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
 * myCalendarThree.book(10, 40); // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是 2 次预订。
 * myCalendarThree.book(5, 15); // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
 * myCalendarThree.book(5, 10); // 返回 3
 * myCalendarThree.book(25, 55); // 返回 3
 *  
 *
 * 提示：
 *
 * 0 <= start < end <= 109
 * 每个测试用例，调用 book 函数最多不超过 400次
 * 通过次数6,321提交次数9,500
 * 请问您在哪类招聘中遇到此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/my-calendar-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */


public class Solution_20220606_06 {

    TreeMap<Integer,int[]> times = new TreeMap<>();
    int ans = 0;

    public Solution_20220606_06() {

    }

    public int book(int start, int end) {
        end =end-1;
        while ((times.floorKey(start)!=null||times.ceilingKey(start)!=null)&&start<=end){
            boolean deal = false;
            if(times.floorKey(start)!=null){
                int prevStart = times.floorKey(start);
                int[] prevItem = times.get(prevStart);
                int prevEnd = prevItem[0];
                int prevTime = prevItem[1];
                if(prevEnd>=start){
                    deal = true;
                    if(start>prevStart)
                        times.put(prevStart,new int[]{start-1,prevTime});

                    if(end>prevEnd){
                        times.put(start,new int[]{prevEnd,prevTime+1});
                        start = prevEnd+1;
                        ans = Math.max(prevTime+1,ans);
                    }else{
                        times.put(start,new int[]{end,prevTime+1});
                        ans = Math.max(prevTime+1,ans);
                        if(end+1<=prevEnd){
                            times.put(end+1,new int[]{prevEnd,prevTime});
                        }
                        start = end+1;
                        break;
                    }
                }
            }

            if(times.ceilingKey(start)!=null){
                int nextStart = times.ceilingKey(start);
                int[] nextItem = times.get(nextStart);
                int nextEnd = nextItem[0];
                int nextTime = nextItem[1];
                if(nextStart<=end){
                    deal = true;
                    if(start<nextStart){
                        times.put(start,new int[]{nextStart-1,1});
                        ans = Math.max(1,ans);
                    }

                    if(end<=nextEnd){
                        times.put(nextStart,new int[]{end,nextTime+1});
                        if(end+1<=nextEnd){
                            times.put(end+1,new int[]{nextEnd,nextTime});
                        }
                        ans = Math.max(nextTime+1,ans);
                        start = end+1;
                        break;
                    }else{
                        times.put(nextStart,new int[]{nextEnd,nextTime+1});
                        ans = Math.max(nextTime+1,ans);
                        start = nextEnd+1;

                    }
                }
            }

            if(!deal){

                break;
            }
        }

        if(start<=end){
            times.put(start,new int[]{end,1});
            ans = Math.max(1,ans);
        }
        return ans;

    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
