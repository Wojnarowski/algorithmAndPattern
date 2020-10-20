package zuo.guide.before;

import java.util.Stack;

/**
 * 一个栈中的元素为整形，现将该栈的栈顶到栈底进行从大到小排序，只许申请一个栈
 * 。除此之外，可以申请新的变量，但不能申请额外的数据结构。如何完成排序
 */
public class SortStackByStack {

    public static  void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()){
            int cur = stack.pop();
            while (!help.isEmpty()&&cur>help.peek()){
                stack.push(help.pop());
            }
            help.push(cur);

        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(5);
        stack.push(3);

        sortStackByStack(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }


}
