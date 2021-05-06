package leetcode.everyday.may;

/**
 *q 1720 解码异或后的数组
 *
 * 未知 整数数组 arr 由 n 个非负整数组成。
 *
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。
 * 例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 *
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 *
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：encoded = [1,2,3], first = 1
 * 输出：[1,0,2,1]
 * 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 * 示例 2：
 *
 * 输入：encoded = [6,2,7,3], first = 4
 * 输出：[4,2,0,7,4]
 *  
 *
 * 提示：
 *
 * 2 <= n <= 104
 * encoded.length == n - 1
 * 0 <= encoded[i] <= 105
 * 0 <= first <= 105
 * 通过次数21,202提交次数24,209
 * 请问您在哪类招聘中遇到此题？
 *
 *
 */
public class Solution_20210506_1720 {

    /**
     * 思路一：
     *  已知 encoded[i-1] = arr[i-1] XOR arr[i]，将等式两边同时「异或」上 arr[i-1]。可得：
     *
     * encoded[i-1] XOR arr[i-1] = arr[i-1] XOR arr[i] XOR arr[i-1]
     * 结合「性质三」和「性质一」，可化简「右式」得 encoded[i-1] XOR arr[i-1] = arr[i] XOR 0
     * 结合「性质二」，可化简「右式」得 encoded[i-1] XOR arr[i-1] = arr[i]
     *
     * @param encoded
     * @param first
     * @return
     */
    public int[] decode(int[] encoded, int first) {
        int len = encoded.length+1;
        int [] ans = new int[len];
        ans[0]=first;
        for(int i=1;i<len;i++){
            ans[i]=encoded[i-1]^ans[i-1];
        }
        return ans;

    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(judgeSquareSum(5)==true,"程序异常");
        System.out.println(2^2);
        System.out.println("-------------运行通过-------------");
    }
}
