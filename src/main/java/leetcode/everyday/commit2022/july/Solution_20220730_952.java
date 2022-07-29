package leetcode.everyday.commit2022.july;

import java.util.HashMap;
import java.util.Map;

/**
 * 593     有效的正方形
 *
 *
 * 给定一个由不同正整数的组成的非空数组 nums ，考虑下面的图：
 *
 * 有 nums.length 个节点，按从 nums[0] 到 nums[nums.length - 1] 标记；
 * 只有当 nums[i] 和 nums[j] 共用一个大于 1 的公因数时，nums[i] 和 nums[j]之间才有一条边。
 * 返回 图中最大连通组件的大小 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：nums = [4,6,15,35]
 * 输出：4
 * 示例 2：
 *
 *
 *
 * 输入：nums = [20,50,9,63]
 * 输出：2
 * 示例 3：
 *
 *
 *
 * 输入：nums = [2,3,6,7,4,12,21,39]
 * 输出：8
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 105
 * nums 中所有值都 不同
 *
 *
 */


public class Solution_20220730_952 {

    public int largestComponentSize(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        UnionSet set = new UnionSet(nums.length);
        Map<Integer, Integer> factorToIdx = new HashMap<>();//因子对应的下标
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int sqrtM = (int) Math.sqrt(nums[i]);
            for (int factor = 2; factor <= sqrtM; factor++) {
                if (nums[i] % factor == 0) {
                    if (factorToIdx.containsKey(factor)) {
                        set.union(i, factorToIdx.get(factor));
                    } else factorToIdx.put(factor, i);
                    if (factorToIdx.containsKey(nums[i] / factor)) {
                        set.union(i, factorToIdx.get(nums[i] / factor));
                    } else factorToIdx.put(nums[i] / factor, i);
                }
            }
            //自己可能作为因子
            if(factorToIdx.containsKey(nums[i])){
                set.union(i,factorToIdx.get(nums[i]));
            }else
                factorToIdx.put(nums[i], i);
        }
        return set.maxSize;

    }

    public  class UnionSet {
        int[] parents;
        int[] sizes;
        int[] help;//用来存查父的时候走过的路径
        int maxSize = 1;
        public UnionSet(int length) {
            parents = new int[length];
            sizes = new int[length];
            help = new int[length];
            for (int i = 0; i < length; i++) {
                parents[i] = i;
                sizes[i] = 1;
            }
        }
        //离散化，使得平摊O(1)
        public int findFather(int son){
            int pathLen = 0;
            while (parents[son]!=son){
                help[pathLen++] = son;
                son = parents[son];
            }
            for (int i = 0; i < pathLen; i++) {
                parents[help[i]] = son;
            }
            return son;
        }
        //合并两个集合,小挂大
        public void union(int setA,int setB){
            int aFather = findFather(setA);
            int bFather = findFather(setB);
            if(aFather==bFather) return;
            if(sizes[aFather]<sizes[bFather]){
                //小挂大
                sizes[bFather] += sizes[aFather];
                parents[aFather] = bFather;
            }else{
                sizes[aFather] += sizes[bFather];
                parents[bFather] = aFather;
            }
            maxSize = Math.max(Math.max(maxSize,sizes[aFather]),sizes[bFather]);
        }
    }
    //gcd(a,b)
    public  int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }

}
