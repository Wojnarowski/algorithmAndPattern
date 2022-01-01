package leetcode.everyday.commit2021.october;

/**
 *q 211 添加与搜索单词 - 数据结构设计
 *
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 *
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *  
 *
 * 提示：
 *
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 * 通过次数33,034提交次数67,176
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Solution_20211019_211 {


    class WordDictionary {

        class Node {
            Node[] tns = new Node[26];
            boolean isWord;
        }
        Node root = new Node();

        public WordDictionary() {


        }

        public void addWord(String word) {
            Node p = root;
            for (int i = 0; i < word.length(); i++) {
                int u = word.charAt(i) - 'a';
                if (p.tns[u] == null) p.tns[u] = new Node();
                p = p.tns[u];
            }
            p.isWord = true;
        }

        public boolean search(String word) {
            return dfs(word, root, 0);
        }
        boolean dfs(String s, Node p, int sIdx) {
            int n = s.length();
            if (n == sIdx) return p.isWord;
            char c = s.charAt(sIdx);
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (p.tns[j] != null && dfs(s, p.tns[j], sIdx + 1)) return true;
                }
                return false;
            } else {
                int u = c - 'a';
                if (p.tns[u] == null) return false;
                return dfs(s, p.tns[u], sIdx + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        int [] array= new int[]{1,2,3,1};
        //Assert.isTrue(arrangeCoins(5)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
