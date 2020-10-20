package zuo.guide.before;

import java.util.Stack;

public class MyStack01 {

    private Stack<Integer> stackData;

    private Stack<Integer> minData;

    public MyStack01(Stack stackData,Stack minData){
        this.stackData=stackData;
        this.minData=minData;
    }

    /**
     * 压栈
     * @param newNum
     */
    public void puch(int newNum){
        this.stackData.push(newNum);

        if(this.minData.isEmpty()){
            this.minData.push(newNum);
        }else if(this.getMin()>=newNum){
            this.minData.push(newNum);
        }
    }


    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        int value = this.stackData.pop();
        if(value==this.getMin()){
            this.minData.pop();
        }
        return value;
    }

    private int getMin() {
        if(this.minData.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        return this.minData.peek();
    }

}
