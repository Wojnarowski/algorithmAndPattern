package leetcode.everyday.commit2022.october;

/**
 * 907. 子数组的最小值之和
 */
public class Solution_20221028_907 {

    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int[] stack = new int[arr.length];
        int top = 0;

        int[] left = new int[arr.length];
        int[] right = new int[arr.length];


        for (int i = 0; i < arr.length; i++){
            while(top != 0 && arr[stack[top - 1]] > arr[i]){
                top--;
            }
            if (top != 0){
                left[i] = stack[top - 1];
            } else{
                left[i] = -1;
            }
            stack[top++] = i;
        }

        top = 0;
        for (int i = arr.length - 1; i >= 0; i--){

            while(top != 0 && arr[stack[top - 1]] >= arr[i]){
                top--;
            }
            if (top != 0){
                right[i] = stack[top - 1];
            } else{
                right[i] = arr.length;
            }
            stack[top++] = i;
        }

        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = (ans + (long)(i - left[i]) * (right[i] - i) * arr[i]) % 1000000007;
        }

        return (int)(ans % 1000000007);

    }
}
