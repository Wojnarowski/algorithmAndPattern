package leetcode.everyday.commit2022.june;

/**
 * 342    摆动排序 II
 *
 *
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * 示例 2：
 *
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 104
 * 0 <= nums[i] <= 5000
 * 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
 *  
 *
 * 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 *
 * 通过次数50,115提交次数124,497
 *
 *
 */


public class Solution_20220628_324 {
    int[] nums;
    int n;
    int qselect(int l, int r, int k) {
        if (l == r) return nums[l];
        int x = nums[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) swap(i, j);
        }
        int cnt = j - l + 1;
        if (k <= cnt) return qselect(l, j, k);
        else return qselect(j + 1, r, k - cnt);
    }
    void swap(int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
    int getIdx(int x) {
        return (2 * x + 1) % (n | 1);
    }

    public void wiggleSort(int[] _nums) {
        nums = _nums;
        n = nums.length;
        int x = qselect(0, n - 1, n + 1 >> 1);
        int l = 0, r = n - 1, loc = 0;
        while (loc <= r) {
            if (nums[getIdx(loc)] > x) swap(getIdx(loc++), getIdx(l++));
            else if (nums[getIdx(loc)] < x) swap(getIdx(loc), getIdx(r--));
            else loc++;
        }
    }


    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
