package leetcode.everyday.commit2022.january;

import java.util.Arrays;

/**
 * 1996  游戏中弱角色的数量
 *
 * 你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。
 *
 * 如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attackj > attacki 且 defensej > defensei 。
 *
 * 返回 弱角色 的数量。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：properties = [[5,5],[6,3],[3,6]]
 * 输出：0
 * 解释：不存在攻击和防御都严格高于其他角色的角色。
 * 示例 2：
 *
 * 输入：properties = [[2,2],[3,3]]
 * 输出：1
 * 解释：第一个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
 * 示例 3：
 *
 * 输入：properties = [[1,5],[10,4],[4,3]]
 * 输出：1
 * 解释：第三个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
 *  
 *
 * 提示：
 *
 * 2 <= properties.length <= 105
 * properties[i].length == 2
 * 1 <= attacki, defensei <= 105
 * 通过次数20,052提交次数51,900
 * 请问您在哪类招聘中遇到此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 */
public class Solution_20220128_1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length, ans = 0;
        Arrays.sort(properties, (a, b)->{
            if (a[0] != b[0]) return b[0] - a[0];
            return b[1] - a[1];
        });
        for (int i = 0, max = properties[0][1]; i < n; ) {
            int j = i;
            while (j < n && properties[j][0] == properties[i][0]) {
                if (i != 0 && properties[j][1] < max) ans++;
                j++;
            }
            max = Math.max(max, properties[i][1]); i = j;
        }
        return ans;

    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
