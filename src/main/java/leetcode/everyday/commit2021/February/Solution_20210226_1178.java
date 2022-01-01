package leetcode.everyday.commit2021.February;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
 *
 * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 *
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。
 * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * words = ["aaaa","asas","able","ability","actt","actor","access"],
 * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
 * 输出：[1,1,3,2,4,0]
 * 解释：
 * 1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
 * 1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
 * 3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
 * 2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
 * 4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
 * 没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 10^5
 * 4 <= words[i].length <= 50
 * 1 <= puzzles.length <= 10^4
 * puzzles[i].length == 7
 * words[i][j], puzzles[i][j] 都是小写英文字母。
 * 每个 puzzles[i] 所包含的字符都不重复。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */


public class Solution_20210226_1178 {

    /**
     * 暴力递归来一波儿
     * TODO 超时了！！！！！！！！！！！！！！
     * @param words
     * @param puzzles
     * @return
     */
    public static List<Integer> findNumOfValidWords1(String[] words, String[] puzzles) {
        if(words==null || puzzles ==null || words.length==0 ||puzzles.length==0){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<puzzles.length;i++){
            int count =0;
            for(int j=0;j<words.length;j++){
                boolean matchResult=match(puzzles[i],words[j]);
                if(matchResult){
                    count++;
                }
            }
            result.add(count);
        }

        return result;
    }

    private static boolean match(String puzzle, String word) {
        char puzzle0 = puzzle.charAt(0);
        if(!word.contains(String.valueOf(puzzle0))){
            return false;
        }
        char[] wordChar = word.toCharArray();
        for(int i=0;i<wordChar.length;i++){
            if(!puzzle.contains(String.valueOf(wordChar[i]))){
                return false;
            }
        }
        return true;
    }


    /**
     * 利用字典树
     * @param words
     * @param puzzles
     * @return
     */
    public static List<Integer> findNumOfValidWords2(String[] words, String[] puzzles) {
        TrieNode root = new TrieNode();
        //将word中字母按照字典排序并去重
        for(String word:words){
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<charArray.length;i++){
                if(i==0 || charArray[i]!=charArray[i-1]){
                    stringBuilder.append(charArray[i]);
                }
            }
            //加入到字典树种
            add(root,stringBuilder.toString());
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (String puzzle : puzzles) {
            char required=puzzle.charAt(0);
            char[]arr=puzzle.toCharArray();
            Arrays.sort(arr);
            ans.add(find(new String(arr),required,root,0));
        }
        return ans;
    }

    private static Integer find(String puzzle, char required, TrieNode cur, int pos) {
        // 搜索到空节点，不合法，返回 0
        if (cur == null) {
            return 0;
        }
        // 整个 puzzle 搜索完毕，返回谜底的数量
        if (pos == 7) {
            return cur.frequency;
        }

        // 选择第 pos 个字母
        int ret = find(puzzle, required, cur.child[puzzle.charAt(pos) - 'a'], pos + 1);

        // 当 puzzle.charAt(pos) 不为首字母时，可以不选择第 pos 个字母
        if (puzzle.charAt(pos) != required) {
            ret += find(puzzle, required, cur, pos + 1);
        }

        return ret;

    }

    private static void add(TrieNode root, String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cur.child[ch-'a']==null){
                cur.child[ch-'a'] =new TrieNode();
            }
            cur=cur.child[ch-'a'];
        }
        ++cur.frequency;
    }

    static class TrieNode{
        int frequency;
        TrieNode[] child;

        public TrieNode(){
            frequency=0;
            child=new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        String[] words = new String[]{"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles  = new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};

        System.out.println("-------------开始执行-------------");
        List<Integer> result = findNumOfValidWords2(words,puzzles);
        System.out.println(result);
        System.out.println("-------------运行通过-------------");

    }
}
