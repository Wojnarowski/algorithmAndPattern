package zuo.guide.before;

import java.util.Stack;

/**
 * 用两个栈实现一个队列，支持队列的基本操作 add  poll peek
 * 1.如果stackPush要往stackPop中压入数据，那么必须要把stackPush中的数据全部压入
 * 2.如果stackPop不为空，stackPush决不能向stackPop中压入数据
 */
public class TwoStackQueen {

    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStackQueen(Stack<Integer> stackPush,Stack<Integer> stackPop){
        this.stackPush=stackPush;
        this.stackPop=stackPop;
    }

    public void add(int pushInt){
        this.stackPush.push(pushInt);
    }

    public int poll(){
        if(stackPush.isEmpty()&&stackPop.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }else if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek(){
        if(stackPush.isEmpty()&&stackPop.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }else if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }


    public static void main(String[] args) {
        Stack<Integer> stackPush=new Stack<Integer>();
        Stack<Integer> stackPop=new Stack<Integer>();
        TwoStackQueen twoStackQueen =new TwoStackQueen(stackPush,stackPop);
        twoStackQueen.add(1);
        twoStackQueen.add(3);
        twoStackQueen.add(5);
        twoStackQueen.add(7);
        twoStackQueen.add(2);
        System.out.println(twoStackQueen.peek());
        twoStackQueen.add(9);
        System.out.println(twoStackQueen.peek());
        System.out.println(twoStackQueen.poll());
        twoStackQueen.add(10);
        System.out.println(twoStackQueen.poll());
    }
}
