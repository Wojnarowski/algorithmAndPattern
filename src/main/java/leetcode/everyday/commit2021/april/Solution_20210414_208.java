package leetcode.everyday.commit2021.april;

/**
 *q 208  实现 Trie (前缀树)
 *
 *
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *  
 *
 * 示例：
 *
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 *
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 *  
 *
 */
public class Solution_20210414_208 {

    class  TrieNode{
        boolean isWord;
        TrieNode[] children;
        TrieNode(){
            isWord=true;
            children=new TrieNode[26];
        }
    }

    class Trie {

        //根节点，根节点不存储数据
        private TrieNode root;


        /** Initialize your data structure here. */
        public Trie() {
            root=new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode current=root;
            for(int i=0;i<word.length();i++){
                int index=word.charAt(i)-'a';
                //判断字符有没有创建，如果没有创建就创建
                if(current.children[index]==null){
                    current.children[index]=new TrieNode();
                    //中间的字符不是完整的单词
                    current.children[index].isWord=false;
                }
                current=current.children[index];
            }
            //循环完了，到最后一个字符才构成一个完整的单词
            current.isWord=true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode current=root;
            for(int i=0;i<word.length();i++){
                int index=word.charAt(i)-'a';
                current=current.children[index];
                if(current==null){
                    return false;
                }
            }
            return current.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode current=root;
            for(int i=0;i<prefix.length();i++){
                int index=prefix.charAt(i)-'a';
                current=current.children[index];
                if(current==null){
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(nthUglyNumber(10)==12,"程序异常");
        //Assert.isTrue(nthUglyNumber(1)==1,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
