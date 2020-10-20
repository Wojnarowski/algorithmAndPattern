package zuo.vip;

import java.util.Arrays;

public class AlgorithmUtil {

    /**
     * 比较数组大小
     * @param arr1
     * @param arr2
     * @return
     */
    public  static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;

    }

    /**
     * 系统比较器
     * @param array2
     */
    public static void comparator(int[] array2) {
        Arrays.sort(array2);
    }

    /**
     * 复制数组
     * @param array1
     * @return
     */
    public static int[] copyArray(int[] array1) {
        int [] array = new int[array1.length];
        System.arraycopy(array1,0,array,0,array1.length);
        return array;
    }

    /**
     * 打印数组
     * @param a
     */
    public static void printArray(int[] a) {
        if(a==null || a.length==0){
            return;
        }

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        System.out.println("###################");
    }

    /**
     * 数组两值交换
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array,int i, int j){
        //TODO 这种写法 如果有相同的数会有问题
//        array[i]=array[i] ^ array[j];
//        array[j]=array[i] ^ array[j];
//        array[i]=array[i] ^ array[j];
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    /**
     * 生成随机数组
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRadomArray(int maxSize,int maxValue){
        // Math.random()   [0,1)
        // Math.random() * N  [0,N)
        // (int)(Math.random() * N)  [0, N-1]
        int [] array= new int[(int) (Math.random()*(maxSize+1))];


        for(int i=0;i<array.length;i++){
            array[i]=(int)((maxValue+1)*Math.random())-(int)Math.random()*maxValue;
        }
        return array;
    }
}
