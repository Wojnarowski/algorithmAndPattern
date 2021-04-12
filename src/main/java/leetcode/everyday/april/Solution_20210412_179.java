package leetcode.everyday.april;

import org.springframework.util.Assert;

import java.util.*;

/**
 *q 179 最大数
 *
 *
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 *
 *
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出："1"
 *
 * 示例 4：
 * 输入：nums = [10]
 * 输出："10"
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Solution_20210412_179 {


    public static String largestNumber(int[] nums) {
        if(nums==null || nums.length==0){
            return "";
        }
        String [] numsStr=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            numsStr[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(numsStr,(a,b)->{
            return (b+a).compareTo(a+b);
        });
        if(numsStr[0].charAt(0)=='0'){
            return "0";
        }

        StringBuilder stringBuilder =new StringBuilder();
        for(String str:numsStr){
            stringBuilder.append(str);
        }


        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(nthUglyNumber(10)==12,"程序异常");
        //Assert.isTrue(nthUglyNumber(1)==1,"程序异常");
        Assert.isTrue(largestNumber(new int[]{10,2}).equals("210"),"程序异常");
        Assert.isTrue(largestNumber(new int[]{3,30,34,5,9}).equals("9534330"),"程序异常");
        Assert.isTrue(largestNumber(new int[]{1}).equals("1"),"程序异常");
        Assert.isTrue(largestNumber(new int[]{10}).equals("10"),"程序异常");


        System.out.println("-------------运行通过-------------");
    }
}
