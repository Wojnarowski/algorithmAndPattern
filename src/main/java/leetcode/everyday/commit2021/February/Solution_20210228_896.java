package leetcode.everyday.commit2021.February;

/**
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。
 * 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 *
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 *  
 *
 * 示例 1：
 * 输入：[1,2,2,3]
 * 输出：true
 *
 *
 * 示例 2：
 * 输入：[6,5,4,4]
 * 输出：true
 *
 *
 *
 * 示例 3：
 * 输入：[1,3,2]
 * 输出：false
 *
 *
 *
 * 示例 4：
 * 输入：[1,2,4,5]
 * 输出：true
 *
 *
 *
 * 示例 5：
 * 输入：[1,1,1]
 * 输出：true
 *  
 *
 *
 */


public class Solution_20210228_896 {

    /**
     * 思路 1.暴力循环，根据第一个和第二个数比较 设置flag是递增还是递减，往后遍历
     * @param A
     * @return
     */
    public static boolean isMonotonic1(int[] A) {
        if(A==null || A.length<1){
            return false;
        }
        if(A.length==2 || A.length==1){
            return true;
        }
        Boolean compareResult = null;
        boolean result = true;
        for(int i=1;i<A.length;i++){
            if(A[i]-A[i-1]==0){
                continue;
            }
            else{
                if(compareResult!=null){
                   Boolean temp= A[i]-A[i-1]>=0?true:false;
                   if(compareResult==temp){
                       continue;
                   }else{
                       result=false;
                       break;
                   }
                }else{
                    compareResult=A[i]-A[i-1]>=0?true:false;
                }

            }
        }


        return result;
    }

    public static void main(String[] args) {
        int A[]=new int[]{1,2,2,3};
        int A2[]=new int[]{6,5,4,4};
        int A3[]=new int[]{1,3,2};
        int A4[]=new int[]{1,2,4,5};
        int A5[]=new int[]{1,1,1};
        System.out.println("-------------开始执行-------------");
        boolean result = isMonotonic1(A5);
        System.out.println(result);
        System.out.println("-------------运行通过-------------");
    }
}
