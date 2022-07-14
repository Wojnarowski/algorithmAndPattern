package leetcode.everyday.commit2022.july;

import java.util.Stack;

/**
 * 745  前缀和后缀搜索
 *
 * 设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。
 *
 * 实现 WordFilter 类：
 *
 * WordFilter(string[] words) 使用词典中的单词 words 初始化对象。
 * f(string pref, string suff) 返回词典中具有前缀 prefix 和后缀 suff 的单词的下标。如果存在不止一个满足要求的下标，返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。
 *  
 *
 * 示例：
 *
 * 输入
 * ["WordFilter", "f"]
 * [[["apple"]], ["a", "e"]]
 * 输出
 * [null, 0]
 * 解释
 * WordFilter wordFilter = new WordFilter(["apple"]);
 * wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词：前缀 prefix = "a" 且 后缀 suff = "e" 。
 *  
 * 提示：
 *
 * 1 <= words.length <= 104
 * 1 <= words[i].length <= 7
 * 1 <= pref.length, suff.length <= 7
 * words[i]、pref 和 suff 仅由小写英文字母组成
 * 最多对函数 f 执行 104 次调用
 * 通过次数6,562提交次数14,564
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/prefix-and-suffix-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 */


public class Solution_20220714_745 {


    static long a[]=new long[30008];int g[];

    public Solution_20220714_745(String[] words) {
        int i,j,n,x,y;long z1,z2;
        for(i=j=0,n=words.length,g=new int[32000];i<n;++i){
            x=words[i].length();z1=z2=0;
            byte w[]=words[i].getBytes();
            for(int i1=0,n1=x;i1<n1;++i1){z1<<=8;z1+=w[--x];z2<<=8;z2+=w[i1];}
            x=((((byte)z1)<<8)+(byte)z2);
            a[++j]=z2;a[++j]=z1;a[++j]=g[x];g[x]=j+(i<<16);
        }

    }

    public int f(String pref, String suff) {
        int i,n;long z1,z2,z3,z4,pm,sm;
        byte p[]=pref.getBytes(),s[]=suff.getBytes();
        for(i=pref.length(),z1=pm=0;--i>=0;z1<<=8,pm<<=8,z1+=p[i],pm+=255);
        for(n=suff.length(),z2=sm=i=0;i<n;z2<<=8,sm<<=8,z2+=s[i++],sm+=255);
        for(n=g[((((byte)z1)<<8)+(byte)z2)];n!=0;n=(int)a[i]){
            i=(short)n;z3=a[i-1]&pm;z4=a[i-2]&sm;
            if (z3==z1&&z4==z2) return n>>16;
        }
        return -1;

    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
