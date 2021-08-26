package leetcode.everyday.august;


import org.springframework.util.Assert;

import java.util.*;

/**
 *881  救生艇
 *
 *第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 *
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 *
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * 示例 2：
 *
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * 示例 3：
 *
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 * 提示：
 *
 * 1 <= people.length <= 50000
 * 1 <= people[i] <= limit <= 30000
 * 通过次数22,781提交次数45,241
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/boats-to-save-people
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 */


public class Solution_20210826_881 {

    /**
     * 贪心+双指针  最重的和最轻的一起上船 如果走不了最终的先走，请的等下一个重的组合
     * @param people
     * @param limit
     * @return
     */
    public static  int numRescueBoats(int[] people, int limit) {
        int count =0;
        int left=0,right=people.length-1;
        Arrays.sort(people);

        while(left<=right){
            // 剩余人中最重和最轻的人可以一起上船
            if (people[left] + people[right] <= limit) {
                left++;
            }
            //无论只能让剩余人中最重的人上船，还是能带多一个最轻的人，当前最重的人都会上船
            right--;
            count++;
        }
        return count;
    }


    public static void main(String[] args) {

        System.out.println("-------------开始执行-------------");
        int [] people=new int[]{1,1,4};
        int limit=6;
        Assert.isTrue(numRescueBoats(people,limit)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
