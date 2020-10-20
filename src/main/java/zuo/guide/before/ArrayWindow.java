package zuo.guide.before;


import zuo.vip.AlgorithmUtil;

import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 */
public class ArrayWindow {



    /**
     * {4,3,5,4,3,3,6,7}  窗口大小为3
     */

    public static int []  getMaxArrayWindow(int array[],int w){
        if(array.length==0||array.length<w||w<1){
            return null;
        }
        LinkedList<Integer> qmax= new LinkedList<Integer>();
        //存放窗口最大值数组8
        int [] res = new int[array.length-w+1];
        int index=0;
        for(int i=0;i<array.length;i++){
            while(!qmax.isEmpty() && array[qmax.peekLast()]<=array[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekFirst()==i-w){
                qmax.pollFirst();
            }
            if(i>=w-1){
                res[index++]=array[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int windowSize =3;
//        int [] array1= {4,3,5,4,3,3,6,7};
        int windowSize =2;
        int [] array1= {4,3,5};
        //AlgorithmUtil.printArray(array1);
        int [] res = getMaxArrayWindow(array1,windowSize);
        AlgorithmUtil.printArray(res);


    }
}
