package zuo.vip.class01;

import zuo.vip.AlgorithmUtil;

import java.util.Arrays;

/**
 * 选择排序
 */
public class Code05_BSNearLeft {

    public static void main(String[] args) {
        int times =10;
        int maxSize = 10;
        int maxValue=100;
        boolean succeed=true;
        for(int i = 0;i<times;i++){

            int [] array1= AlgorithmUtil.generateRadomArray(maxSize ,maxValue);
            Arrays.sort(array1);
            //AlgorithmUtil.printArray(array1);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            System.out.println("------------------------");
            System.out.println("当前第"+i+"次循环");
            System.out.println("value="+value);
            AlgorithmUtil.printArray(array1);
            int testResult = test(array1, value);
            int nearLeftResult = nearLeft(array1, value);
            System.out.println("nearLeftResult="+nearLeftResult);
            System.out.println("------------------------");
            if (testResult!=nearLeftResult) {
                AlgorithmUtil.printArray(array1);
                System.out.println(value);
                System.out.println(test(array1, value));
                System.out.println(nearLeft(array1, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }



    // for test
    public static int test(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 在arr上，找满足>=value的最左位置
     * @param sortedArray
     * @param value
     * @return
     */
    public static int nearLeft(int [] sortedArray, int value){
//        if(sortedArray.length==0||sortedArray==null){
//            return 0;
//        }
        int L=0;
        int R=sortedArray.length-1;
        int index=-1;
        while(L<=R){
            int mid =L+( (R-L) >> 1);
            //System.out.println("mid="+mid);
            if(sortedArray[mid]>=value){
                index=mid;
                R=mid-1;
            }else{
                L=mid+1;
            }
        }
        return index;
    }

}
