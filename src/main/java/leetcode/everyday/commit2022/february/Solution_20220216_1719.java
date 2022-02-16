package leetcode.everyday.commit2022.february;

import java.util.*;

/**
 * 1719   重构一棵树的方案数
 *
 * 给你一个数组 pairs ，其中 pairs[i] = [xi, yi] ，并且满足：
 *
 * pairs 中没有重复元素
 * xi < yi
 * 令 ways 为满足下面条件的有根树的方案数：
 *
 * 树所包含的所有节点值都在 pairs 中。
 * 一个数对 [xi, yi] 出现在 pairs 中 当且仅当 xi 是 yi 的祖先或者 yi 是 xi 的祖先。
 * 注意：构造出来的树不一定是二叉树。
 * 两棵树被视为不同的方案当存在至少一个节点在两棵树中有不同的父节点。
 *
 * 请你返回：
 *
 * 如果 ways == 0 ，返回 0 。
 * 如果 ways == 1 ，返回 1 。
 * 如果 ways > 1 ，返回 2 。
 * 一棵 有根树 指的是只有一个根节点的树，所有边都是从根往外的方向。
 *
 * 我们称从根到一个节点路径上的任意一个节点（除去节点本身）都是该节点的 祖先 。根节点没有祖先。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：pairs = [[1,2],[2,3]]
 * 输出：1
 * 解释：如上图所示，有且只有一个符合规定的有根树。
 * 示例 2：
 *
 *
 * 输入：pairs = [[1,2],[2,3],[1,3]]
 * 输出：2
 * 解释：有多个符合规定的有根树，其中三个如上图所示。
 * 示例 3：
 *
 * 输入：pairs = [[1,2],[2,3],[2,4],[1,5]]
 * 输出：0
 * 解释：没有符合规定的有根树。
 *  
 *
 * 提示：
 *
 * 1 <= pairs.length <= 105
 * 1 <= xi < yi <= 500
 * pairs 中的元素互不相同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-ways-to-reconstruct-a-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 *
 */
public class Solution_20220216_1719 {
    public int checkWays(int[][] pairs) {
        int ans = 1;
        HashMap<Integer,List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        HashMap<Integer, Integer> map = new HashMap<>();
        // 构建邻接矩阵
        for (int[] p:pairs){
            map.put(p[0], map.getOrDefault(p[0],0)+1);
            map.put(p[1], map.getOrDefault(p[1],0)+1);
            graph.computeIfAbsent(p[0], t->new ArrayList<Integer>()).add(p[1]);
            graph.computeIfAbsent(p[1], t->new ArrayList<Integer>()).add(p[0]);

        }
        int n = map.size();
        // 下面这段排序属实不雅观，码力不够，如果有大佬能帮我提提建议将不胜感谢！
        Integer[] nums = new Integer[n];
        int y = 0;
        for (Integer x:map.keySet()){
            nums[y++] = x;
        }
        Arrays.sort(nums, new Comparator<Integer>(){
            //@override
            public int compare(Integer a, Integer b){
                return map.get(b)-map.get(a);
            }
        });
        // 根节点不满足条件
        if(map.get(nums[0]) != n-1)return 0;
        // 判断有没有称为多个子树的潜质。
        for(int[] p:pairs){
            //如果是基本数据类型，==判断的是值；如果是对象类型，==判断的是对象的地址。这里坑了我一会
            if (Objects.equals(map.get(p[1]),map.get(p[0]))){ // 某一对具有祖孙关系的节点的 祖孙复杂关系也一样，说明可以交换
                ans = 2;
                break;
            }
        }
        HashSet<Integer> vis = new HashSet<>(); // 存放已经是祖先节点的
        HashMap<Integer, Integer> fa = new HashMap<>(); // 维护每个节点的实时父节点
        for(int i:nums){
            fa.put(i,nums[0]); // 初始下，全部节点都连接在根节点下
        }
        vis.add(nums[0]);

        for(int i = 1;i<n;i++){;
            for (int j: graph.get(nums[i])){ // 找到nums[i]这个节点的邻接
                if(!vis.contains(j)){ // vis不包含说明是当前nums[i]节点的孙节点
                    //!!! 这个条件是核心！！！
                    // 简单概括就是，如果a的祖先不是b的祖先，但是a,b之间还存在祖孙关系，这显然不合理。
                    if(fa.get(j) != fa.get(nums[i])){
                        return 0; // 父节点不一致，说明矛盾。具体原因参见 树叶烦 的解析
                    }
                    fa.put(j, nums[i]); // 更新父节点
                }
            }
            vis.add(nums[i]); // 这个节点已经安排清楚了，加入祖先节点
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(reversePrefix("abcd",'z').equals("abcd"),"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
