package leetcode.everyday.commit2021.march;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 *
 * 实现 MyHashMap 类：
 *
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * 输出：
 * [null, null, null, 1, -1, null, 1, null, -1]
 *
 * 解释：
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
 * myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
 * myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
 * myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
 * myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 *  
 *
 * 提示：
 *
 * 0 <= key, value <= 106
 * 最多调用 104 次 put、get 和 remove 方法
 *  
 *
 * 进阶：你能否不使用内置的 HashMap 库解决此问题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashmap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution_20210314_706 {

    class Pair{
        private Integer key;

        private Integer value;

        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }

    private static final int BASE =769;

    private LinkedList<Pair>[] data;


    class MyHashMap {

        /** Initialize your data structure here. */
        public MyHashMap() {
            data = new LinkedList[BASE];
            for(int i=0;i< BASE;i++){
                data[i]=new LinkedList();
            }

        }

        public void put(int key, int value) {
            int h= hash(key);
            Iterator<Pair> iterator =data[h].iterator();
            while(iterator.hasNext()){
                Pair element = iterator.next();
                if(element.getKey()==key){
                    element.setValue(value);
                    return ;
                }
            }
            data[h].offerLast(new Pair(key,value));

        }

        private int hash(int key) {
            return key % BASE;
        }

        public int get(int key) {
            int h= hash(key);
            Iterator<Pair> iterator =data[h].iterator();
            while(iterator.hasNext()){
                Pair element = iterator.next();
                if(element.getKey()==key){
                    return  element.getValue();
                }
            }
            return -1;
        }

        public void remove(int key) {
            int h= hash(key);
            Iterator<Pair> iterator =data[h].iterator();
            while(iterator.hasNext()){
                Pair element = iterator.next();
                if(element.getKey()==key){
                    data[h].remove(element);
                    return;
                }
            }
        }


    }
    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(isValidSerialization("9,#,#,1")==false,"程序异常");
        System.out.println("-------------运行通过-------------");


    }
}
