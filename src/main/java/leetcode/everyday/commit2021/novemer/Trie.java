package leetcode.everyday.commit2021.novemer;

/**
 * @ClassName Trie
 * @Description TODO
 * @Author paul
 * @Date 2021/11/14 17:06
 * Vertion 1.0
 * -------------------------------------------------------------_ooOoo_
 * ------------------------------------------------------------o8888888o
 * ------------------------------------------------------------88"-.-"88
 * ------------------------------------------------------------(|--_--|)
 * ------------------------------------------------------------O\--=--/O
 * ---------------------------------------------------------____/`---'\____
 * -------------------------------------------------------.'--\\|-----|//--`.
 * ------------------------------------------------------/--\\|||--:--|||//--\
 * -----------------------------------------------------/--_|||||--:--|||||---\
 * -----------------------------------------------------|---|-\\\-----///-|---|
 * -----------------------------------------------------|-\_|--''\---/''--|---|
 * -----------------------------------------------------\--.-\__--`-`--___/-.-/
 * ---------------------------------------------------___`.-.'--/--.--\--`.-.-__
 * ------------------------------------------------.""-'<--`.___\_<|>_/___.'-->'"".
 * -----------------------------------------------|-|-:--`--\`.;`\-_-/`;.`/---`-:-|-|
 * -----------------------------------------------\--\-`-.---\_-__\-/__-_/---.-`-/--/
 * ---------------------------------------======`-.____`-.___\_____/___.-`____.-'======
 * -------------------------------------------------------------`=---='
 * ---------------------------------------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * -----------------------------------------------------佛祖保佑--------永无BUG
 */



public class Trie {

    class TrieNode{
        TrieNode[] children= new TrieNode[26];
        boolean isWord;
    }
    TrieNode root;

    public Trie() {
        root= new TrieNode();
    }

    public void insert(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u= s.charAt(i)-'a';
            if(p.children[u]==null){
                p.children[u]= new TrieNode();
            }
            p = p.children[u];
        }
        p.isWord=true;
    }

    public boolean search(String s) {
        TrieNode p = root;
        for(int i=0;i<s.length();i++){
            int u=s.charAt(i)-'a';
            if(p.children[u]==null){
                return false;
            }
            else{
                p=p.children[u];
            }
        }
        return p.isWord;
    }

    public boolean startsWith(String s) {
        TrieNode p = root;
        for(int i=0;i<s.length();i++){
            int u=s.charAt(i)-'a';
            if(p.children[u]==null){
                return false;
            }
            else{
                p=p.children[u];
            }
        }
        return true;
    }
}

