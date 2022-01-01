package leetcode.everyday.commit2021.august;


/**
 *345 反转字符串中的元音字母
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *  
 *
 *
 *
 */


public class Solution_20210819_345 {

    public String reverseVowels(String s) {
        char[] c=s.toCharArray();
        int left=0,right=c.length-1;
        while(left<right){
            if(!find(c[left])){
                left++;
            }
            if (!find(c[right])){
                right--;
            }
            if(find(c[left])&&find(c[right])){
                char temp=c[left];
                c[left]=c[right];
                c[right]=temp;
                left++;
                right--;
            }
        }
        return new String(c);
    }

    static boolean find(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'||c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        int [] arr = new int[]{2,2,3,4};

        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(tribonacci(3)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
