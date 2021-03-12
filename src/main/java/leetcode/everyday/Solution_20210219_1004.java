package leetcode.everyday;

/**
 *
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1 
 *
 */


public class Solution_20210219_1004 {

//    public static int longestOnes(int[] A, int K) {
//        int cnt=0;
//        int pos=0;
//        int ans=0;
//        for(int i=0;i<A.length;i++){
//            if(A[i]==0)cnt++;
//            while(cnt>K){
//                if(A[pos]==0)cnt--;
//                pos++;
//            }
//            ans=Math.max(ans,i-pos+1);
//        }
//
//        return ans;
//    }

    public static int longestOnes2(int[] A, int k) {
       int max=0;
       for(int left=0,right=0;right<A.length;right++){
            //如果右指针为0
           if(A[right]==0){
                //还有没有剩余的0可以减
               if(k==0){
                    while (A[left] == 1){
                        left++;
                    }
                    left++;
               }
               else{
                k--;
               }
           }
//           else{
//               //右边界扩大继续循环
//               max = Math.max(max,right-left+1);
//           }
           max = Math.max(max,right-left+1);
       }
        return max;
    }

    public static int longestOnes3(int[] A, int K) {
        int max=0;int left =0;
        for(int right=0;right<A.length;right++){
            if(A[right]==0){
                K--;
            }
            while (K<0){
                if(A[left++]==0){
                    K++;
                }
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }

    public static void main(String[] args) {
        int [] a = new int[]{0,0,0,1,1,1,0,0,1,1,0,0,0,0,0};
        System.out.println(longestOnes3(a,1));
    }
}
