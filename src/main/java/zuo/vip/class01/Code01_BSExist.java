package zuo.vip.class01;


import java.util.Arrays;
import zuo.vip.AlgorithmUtil;

/**
 * 选择排序
 */
public class Code01_BSExist {

    public static void main(String[] args) {
        int times =1000000;
        int maxSize = 10;
        int maxValue=100;
        boolean success=true;
        for(int i = 0;i<times;i++){
            System.out.println("当前第"+i+"次循环");
            int [] array1= AlgorithmUtil.generateRadomArray(maxSize ,maxValue);
            Arrays.sort(array1);
            AlgorithmUtil.printArray(array1);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            System.out.println("value="+value);
            if (test(array1, value) != exist(array1, value)) {
                success = false;
                break;
            }
            System.out.println("----------------------------");
        }
        System.out.println(success ? "Nice!" : "Fucking fucked!");

    }


    // for test
    public static boolean test(int[] sortedArr, int num) {
        for(int cur : sortedArr) {
            if(cur == num) {
                return true;
            }
        }
        return false;
    }

    public static boolean exist(int [] sortedArray,int value){
        if(sortedArray.length==0||sortedArray==null){
            return false;
        }
        int L=0;
        int R=sortedArray.length-1;
        int mid =0 ;
        while(L<R){
            mid =L+( (R-L) >> 1);
            System.out.println("mid="+mid);
            if(sortedArray[mid]==value){
                return true;
            }else if(sortedArray[mid]>value){
                R=mid-1;
            }else{
                L=mid+1;
            }
        }
        return sortedArray[L] == value;
    }

}
