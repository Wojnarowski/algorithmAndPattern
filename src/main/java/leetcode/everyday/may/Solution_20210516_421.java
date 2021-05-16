package leetcode.everyday.may;

import org.springframework.util.Assert;

/**
 *q 421 数组中两个数的最大异或值
 *
 *给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 *
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [2,4]
 * 输出：6
 * 示例 4：
 *
 * 输入：nums = [8,10,2]
 * 输出：10
 * 示例 5：
 *
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * 0 <= nums[i] <= 231 - 1
 * 通过次数25,021提交次数40,809
 *
 *
 */
public class Solution_20210516_421 {


    public  static int findMaximumXOR(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                max=Math.max(max,nums[i]^nums[j]);
            }
        }
        return max;
    }

    /**
     * O1 内解决问题
     * @param nums
     * @return
     */

    static Tire root=new Tire();
    static final int key=30;
    public  static int findMaximumXORByO1(int[] nums) {
        int res=0;
        for(int i:nums){
            add(i);
        }
        for(int i:nums){
            res=Math.max(res,check(i));
        }
        return res;

    }
    public static void add(int num){
        Tire cur=root;
        for(int i=key;i>=0;i--){
            int val=(num>>i)&1;
            if(val==0){
                if(cur.left==null){
                    Tire node=new Tire();
                    cur.left=node;
                }
                cur=cur.left;
            }else{
                if(cur.right==null){
                    Tire node=new Tire();
                    cur.right=node;
                }
                cur=cur.right;
            }
        }
    }

    public static int check(int num){
        Tire cur=root;
        int res=0;
        for(int i=key;i>=0;i--){
            int x=num>>i&1;
            if(x==0){
                if(cur.right!=null){
                    cur=cur.right;
                    res=res*2+1;
                }else{
                    cur=cur.left;
                    res=res*2;
                }
            }else{
                if(cur.left!=null){
                    cur=cur.left;
                    res=res*2+1;
                }else{
                    cur=cur.right;
                    res=res*2;
                }
            }
        }
        return res;
    }

    static class Tire{
        Tire left=null;
        Tire right=null;
    }



    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(findMaximumXOR(new int[]{3,10,5,25,2,8})==28,"程序异常");
        //xorQueries(new int[]{1,3,4,8},new int [][]{{0,1},{1,2},{0,3},{3,3}});
        System.out.println("-------------运行通过-------------");
    }
}
