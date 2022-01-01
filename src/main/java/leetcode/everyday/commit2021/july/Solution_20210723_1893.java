package leetcode.everyday.commit2021.july;

import org.springframework.util.Assert;

import java.util.BitSet;

/**
 *
 * 1893 检查是否区域内所有整数都被覆盖
 *
 *
 * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
 *
 * 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
 *
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * 输出：true
 * 解释：2 到 5 的每个整数都被覆盖了：
 * - 2 被第一个区间覆盖。
 * - 3 和 4 被第二个区间覆盖。
 * - 5 被第三个区间覆盖。
 * 示例 2：
 *
 * 输入：ranges = [[1,10],[10,20]], left = 21, right = 21
 * 输出：false
 * 解释：21 没有被任何一个区间覆盖。
 *  
 *
 * 提示：
 *
 * 1 <= ranges.length <= 50
 * 1 <= starti <= endi <= 50
 * 1 <= left <= right <= 50
 * 通过次数7,529提交次数12,535
 *
 *
 *
 *
 */
public class Solution_20210723_1893 {


    /**
     * 暴力
     * @param ranges
     * @param left
     * @param right
     * @return
     */
    public static boolean isCovered(int[][] ranges, int left, int right) {
//            for(int j=0;j<ranges.length;j++){
//                int min =ranges[j][0];
//                int max = ranges[j][ranges[j].length-1];
//                boolean result =false;
//                for(int i=left;i<=right;i++){
//                    if(i<min || i>max){
//                       continue;
//                    }
//                    else{
//                        result=true;
//                       break;
//                    }
//                }
//                if(!result){
//                    return false;
//                }
//                else{
//                    continue;
//                }
//
//            }
//
//
//        return true;

        BitSet bitSet = new BitSet();
        for (int[] range : ranges) {
            //将位图中的 range[0] ~ range[1] + 1（不包括）设置成1
            bitSet.set(range[0], range[1] + 1);
        }
        // 从left开始从位图中获取第一个为0的下标
        int i = bitSet.nextClearBit(left);
        return i > right;

    }



    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //int test[][] = new int[][]{{1,2},{3,4},{5,6}};
        //Assert.isTrue(isCovered(test,2,5)==true,"程序异常");


        int test[][] = new int[][]{{1,2}};
        Assert.isTrue(isCovered(test,1,50)==true,"程序异常");



        System.out.println("-------------运行通过-------------");
    }
}
