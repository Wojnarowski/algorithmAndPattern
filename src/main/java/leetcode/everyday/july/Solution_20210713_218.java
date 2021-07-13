package leetcode.everyday.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 *q 218  天际线问题
 *
 * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。
 * 给你所有建筑物的位置和高度，请返回由这些建筑物形成的 天际线 。
 *
 * 每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：
 *
 * lefti 是第 i 座建筑物左边缘的 x 坐标。
 * righti 是第 i 座建筑物右边缘的 x 坐标。
 * heighti 是第 i 座建筑物的高度。
 * 天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。
 * 关键点是水平线段的左端点。列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。
 * 此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 *
 * 注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；
 * 三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 *
 *  
 *
 * 示例 1：
 * 输入：buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * 输出：[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * 解释：
 * 图 A 显示输入的所有建筑物的位置和高度，
 * 图 B 显示由这些建筑物形成的天际线。图 B 中的红点表示输出列表中的关键点。
 *
 *
 * 示例 2：
 * 输入：buildings = [[0,2,3],[2,5,3]]
 * 输出：[[0,3],[5,0]]
 *
 * 提示：
 * 1 <= buildings.length <= 104
 * 0 <= lefti < righti <= 231 - 1
 * 1 <= heighti <= 231 - 1
 * buildings 按 lefti 非递减排序
 *
 *
 */
public class Solution_20210713_218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        if(buildings==null||buildings.length==0) return res;
        //1.将所有操作进行排序，这些操作也就是每一个有效的点，之后在遍历这些操作的时候进行每个点是否是天际线的判定
        //思考每个operation需要哪些信息，1.出现的x坐标2.这个位置的高度3.能够标识这是个up还是一个down操作
        //将2，3合为一个信息，up为正数，down为负数
        int buildNum = buildings.length;
        int[][] allOprations = new int[buildNum<<1][2];
        for(int i = 0;i<buildNum;i++){
            allOprations[i<<1]=new int[]{buildings[i][0],buildings[i][2]};
            allOprations[(i<<1)|1]=new int[]{buildings[i][1],-buildings[i][2]};
        }
        //2.操作排序
        Arrays.sort(allOprations,(o1, o2)->o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0]);
        //3.遍历所有操作，用一个last记录一下之前的天际线，每个操作位置都看看能不能获得新的天际线
        int last = 0;
        TreeMap<Integer,Integer> mapHeightTimes = new TreeMap<>();//key=高度，value=出现的times
        for(int i = 0;i<allOprations.length;i++){
            int[] ops = allOprations[i];
            int height = ops[1]<0?-ops[1]:ops[1];
            int times = mapHeightTimes.getOrDefault(height,0);
            if(ops[1]<0){//down操作
                if(times ==1){
                    mapHeightTimes.remove(height);
                }else{
                    mapHeightTimes.put(height,times-1);
                }
            }else{//up操作
                mapHeightTimes.put(height,times+1);
            }
            //看看这个点是不是天际线,想要产生天际线高度必定是当前的高度，否则在之前就已经看出来了，所以不会出现重复收集的情况
            int curMaxHeight = mapHeightTimes.isEmpty() ? 0 : mapHeightTimes.lastKey();
            if(curMaxHeight !=last){
                res.add(Arrays.asList(ops[0],curMaxHeight));
                last = curMaxHeight;//此时这里作为天际线高度
            }
        }
        return res;

    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(majorityElement(new int[]{1,2,5,9,5,9,5,5,5})==5,"程序异常");
        //Assert.isTrue(majorityElement(new int[]{3,2})==-1,"程序异常");

        System.out.println("-------------运行通过-------------");
    }
}
