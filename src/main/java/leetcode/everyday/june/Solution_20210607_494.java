package leetcode.everyday.june;

/**
 *q 494 目标和
 *
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 *
 * 输入：nums = [1], target = 1
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 100
 *
 *
 */
public class Solution_20210607_494 {

    /**
     * DFS写法
     * 数据范围只有 2020，而且每个数据只有 +/-+/− 两种选择，因此可以直接使用 DFS 进行「爆搜」。
     *
     * 而 DFS 有「使用全局变量维护」和「接收返回值处理」两种形式。
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWaysDFS(int[] nums, int target) {
        return dfs(nums,target,0,0);
    }

    private int dfs(int[] nums, int target, int index, int sum) {
        if(index==nums.length){
            return sum==target?1:0;
        }
        int left=dfs(nums,target,index+1,sum+nums[index]);
        int right=dfs(nums,target,index+1,sum-nums[index]);
        return left + right;
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(removeElements(listNodeA1,6)==null,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
