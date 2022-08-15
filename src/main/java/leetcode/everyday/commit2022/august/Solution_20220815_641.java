package leetcode.everyday.commit2022.august;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 641 设计循环双端队列
 *
 * 设计实现双端队列。
 *
 * 实现 MyCircularDeque 类:
 *
 * MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
 * boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
 * boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
 * boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
 * int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
 * int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
 * boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
 * boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
 *  
 *
 * 示例 1：
 *
 * 输入
 * ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
 * [[3], [1], [2], [3], [4], [], [], [], [4], []]
 * 输出
 * [null, true, true, true, false, 2, true, true, true, 4]
 *
 * 解释
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 *  
 *  
 *
 * 提示：
 *
 * 1 <= k <= 1000
 * 0 <= value <= 1000
 * insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull  调用次数不大于 2000 次
 *
 *
 *
 */
public class Solution_20220815_641 {

    //存储数据的队列
    Deque<Integer> deque;
    //队列的最大容量
    int k;
    //目前队列的容量
    int size;


    public Solution_20220815_641(int k) {
        this.deque = new LinkedList<Integer>();
        this.k = k;
        this.size = 0;
    }

    public boolean insertFront(int value) {
        if (size < k){
            deque.addFirst(value);
            size++;
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (size < k){
            deque.addLast(value);
            size++;
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (size > 0){
            deque.removeFirst();
            size--;
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if (size > 0){
            deque.removeLast();
            size--;
            return true;
        }
        return false;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return deque.getFirst();
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return deque.getLast();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }

}
