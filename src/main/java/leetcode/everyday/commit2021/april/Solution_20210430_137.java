package leetcode.everyday.commit2021.april;

/**
 *q 137 只出现一次的数字
 *
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 *
 *
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 *  
 */
public class Solution_20210430_137 {

    /**
     * 思路就是异或
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res =0;
        for(int i=0;i<nums.length;i++){
            res^=nums[i];
        }
        return res;
    }



    /**
     * 思路就是异或
     * TODO 关注  https://leetcode-cn.com/problems/single-number-ii/solution/ti-yi-lei-jie-wei-yun-suan-yi-wen-dai-ni-50dc/
     * 上面的语言有些抽象，我们举个例子：
     *
     * 如果输入是：nums = [2,2,3,2]，那么它的各个元素对应的32位二进制数就是[00000000000000000000000000000010, 00000000000000000000000000000010, 00000000000000000000000000000011, 00000000000000000000000000000010]；
     * 接着，对这些二进制数的对应位进行求和，得到：[00000000000000000000000000000041]；
     * 对这个求和结果的每一位进行3的取模运算，得到：[00000000000000000000000000000011]；
     * 把上面的结果从二进制转换为十进制，就是：3。这就是我们的答案。
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
       int res=0;
       // 因为nums[i]是32位整数，
       for(int i=0;i<32;i++){
           // 所以针对每一位的对应二进制数值求和
           int sum=0;
           for(int num : nums){
               //提取从右往左第i位位置，将所有nums[i]，二进制下的第i位数值进行求和
                sum+=((num>>i)&1);
           }
           if (sum % 3 == 1) { // 如果没办法被3整除，那么说明落单的那个数的第i位是1不是0
               res |= (1 << i);
           }
       }
        return res; // 输出结果
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(judgeSquareSum(5)==true,"程序异常");
        System.out.println(2^2);
        System.out.println("-------------运行通过-------------");
    }
}
