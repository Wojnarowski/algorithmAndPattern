package zuo.guide.maxMinusMinGeNum;

import java.util.LinkedList;

/**
 *给定数组 ar和整数num，共返回有多少个子数组满足如下情况∶max(arr[i.j])-min(ar[i.j])<=num 
 * max（ar【i.jJ表示子数组anr【i.】中的最大值，
 * min（ar【.jJ）表示子数组an【-】中的最小值。
 * 【要求】 如果数组长度为N，请实现时间复杂度为O（N）的解法。【难度】 校 ★★★☆【解答】
 */
public class Client {

    public int getNum(int [] arr,int num){
        if(arr.length==0 || arr==null){
            return 0;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        LinkedList<Integer> qmin = new LinkedList<Integer>();
        int i=0;
        int j=0;
        int res = 0;
        while(i<arr.length){
            while(j<arr.length){
                while(!qmin.isEmpty() && arr[qmin.peekLast()]>=arr[j]){
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]){
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if(arr[qmax.getFirst()]-arr[qmin.getFirst()]>num){
                    break;
                }
                j++;
            }
            if(qmin.peekFirst()==i){
                qmin.pollFirst();
            }
            if(qmax.peekFirst()==i){
                qmax.pollFirst();
            }
            res+=j-i;
            i++;
        }
        return res;
    }
}
