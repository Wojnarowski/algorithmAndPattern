package leetcode.everyday.commit2021.may;

/**
 *q 1734 解码异或后的排列
 *
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 *
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 *
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * 示例 2：
 *
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 *  
 *
 * 提示：
 *
 * 3 <= n < 105
 * n 是奇数。
 * encoded.length == n - 1
 *
 *
 */
public class Solution_20210511_1734 {

    public int[] decode(int[] encoded) {
        int n=encoded.length;
        int [] perm = new int[n+1];
        int ABCDE = 0; // 初始化，这个变量用于存放perm中所有数值进行异或的结果
        for (int i = 1; i <= n + 1; i++) // perm中所有数值进行异或
            ABCDE ^= i;
        int BCDE = 0; // 为了得到perm的第一个数值，需要初始化一个“BCDE”
        for (int i = 1; i < n; i += 2) //  “BCDE”的求值，就是encoded中从1开始，步长为2地取值进行异或的结果
            BCDE ^= encoded[i];
        perm[0] = ABCDE ^ BCDE;  // 得到第一个数A
        for (int i = 1; i <= n; i++)
            perm[i] = perm[i - 1] ^ encoded[i - 1]; // 此时，本题转换为力扣1720
        return perm;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(judgeSquareSum(5)==true,"程序异常");
        System.out.println(2^2);
        System.out.println("-------------运行通过-------------");
    }
}
