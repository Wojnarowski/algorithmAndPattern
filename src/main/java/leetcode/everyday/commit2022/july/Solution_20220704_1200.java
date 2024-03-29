package leetcode.everyday.commit2022.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200  最小绝对差
 *
 * 给你个整数数组 arr，其中每个元素都 不相同。
 *
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * 示例 2：
 *
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * 示例 3：
 *
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 *  
 *
 * 提示：
 *
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 * 通过次数26,121提交次数37,193
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-absolute-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */


public class Solution_20220704_1200 {



    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int d = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i] - arr[i - 1];
            if (cur < d || cur == d) {
                if (cur < d) {
                    ans = new ArrayList<>();
                    d = cur;
                }
                List<Integer> nums = new ArrayList<>();
                nums.add(arr[i - 1]);
                nums.add(arr[i]);
                ans.add(nums);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
