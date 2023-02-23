package leetcode.everyday.commit2023.february;

import java.util.List;

/**
 * 1792. 最大平均通过率
 */
public class Solution_202230223_1238 {

    private static final List<Integer> LIST = new java.util.AbstractList<Integer>() {

        @Override
        public Integer get(int index) {
            return ARR[index];
        }

        @Override
        public int size() {
            return size;
        }
    };
    private static final int[] ARR = new int[0x10000];
    private static int size;

    public List<Integer> circularPermutation(int n, int start) {
        size = n = 1 << n;
        ARR[0] = start;
        while (--n > 0) {
            ARR[n] = start ^= n & -n;
        }
        return LIST;

    }
}
