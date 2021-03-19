package leetcode.everyday.march;

import org.springframework.util.Assert;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 *
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 *
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 *
 * 示例 1:
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 *
 * 示例 2:
 * 输入: "1,#"
 * 输出: false
 *
 *
 * 示例 3:
 * 输入: "9,#,#,1"
 * 输出: false
 *
 *
 *
 * 通过次数14,567提交次数30,861
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 */
public class Solution_20210312_331 {


    /**
     * 思路
     * 1.初始需要填充的位置只有一个，即根节点，计为count=1;
     * 2.如果遇到数字，count=count+2-1，因为遇到数字的情况下，数字占据了一个位置，但是却产生了两个需要填充的位置
     * 3.遇到#，count=count-1;因为他单纯填充位置，而不消耗位置
     * 4.判断是否符合条件,结尾count必须为0，即没有填充的位置，也没有少位置
     *
     * @param preorder
     * @return
     */
    public static  boolean isValidSerialization(String preorder) {
        //初始时候放一个位置
        int count=1;
        //用来记录是不是发现数字
        boolean flag = false;
        char[] charArray=preorder.toCharArray();
        for(char ch:charArray){
            //判断是不是中间过程count<0,如果已经不能填充了，但是还在循环中,说明肯定是错的
            if(count<=0){
                return false;
            }
            if(ch>='0' && ch<='9'){
                flag=true;
            }
            //发现# 计数-1
            else if(ch=='#'){
                count--;
            }
            //发现数字并且遇到','，count+1，并把flag标志置false
            else if(flag && ch==','){
                count=count+2-1;
                flag=false;
            }
        }
        //如果是最后一个数字，没有分号，所以需要进行最后检查
        if(flag){
            count++;
        }
        //判断count是不是为0
        if(count==0){
            return true;
        }
        else{
            return false;
        }

    }
    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#")==true,"程序异常");
        Assert.isTrue(isValidSerialization("1,#")==false,"程序异常");
        Assert.isTrue(isValidSerialization("9,#,#,1")==false,"程序异常");
        System.out.println("-------------运行通过-------------");


    }
}
