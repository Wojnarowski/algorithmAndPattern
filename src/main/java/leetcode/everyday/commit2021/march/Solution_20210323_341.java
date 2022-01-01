package leetcode.everyday.commit2021.march;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 *
 * 扁平化嵌套列表迭代器
 *
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 *
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 * 通过次数19,179提交次数28,319
 *
 *
 */
public class Solution_20210323_341 {

    public  class NestedIterator implements Iterator<Integer> {

        Deque<NestedInteger> stack = new ArrayDeque<>();
        public NestedIterator(List<NestedInteger> nestedList) {
            for (int i = nestedList.size()-1; i >= 0; --i) {
                stack.offerFirst(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return stack.pollFirst().getInteger();
        }

        @Override
        public boolean hasNext() {
            if(stack.isEmpty()){
                return false;
            }
            else{
                if(stack.peekFirst().isInteger()){
                    return  true;

                }
                else{
                    //弹出第一个,递归调用自己
                    List<NestedInteger> ni = stack.pollFirst().getList();
                    for (int i = ni.size() - 1; i >= 0; --i) {
                        stack.offerFirst(ni.get(i));
                    }
                    return hasNext();
                }
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"})==22,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
