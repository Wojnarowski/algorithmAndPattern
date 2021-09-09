package leetcode.everyday.september;

import java.util.*;

/**
 *q 68 文本左右对齐
 *
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，
 * 且左右两端对齐的文本。
 *
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，
 * 使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 *
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 *
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 *
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 * 通过次数21,640提交次数44,496
 *
 *
 */
public class Solution_20210909_68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<Integer> index = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        // 把单词挨个放到结果中去
        for (int i = 0; i < words.length; ++i) {
            if (str.length() + words[i].length() < maxWidth) {
                // 如果当前单词加入到当前的行中时，没有超过要求，直接放进来好了
                str.append(words[i]);   // 拼接当前行内容
                index.add(str.length());// 然后记下来当前空格位置
                str.append(" ");
            } else if (str.length() + words[i].length() == maxWidth) {
                // 如果正好碰到了边界，那么就加进来当前单词后，放到最终的返回值中
                str.append(words[i]);
                ans.add(str.toString());
                // 然后清空当前的缓冲内容
                str = new StringBuilder();
                index.clear();
            } else {
                // 如果添加了当前单词后，超出了容量限制，就进行空格调整
                // 首先记录剩余多少空格
                int space = maxWidth - str.length();
                // 然后把最后一个空格去掉，把所有的空格放到中间去
                if (index.size() > 1) {
                    str.deleteCharAt(str.length() - 1);
                    index.remove(index.size() - 1);
                    space += 1;
                }
                // 计算每一个单词中间的空格基本个数（every），以及额外的空格 （remain）
                int every = 0, remain = 0;
                if (!index.isEmpty()) {
                    every = space / index.size();
                    remain = space % index.size();
                }
                // 从后往前进行空格插入，这样方便计算下标在哪里
                for (int j = index.size() - 1; j >= 0; --j) {
                    char[] cs = new char[every + (j < remain ? 1 : 0)];
                    Arrays.fill(cs, ' ');
                    str.insert(index.get(j), new String(cs));
                }
                // 然后放到返回值中
                ans.add(str.toString());
                str = new StringBuilder();
                index.clear();
                --i;
            }
        }
        // 对剩余的单词进行空格拼接
        if (str.length() > 0) {
            if (str.length() < maxWidth) {
                char[] cs = new char[maxWidth - str.length()];
                Arrays.fill(cs, ' ');
                str.append(new String(cs));
            }
            ans.add(str.toString());
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
