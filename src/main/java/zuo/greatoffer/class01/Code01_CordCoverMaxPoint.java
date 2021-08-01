package zuo.greatoffer.class01;

import java.util.Arrays;

/**
 * @ClassName Code01_CordCoverMaxPoint
 * @Description TODO
 * @Author paul
 * @Date 2021/7/30 11:07
 * Vertion 1.0
 * -------------------------------------------------------------_ooOoo_
 * ------------------------------------------------------------o8888888o
 * ------------------------------------------------------------88"-.-"88
 * ------------------------------------------------------------(|--_--|)
 * ------------------------------------------------------------O\--=--/O
 * ---------------------------------------------------------____/`---'\____
 * -------------------------------------------------------.'--\\|-----|//--`.
 * ------------------------------------------------------/--\\|||--:--|||//--\
 * -----------------------------------------------------/--_|||||--:--|||||---\
 * -----------------------------------------------------|---|-\\\-----///-|---|
 * -----------------------------------------------------|-\_|--''\---/''--|---|
 * -----------------------------------------------------\--.-\__--`-`--___/-.-/
 * ---------------------------------------------------___`.-.'--/--.--\--`.-.-__
 * ------------------------------------------------.""-'<--`.___\_<|>_/___.'-->'"".
 * -----------------------------------------------|-|-:--`--\`.;`\-_-/`;.`/---`-:-|-|
 * -----------------------------------------------\--\-`-.---\_-__\-/__-_/---.-`-/--/
 * ---------------------------------------======`-.____`-.___\_____/___.-`____.-'======
 * -------------------------------------------------------------`=---='
 * ---------------------------------------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * -----------------------------------------------------佛祖保佑--------永无BUG
 *
 * 给定一个有序数组arr，代表坐落在X轴上的点
 * 给定一个正数K，代表绳子的长度
 * 返回绳子最多压中几个点？
 * 即使绳子边缘处盖住点也算盖住
 */
public class Code01_CordCoverMaxPoint {

    /**
     * 绳子最右端在一个点上，减去绳子长度，然后将之间的点进行二分
     * @param arr
     * @param L
     * @return
     */
    public static int maxPoint1(int[] arr, int L) {
        int ans =1;
        for(int i=0;i<arr.length;i++){
            int nearest=nearestIndex(arr,i,arr[i]-L);
            ans =Math.max(ans,i-nearest+1);
        }
        return ans;
    }

    private static int nearestIndex(int[] arr, int R, int value) {
        int L=0;
        int index =R;
        while (L<=R){
            int mid = L+((R - L) >> 1);
            if(arr[mid] >= value){
                index=mid;
                R=mid-1;
            }else{
                L=mid+1;
            }
        }
        return index;
    }

    /**
     * 窗口解决
     * @param arr
     * @param L
     * @return
     */
    public static int maxPoint2(int[] arr, int L) {

        int left=0;
        int right=0;
        int N=arr.length;
        int max=0;
        while(left<N){
            while(right<N && arr[right]-arr[left]<=L){
                right++;
            }
            max=Math.max(max,right-(left++));
        }
        return max;
    }


    // for test
    public static int test(int[] arr, int L) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int pre = i - 1;
            while (pre >= 0 && arr[i] - arr[pre] <= L) {
                pre--;
            }
            max = Math.max(max, i - pre);
        }
        return max;
    }

    // for test
    public static int[] generateArray(int len, int max) {
        int[] ans = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * max);
        }
        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int len = 100;
        int max = 1000;
        int testTime = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int L = (int) (Math.random() * max);
            int[] arr = generateArray(len, max);
            int ans1 = maxPoint1(arr, L);
            int ans2 = maxPoint2(arr, L);
            int ans3 = test(arr, L);
            if (ans1 != ans2 || ans2 != ans3) {
                System.out.println("oops!");
                break;
            }
        }
    }


}

