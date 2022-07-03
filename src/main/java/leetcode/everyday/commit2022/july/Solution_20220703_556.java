package leetcode.everyday.commit2022.july;

import java.util.PriorityQueue;

/**
 * 556   下一个更大元素 III
 *
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 *
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：21
 * 示例 2：
 *
 * 输入：n = 21
 * 输出：-1
 *  
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 * 通过次数22,847提交次数66,690
 *
 *
 */


public class Solution_20220703_556 {

    public int nextGreaterElement(int n) {
        //2^32 < 10^10
        int[] t = new int[10];
        int l = t.length;
        int temp = n;
        //将n 变成数组
        while (l > 0 && temp > 0) {
            l--;
            t[l] = temp % 10;
            temp /= 10;
        }
        for (int i = t.length - 1; i > l; i--) {
            if (t[i] > t[i - 1]) {
                //找到前一个数小于后一个数的位置
                int tempIndex = i;
                //找到 i -1 后大于 t[i-1] 的最小数
                for (int j = i; j < t.length; j++) {
                    if (t[j] > t[i - 1] && t[j] < t[tempIndex]) {
                        tempIndex = j;
                    }
                }
                //将 i -1 后大于 t[i-1] 的最小数 和 t[i-1] 交换位置
                temp = t[i - 1];
                t[i - 1] = t[tempIndex];
                t[tempIndex] = temp;
                //获取从i开始的后面的元素
                int[] arr = new int[t.length - i];
                System.arraycopy(t, i, arr, 0, t.length - i);
                //进行从小到大排序
                Arrays.sort(arr);
                //然后依次赋值到 t 的 i - len 索引
                System.arraycopy(arr, 0, t, i, arr.length);
                break;
            }
        }
        //计算新的结果
        int res = 0;
        for (int i : t) {
            res = res * 10 + i;
        }
        return res <= n ? -1 : res;
    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
