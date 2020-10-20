package zuo.vip.class01;

import java.util.Arrays;

/**
 * 在有序array上找出满足<=value 的最右侧位置
 */
public class Code05_XOR {

    public static void main(String[] args) {
        int a =7;
        int b =8;
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println(a);
        System.out.println(b);
        System.out.println("-----------------");
        int [] array={1,3,5};
        System.out.println(array[0]);
        System.out.println(array[1]);
        swap(array,0,1);
        System.out.println(array[0]);
        System.out.println(array[1]);

    }

    private static void swap(int[] array, int i, int j) {
        array[i]=array[i]^array[j];
        array[j]=array[i]^array[j];
        array[i]=array[i]^array[j];

    }


}
