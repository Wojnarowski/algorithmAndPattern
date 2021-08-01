package zuo.greatoffer.class01;

import java.util.HashMap;

/**
 * @ClassName Code07_TargetSum
 * @Description TODO
 * @Author paul
 * @Date 2021/8/1 16:30
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
 *给定一个数组arr，你可以在每个数字之前决定+或者-
 * 但是必须所有数字都参与
 * 再给定一个数target，请问最后算出target的方法数是多少？
 *  leetcode 494题
 */
public class Code07_TargetSum {

    public static int findTargetSumWays1(int[] arr, int s) {
        return process1(arr, 0, s);
    }

    /**
     *  可以自由使用arr[index....]所有的数字！
     *  搞出rest这个数，方法数是多少？返回
     *   index == 7 rest = 13
     *    map "7_13" 256
     * @param arr
     * @param index
     * @param rest
     * @return
     */
    private static int process1(int[] arr, int index, int rest) {
        //没数了
        if(index==arr.length){
            return rest==0?1:0;
        }
        //还有数
        return process1(arr,index+1,rest-arr[index])+
                process1(arr,index+1,rest+arr[index]);
    }


    public static int findTargetSumWays2(int[] arr, int s) {
        return process2(arr, 0, s,new HashMap<>());
    }

    /**
     * @param arr
     * @param index
     * @param rest
     * @return
     */
    private static int process2(int[] arr, int index, int rest ,HashMap<Integer,HashMap<Integer, Integer>> dp) {
        if(dp.containsKey(index)&& dp.get(index).containsKey(rest)){
            return dp.get(index).get(rest);
        }
        // 否则，没命中！
        int ans=0;
        //没数了
        if(index==arr.length){
            return rest==0?1:0;
        }
        else{
            ans= process2(arr,index+1,rest-arr[index],dp)+
                    process2(arr,index+1,rest+arr[index],dp);
        }
        if(!dp.containsKey(index)){
            dp.put(index,new HashMap<>());
        }
        dp.get(index).put(rest, ans);
        return ans;
    }
}

