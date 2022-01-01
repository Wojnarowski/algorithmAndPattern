package leetcode.everyday.commit2021.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Solution_20210307_77 {


    /**
     * 回溯
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans =new ArrayList<>();
        LinkedList<Integer> path= new LinkedList<>();
        backTrack(n,k,1,path,ans);
        return ans;
    }

    private static void backTrack(int n, int k, int start, LinkedList<Integer> path, List<List<Integer>> ans) {
        if(k==0){
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i=start;i<=n;i++){
            path.add(i);
            backTrack(n,k-1,i+1,path,ans);
            path.removeLast();
        }
    }


    public static void main(String[] args) {


        List<List<Integer>> list = combine(4,2);
        System.out.println(Arrays.toString(list.toArray()));

    }
}
