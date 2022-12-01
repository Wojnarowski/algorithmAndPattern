package leetcode.everyday.commit2022.december;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1779. 找到最近的有相同 X 或 Y 坐标的点
 *
 */
public class Solution_20221201_1179 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minIndex = -1;
        int minJuLi = Integer.MAX_VALUE;
        for(int i=0;i<points.length;i++){
            if(x==points[i][0]||y==points[i][1]){ //有效点
                int res = Math.abs(x-points[i][0])+Math.abs(y-points[i][1]);
                if(res<minJuLi){
                    minJuLi = res;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
}
