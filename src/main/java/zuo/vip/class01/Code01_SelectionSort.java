package zuo.vip.class01;

import zuo.vip.AlgorithmUtil;

/**
 * 选择排序
 */
public class Code01_SelectionSort {

    public static void main(String[] args) {
        int times =100;
        int maxSize = 100;
        int maxValue=100;
        boolean success=true;
        for(int i = 0;i<times;i++){
            System.out.println("当前第"+i+"次循环");
            int [] array1= AlgorithmUtil.generateRadomArray(maxSize ,maxValue);
            int [] array2=AlgorithmUtil.copyArray(array1);
            selectionSort(array1);
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

    public static void selectionSort(int [] array){
        if(array.length==0||array.length<2){
            return ;
        }
        for(int i=0;i<array.length-1;i++){
            // 最小值在哪个位置上  i～n-1
            int minIndex=i;
            for(int j=i+1;j<array.length;j++){
                minIndex=array[j]<array[minIndex]?j:minIndex;
            }
            AlgorithmUtil.swap(array,i,minIndex);
        }
    }

}
