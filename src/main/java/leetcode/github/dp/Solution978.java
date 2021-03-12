package leetcode.github.dp;

/**
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：

 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。

 返回 A 的最大湍流子数组的长度。


  

 示例 1：
 输入：[9,4,2,10,7,8,8,1,9]
 输出：5
 解释：(A[1] > A[2] < A[3] > A[4] < A[5])


 示例 2：
 输入：[4,8,12,16]
 输出：2


 示例 3：
 输入：[100]
 输出：1
  

 提示：

 1 <= A.length <= 40000
 0 <= A[i] <= 10^9

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution978 {

    public static void main(String[] args) {
        //int [] arr = new int[] {9,4,2,10,7,8,8,1,9};
        //int [] arr = new int[] {4,8,12,16};
        int [] arr = new int[] {100};
        System.out.println(maxTurbulenceSize(arr));

    }

    public static int maxTurbulenceSize(int [] arr){
        if(arr==null || arr.length==0){
            return 0;
        }
        int n = arr.length;
        if(arr.length<=1){
            return n;
        }
        if(arr.length==2){
            return arr[1] == arr[0]?1:2;
        }

        //动态规划数组
        int [] dp = new int [n];
        //赋初值
        dp[0]=1;
        dp[1]=arr[1] == arr[0]?1:2;

        int ans =0;
        for(int i=2;i<n;i++){
            //dp的初始状态与 arr[i] 和 arr[i-1] 是否相关
            dp[i]=arr[i] ==arr[i-1]?1:2;
            //判断湍流的条件 arr[i] 和 arr[i-1] 和 arr[i-2] 相关
          if((arr[i-1]>arr[i] && arr[i-1]>arr[i-2]) || (arr[i-1]<arr[i] && arr[i-1]<arr[i-2])){
              dp[i]=dp[i-1]+1;
          }
          ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
