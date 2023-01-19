package leetcode.everyday.commit2023.january;

import java.util.*;

/**
 * 1825. 求出 MK 平均值
 */
public class Solution_202230118_1825 {
    // 这几个TreeMap的组成都是 num : cnt(元素：该元素出现的次数）
    // loMap表示最小的k个元素的集合，hiMap表示最大的k个元素的集合，midMap表示其他 m - 2k 个元素的集合
    private TreeMap<Integer, Integer> loMap;
    private TreeMap<Integer, Integer> midMap;
    private TreeMap<Integer, Integer> hiMap;
    // 用来存储所有添加的元素
    private Queue<Integer> que;
    private int m, k;
    // 表示midMap中所有元素的和
    private long sum;
    // 分别表示loMap 和 hiMap中的元素个数
    private int loSize, hiSize;


    public Solution_202230118_1825(int m, int k) {
        loMap = new TreeMap<>();
        midMap = new TreeMap<>();
        hiMap = new TreeMap<>();
        que = new ArrayDeque<>();
        this.m = m;
        this.k = k;
        sum = 0;
        loSize = 0;
        hiSize = 0;
    }

    public void addElement(int num) {
        que.offer(num);
        if (loMap.isEmpty() || num <= loMap.lastKey()) {
            loMap.merge(num, 1, Integer::sum);
            ++loSize;
        } else if (hiMap.isEmpty() || num >= hiMap.firstKey()) {
            hiMap.merge(num, 1, Integer::sum);
            ++hiSize;
        } else {
            midMap.merge(num, 1, Integer::sum);
            sum += num;
        }
        // 保持que的大小一直小于等于m
        if (que.size() > m) {
            int x = que.poll();
            if (loMap.containsKey(x)) {
                if (loMap.merge(x, -1, Integer::sum) == 0) loMap.remove(x);
                --loSize;
            } else if (hiMap.containsKey(x)) {
                if (hiMap.merge(x, -1, Integer::sum) == 0) hiMap.remove(x);
                --hiSize;
            } else {
                if (midMap.merge(x, -1, Integer::sum) == 0) midMap.remove(x);
                sum -= x;
            }
        }
        // loMap中元素个数大于k，则这么处理
        while (loSize > k) {
            int x = loMap.lastKey();
            if (loMap.merge(x, -1, Integer::sum) == 0) loMap.remove(x);
            midMap.merge(x, 1, Integer::sum);
            sum += x;
            --loSize;
        }
        // hiMap中元素个数大于k，则这么处理
        while (hiSize > k) {
            int x = hiMap.firstKey();
            if (hiMap.merge(x, -1, Integer::sum) == 0) hiMap.remove(x);
            midMap.merge(x, 1, Integer::sum);
            sum += x;
            --hiSize;
        }
        // loMap中元素个数小于k，且midMap不为空，则这么处理
        while (loSize < k && !midMap.isEmpty()) {
            int x = midMap.firstKey();
            if (midMap.merge(x, -1, Integer::sum) == 0) midMap.remove(x);
            loMap.merge(x, 1, Integer::sum);
            sum -= x;
            ++loSize;
        }
        // hiMap中元素个数小于k，且midMap不为空，则这么处理
        while (hiSize < k && !midMap.isEmpty()) {
            int x = midMap.lastKey();
            if (midMap.merge(x, -1, Integer::sum) == 0) midMap.remove(x);
            hiMap.merge(x, 1, Integer::sum);
            sum -= x;
            ++hiSize;
        }
    }

    public int calculateMKAverage() {
        if (que.size() < m) return -1;
        return (int) (sum / (m - 2 * k));
    }

}
