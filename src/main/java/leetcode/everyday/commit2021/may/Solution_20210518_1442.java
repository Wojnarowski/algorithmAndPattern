package leetcode.everyday.commit2021.may;

import java.util.ArrayList;
import java.util.List;

/**
 *q 1442 形成两个异或相等数组的三元组数目
 *
 * 给你一个整数数组 arr 。
 *
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 *
 * a 和 b 定义如下：
 *
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 *
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [2,3,1,6,7]
 * 输出：4
 * 解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
 * 示例 2：
 *
 * 输入：arr = [1,1,1,1,1]
 * 输出：10
 * 示例 3：
 *
 * 输入：arr = [2,3]
 * 输出：0
 * 示例 4：
 *
 * 输入：arr = [1,3,5,7,9]
 * 输出：3
 * 示例 5：
 *
 * 输入：arr = [7,11,12,9,5,2,7,17,22]
 * 输出：8
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 300
 * 1 <= arr[i] <= 10^8
 * 通过次数11,211提交次数14,991
 *
 *
 */
public class Solution_20210518_1442 {


    public int countTriplets(int[] arr) {
        int len =arr.length;
        int ans =0;
        List<List<String>>  ansList = new ArrayList<>();
        for(int i=0;i<len;i++){
            int temp =arr[i];
            for(int k=i+1;k<len;k++){
                temp^=arr[k];
                if(temp==0){
                   ans+=k-i;
                }
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(findMaximumXOR(new int[]{3,10,5,25,2,8})==28,"程序异常");
        //xorQueries(new int[]{1,3,4,8},new int [][]{{0,1},{1,2},{0,3},{3,3}});
        System.out.println("-------------运行通过-------------");
    }
}
