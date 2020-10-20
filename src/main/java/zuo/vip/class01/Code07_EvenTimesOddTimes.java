package zuo.vip.class01;

public class Code07_EvenTimesOddTimes {

    // arr中，只有一种数，出现奇数次
    public static void printOddTimesNum(int [] arr){
        int eor=0;
        if(arr.length==0){
            System.out.println(0);
        }
        for(int i=0;i<arr.length;i++){
            eor=eor^arr[i];
        }
        System.out.println(eor);
    }

    public static void main(String[] args) {
        int [] arr = {1,1,3,3,3,3,3,3,4};
        printOddTimesNum(arr);
    }
}
