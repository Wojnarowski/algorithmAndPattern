package leetcode.everyday.june;

import java.util.HashSet;
import java.util.Set;

/**
 *q 752 打开转盘锁
 *
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 *  
 *
 * 示例 1:
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 *
 *
 * 示例 2:
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 *
 *
 *
 * 示例 3:
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 *
 *
 * 示例 4:
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 *  
 *
 * 提示：
 *
 * 死亡列表 deadends 的长度范围为 [1, 500]。
 * 目标数字 target 不会在 deadends 之中。
 * 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
 * 通过次数45,951提交次数91,596
 *
 *
 *
 */
public class Solution_20210625_752 {


    /**
     * 思路
     * https://leetcode-cn.com/problems/open-the-lock/solution/da-kai-zhuan-pan-suo-bfsdan-xiang-shuang-0veb/
     * 双向BFS  双向 BFSBFS 适用于 <起点> 和 <终点> 都知道的的情况下使用。
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int step=0;
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()){
            //用 temp 存储 q1 的扩散结果
            Set<String> temp = new HashSet<>();
            //将q1中所有节点向周围扩散
            for(String cur:q1){
                if(deads.contains(cur)){
                    continue;
                }
                if(q2.contains(cur)){
                    return step;
                }
                visited.add(cur);

                // 将一个节点未遍历的相邻节点加入集合
                for(int j=0;j<4;j++){
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) temp.add(up);

                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) temp.add(down);
                }
            }
            step++;
            q1 = q2; // 此时 temp 相当于 q1，交换 q1 和q2，下一轮 while 会扩散 q2
            q2 = temp;
        }
        return -1;
    }

    public String plusOne(String cur,int j){
        char[] ch = cur.toCharArray();
        if (ch[j] == '9') ch[j] = '0';
        else ch[j] += 1;
        return new String(ch);
    }

    public String minusOne(String cur, int j) {
        char[] ch = cur.toCharArray();
        if (ch[j] == '0') ch[j] = '9';
        else ch[j] -= 1;
        return new String(ch);
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(peakIndexInMountainArray1(new int[]{0,1,0})==1,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
