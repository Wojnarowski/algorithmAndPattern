package leetcode.everyday.commit2023.february;

import java.util.List;

/**
 * 1792. 最大平均通过率
 */
public class Solution_202230224_2357 {

    public int minimumOperations(int[] nums) {
        boolean[] ex = new boolean[100 + 5];
        for (int i : nums) ex[i] = true;

        // times： 操作数
        // sum： 经过 times 次总的减少数量
        int times = 0, sum = 0;
        for (int i = 0; i < ex.length; i++) {
            // i 存在 and 经过times删除操作还没有到0
            if(ex[i] && i - sum > 0){
                // 要删除当前元素必须再操作一次
                times++;
                // 累计总的减少数量
                sum += i - sum;
            }
        }

        return times;
    }
}
