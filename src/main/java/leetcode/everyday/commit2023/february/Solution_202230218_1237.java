//package leetcode.everyday.commit2023.february;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
///**
// * 1237. 找出给定方程的正整数解
// */
//public class Solution_202230218_1237 {
//
//    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
//        List<List<Integer>> res = new ArrayList<>();    // 所有解的数对
//        List<Integer> ans;  // 一个解数对
//        int x = 1;          // 初始化x，从[1,1000]左端点出发
//        int y = 1000;       // 初始化y，从[1,1000]右端点出发
//        int f;      // 记录运算结果
//        // 双指针相向搜索，直到有一个变量到达边界
//        while(x <= 1000 && y >= 1){
//            f = customfunction.f(x, y);
//            if(f == z){
//                ans = new ArrayList<>();
//                ans.add(x);
//                ans.add(y);
//                res.add(ans);
//                x++;
//                y--;
//            }else if(f > z){
//                y--;
//            }else{
//                x++;
//            }
//        }
//        return res;
//    }
//
//}
//
//  class CustomFunction {
//      // Returns f(x, y) for any given positive integers x and y.
//              // Note that f(x, y) is increasing with respect to both x and y.
//              // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
//              public int f(int x, int y);
//  };
