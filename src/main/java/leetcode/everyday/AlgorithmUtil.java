package leetcode.everyday;

public class AlgorithmUtil {

    public static void sysoutDobbleArray(int [][] array){
        if(array == null){
            return ;
        }
        System.out.println("-----------------------------");
        for(int i=0;i<array.length;i++){ //0,1,2
            for(int j=0;j<array[i].length;j++){ //每一个一维数组的长度
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }


    public static void sysoutArray(int[] array) {
        System.out.println("-----------------------------");
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]+"\t");
        }
        System.out.println("-----------------------------");
    }
}
