package leetcode.everyday.commit2023.february;

/**
 * 1792. 最大平均通过率
 */
public class Solution_202230221_1326 {

    public int minTaps(int n, int[] ranges) {
        int[] rightest = new int[n + 1];    // 最远右端点数组
        for(int i = 0; i <= n; i++){
            if(i > ranges[i]){
                // 左端点大于0，直接更新左端点的最右端点
                rightest[i - ranges[i]] = i + ranges[i];
            }else{
                // 左端点小于等于0都视为端点0，更新0端点的最右端点
                rightest[0] = Math.max(rightest[0], i + ranges[i]);
            }
        }
        int curRightest = 0;
        int nextRightest = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            nextRightest = Math.max(nextRightest, rightest[i]); // 更新下一个可达最远右端点
            if(i == curRightest){   // 到达当前右端点
                if(nextRightest <= i){  // 下一个最远右端点小于等于等于当前右端点，无法灌溉更远，返回-1
                    return -1;
                }
                // 可以灌溉更远，更新当前右端点，同时使用的水龙头数+1
                curRightest = nextRightest;
                count++;
            }
        }
        return count;
    }
}
