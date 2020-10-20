package zuo.vip.class01;


import zuo.vip.AlgorithmUtil;

/**
 * 冒泡排序
 */
public class Code01_BubbleSort {

    public static void main(String[] args) {
        int times =10000;
        int maxSize = 100;
        int maxValue=100;
        boolean success=true;
        for(int i = 0;i<times;i++){
            System.out.println("当前第"+i+"次循环");

            int [] array1= AlgorithmUtil.generateRadomArray(maxSize,maxValue);
            int [] array2=AlgorithmUtil.copyArray(array1);

            bubbleSort(array1);
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

    public static void bubbleSort(int [] array){
        if(array.length==0||array.length<2){
            return ;
        }
        // 0 ~ N-1
        // 0 ~ N-2
        // 0 ~ N-3
        for(int i=array.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(array[j+1]<array[j]){
                    AlgorithmUtil.swap(array,j,j+1);
                }
            }
        }
    }


}
