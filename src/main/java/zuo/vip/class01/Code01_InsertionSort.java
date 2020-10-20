package zuo.vip.class01;

import zuo.vip.AlgorithmUtil;

public class Code01_InsertionSort {

    public static void main(String[] args) {
        int times =10;
        int maxSize = 200000;
        int maxValue=2000;
        boolean success=true;
        for(int i = 0;i<times;i++){
            System.out.println("当前第"+i+"次循环");

            int [] array1= AlgorithmUtil.generateRadomArray(maxSize,maxValue);
            int [] array2=AlgorithmUtil.copyArray(array1);

            insertionSort(array1);
            AlgorithmUtil.comparator(array2);
            if(!AlgorithmUtil.isEqual(array1,array2)){
                success=false;
                AlgorithmUtil.printArray(array1);
                AlgorithmUtil.printArray(array2);
                break;
            }
        }
        System.out.println(success ? "Nice!" : "Fucking fucked!");

    }

    public static void insertionSort(int [] array){
        if(array.length==0||array.length<2){
            return ;
        }

        // 0~0 有序的
        // 0~i 想有序
        for(int i=1;i<array.length;i++){ //0到i有序
            for(int j=i-1;j>=0&&array[j]>array[j+1];j--){
                AlgorithmUtil.swap(array,j,j+1);
            }
        }
    }
}
