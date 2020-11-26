package zuo.vip.class12;

import java.util.Stack;

/**
 * 不利用其他数据接口反转一个栈
 */
public class ReverseStackUsingRecursive {


    /**
     * 穿减去一个栈返回当前栈的最后一个值
     * @param stack
     * @return
     */
    public static  int f(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last=f(stack);
            stack.push(result);
            return last;
        }


    }


    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(5);
        test.push(4);
        test.push(6);
        /**
         * 栈中 数据 为
         * -------
         * 6     |
         * 5     |
         * 4     |
         * 3     |
         * 2     |
         * 1     |
         * -------
         */
        int  result = f(test);
        System.out.println("栈底元素="+result);
    }


}
