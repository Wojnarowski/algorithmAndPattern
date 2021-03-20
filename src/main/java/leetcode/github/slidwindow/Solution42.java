package leetcode.github.slidwindow;

/**
 *q_42 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
 * 计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，
 * 在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *  
 * 提示：
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 * 通过次数212,360提交次数387,573
 * 在真实的面试中遇到过这道题？
 *
 */
public class Solution42 {

    /*
    使用双指针（左右两边各两个指针）

    我们使用一根一根柱子计算装水量的方法

    left 表示左边当前遍历的柱子（即左边我们需要计算能够装多少水的柱子）
    left_max 表示 left 的左边最高的柱子长度（不包括 left）
    right 表示右边当前遍历的柱子
    right_max 表示 right 的右边最高的柱子长度（不包括 right）

    我们有以下几个公式：
    当 left_max < right_max 的话，那么我们就判断 left_max 是否比 left 高
        因为根据木桶效应，一个桶装水量取决于最短的那个木板，这里也一样，柱子能否装水取决于左右两边的是否都存在比它高的柱子
        因为 left_max < right_max 了，那么我们只需要比较 left_max 即可
            如果 left_max > left，那么装水量就是 left_max - left
            如果 left_max <= left，那么装水量为 0，即 left 装不了水
    当 left_max >= right_max 的话，同理如上，比较 right_max 和 right

    ？？？？ 为什么 right_max 和 left 隔这么远我们还可以使用 right_max 来判断？
    前提：left_max < right_max
    right_max 虽然跟 left 离得远，但有如下两种情况：
    1、left 柱子和 right_max 柱子之间，没有比 right_max 柱子更高的柱子了，
    那么情况如下：  left 能否装水取决于 left_max 柱子是否比 left 高
                    |
        |           |
        |   |       |
        ↑   ↑       ↑
       l_m  l      r_m

    2、left 柱子和 right_max 柱子之间存在比 right_max 柱子更高的柱子
    那么情况如下：因为存在了比 right_max 更高的柱子，那么我们仍然只需要判断 left_max 是否比 left 高，因为右边已经存在比 left 高的柱子
                |
                |   |
        |       |   |
        |   |   |   |
        ↑   ↑   ↑   ↑
       l_m  l  mid  r_m

    初始化指针：
    left = 1;
    right = len - 2;
    left_max = 0;
    right_max = len - 1;
    （因为第一个柱子和最后一个柱子肯定不能装水，因为不作为装水柱子，而是作为左边最高柱子和右边最高柱子）
*/
    public int trap(int[] height) {
        int len =height.length;
        int left=1;
        int right=len-2;
        int left_max=0;
        int right_max=len-1;
        int ans = 0;

        while(left<=right){
            //比较
            if(height[left_max] < height[right_max]){
                if(height[left_max] > height[left]){
                    ans += height[left_max] - height[left];
                }else{
                    left_max = left;
                }
                left++;
            }else{
                if(height[right_max] > height[right]){
                    ans += height[right_max] - height[right];
                }else{
                    right_max = right;
                }
                right--;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(removeDuplicates(new int[]{-1,2,1,-4},1)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
