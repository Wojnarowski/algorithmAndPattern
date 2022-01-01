package leetcode.everyday.commit2021.august;


/**
 *541 反转字符串 II
 *
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，
 * 每 2k 个字符反转前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 *
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 *
 */


public class Solution_20210820_541 {

    /**
     * https://leetcode-cn.com/problems/reverse-string-ii/solution/tong-ge-lai-shua-ti-la-mo-ni-jian-dan-ti-7prh/
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        int n=s.length();
        char[] arr= s.toCharArray();

        //每次进2k，但是只交换前k个字符
        for(int l=0;l<n;l=l+2*k){
            int r=l+k-1;
            swap(arr, l, Math.min(r, n - 1));
        }

        return new String(arr);
    }

    private void swap(char[] arr, int left, int right) {
        while(left<right){
            char temp = arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int [] arr = new int[]{2,2,3,4};

        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(tribonacci(3)==2,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
