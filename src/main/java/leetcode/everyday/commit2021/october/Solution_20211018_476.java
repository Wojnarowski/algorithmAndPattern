package leetcode.everyday.commit2021.october;

/**
 *q 476 数字的补数
 *
 * 给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * 示例 2：
 *
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *  
 *
 * 提示：
 *
 * 给定的整数 num 保证在 32 位带符号整数的范围内。
 * num >= 1
 * 你可以假定二进制数不包含前导零位。
 * 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同
 * 通过次数40,987提交次数58,126
 *
 *
 */
public class Solution_20211018_476 {


    public int findComplement(int num) {
        int s = -1;
        for (int i = 31; i >= 0; i--) {
            if (((num >> i) & 1) != 0) {
                s = i;
                break;
            }
        }
        int ans = 0;
        for (int i = 0; i < s; i++) {
            if (((num >> i) & 1) == 0) ans |= (1 << i);
        }
        return ans;
    }

    /**
     * 今天这道题乍看之下很简单，直接跟二进制全 1 的数异或即可：
     *
     * 比如：给定数字为 5 （101），跟 111 进行异或运算，结果为 010。
     *
     * 实则不然，因为计算机在存储 5 这个数字的时候是按照 32 位来进行存储的，应该为 00000000000000000000000000000101（下简写为00..00101），所以，跟 32 位全是 1 的数字异或之后，高位的那些 0 也会全部变成 1，最终的结果为 11111111111111111111111111111010，与题目给定的结果将不一致。
     *
     * 所以，我们需要换一种思路。
     *
     * 其实，我们只需要找到最高位的 1，将最高位的 1 所在的位置及比它低的位置全变成 1，再异或即可。
     *
     * 比如，给定数字为 5（00..00101），最高位的 1 是第三位，我们将第三位及比它低的位置全变成 1，即 00..00111，再进行异或就得到了 010 这个结果。
     *
     * 那么，如何找到最高位的 1，又如何将其及比它低的位置全变成 1 呢？
     *
     * 关于第一个问题：我们这里介绍一种非常简单高效的方式，每次找到最低位（最右边）的 1 并把它打掉（变成 0），最终找到最高位的 1。
     *
     * 关于第二个问题：我们只需要将最高位的 1 左移一位，再减 1，就可以得到最高位为 1 的位置及比它低的位置全是 1 的数字了。
     *
     * 比如，给定数字为 5（00..00101），我们第一次找到的 1 是 00.00001，把它打掉后数字变为 00..00100，然后，找到的第二个 1 是 00..00100，把这个 1 再打掉后数字变为 00..00000，所以，我们要找的最高位的 1 就是 00..00100 这个数字，把这个数字左移一位变成00..01000，再减 1 得到 00..00111，最后，再与原数字异或，得到 00..00010，完事儿。
     *
     * 关于溢出：题目约定了给定的数字为大于或等于 1 的 32 位数字，所以，32 位的最高位不会为 1，因此，不会溢出
     *
     * 作者：tong-zhu
     * 链接：https://leetcode-cn.com/problems/number-complement/solution/tong-ge-lai-shua-ti-la-jian-dan-gao-xiao-k0p9/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param num
     * @return
     */
    public int findComplement2(int num) {
        // 找到最高位的1，左移一位并-1，异或
        int highbit = 1;
        int x = num;
        while (x != 0) {
            // 找最低位（最右边）的 1
            highbit = x & (-x);
            // 打掉最低位（最右边）的1
            x = x & (x - 1);
        }

        return num ^ ((highbit << 1) - 1);
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{1,2,3,1};
        //Assert.isTrue(arrangeCoins(5)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
