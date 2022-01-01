package leetcode.everyday.commit2021.september;

/**
 *q 1221 分割平衡字符串
 *
 *在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 *
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 *
 * 注意：分割得到的每个字符串都必须是平衡字符串。
 *
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 * 示例 2：
 *
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL"、"LLLRRR"、"LR" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 * 示例 3：
 *
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 * 示例 4：
 *
 * 输入：s = "RLRRRLLRLL"
 * 输出：2
 * 解释：s 可以分割为 "RL"、"RRRLLRLL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s[i] = 'L' 或 'R'
 * s 是一个 平衡 字符串
 * 通过次数46,298提交次数56,636
 *
 *
 *
 */
public class Solution_20210907_1221 {

    /**
     * 计数
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        char [] arr = s.toCharArray();
        int n=arr.length;
        int l=0,r=0,ans=0;
        for(int i=0;i<n;i++){
            if(arr[i]=='L'){
                l++;
            }
            if(arr[i]=='R'){
                r++;
            }
            if(l==r){
                ans++;
                l=0;
                r=0;
            }

        }
       return ans;

    }

    /**
     * 贪心
     * 根据题意，对于一个平衡字符串 ss，若 ss 能从中间某处分割成左右两个子串，若其中一个是平衡字符串，则另一个的 \texttt{L}L 和 \texttt{R}R 字符的数量必然是相同的，所以也一定是平衡字符串。
     *
     * 为了最大化分割数量，我们可以不断循环，每次从 ss 中分割出一个最短的平衡前缀，由于剩余部分也是平衡字符串，我们可以将其当作 ss 继续分割，直至 ss 为空时，结束循环。
     *
     * 代码实现中，可以在遍历 ss 时用一个变量 dd 维护 \texttt{L}L 和 \texttt{R}R 字符的数量之差，当 d=0d=0 时就说明找到了一个平衡字符串，将答案加一。
     *
     * @param s
     * @return
     */
    public int balancedStringSplit2(String s) {
        int ans =0,d=0;
        for(char c:s.toCharArray()){
            if(c=='L'){
                d++;
            }
            else{
                d--;
            }
            if(d==0){
                ans++;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //int [] array= new int[]{-1,0,3,5,9,12};
        //int target =2;
        //Assert.isTrue(search(array,target)==-1,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
