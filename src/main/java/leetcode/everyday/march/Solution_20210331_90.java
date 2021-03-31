package leetcode.everyday.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * 通过次数77,233提交次数123,774
 *
 */
public class Solution_20210331_90 {

    /**
     * 回溯算法
     *   三部曲
     *       1.确定参数
     *       2.确定终止条件
     *       3.单层逻辑
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //特判
        if(nums == null){
            return new ArrayList<>();
        }
        //结果集
        List<List<Integer>>  ans = new ArrayList<>();
        //对数组元素进行排序，保证重复元素必相邻，方便后续剪枝
        Arrays.sort(nums);

        //记录已作选择（路径）
        List<Integer> track = new ArrayList<>();
        //调用回溯函数 TODO 1.确定参数
        backtrack(nums, 0, track,ans);
        return ans;
    }


    private void backtrack(int[] nums, int start, List<Integer> track, List<List<Integer>> ans) {
        //结果集中包含已选路径（部分子集），需对引用track进行拷贝
        ans.add(new ArrayList<>(track));
        //遍历数组
        //结束条件：i == nums.length时终止，遍历完全部数组元素
        for(int i = start; i < nums.length; i++){
            //同层剪枝：同一层的两条不同路径中加入的元素出现重复时（数组已排序） → 跳过当次循环
            if(i > start && nums[i] == nums[i - 1]){  // i-1元素的索引必须在start索引及之后位置，即i >= start + 1;
                continue;
            }
            //作出选择
            track.add(nums[i]);
            //递归调用回溯函数 → 进入决策树的下一层（第i + 1个数组元素）
            backtrack(nums, i + 1, track,ans);
            //撤销选择
            track.remove(track.size()-1);
        }
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(reverseBits(43261596)==964176192,"程序异常");

        System.out.println("-------------运行通过-------------");
    }
}
