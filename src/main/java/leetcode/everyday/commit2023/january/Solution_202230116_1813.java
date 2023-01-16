package leetcode.everyday.commit2023.january;

/**
 * 1819. 序列中不同最大公约数的数目
 */
public class Solution_202230116_1813 {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] list1 = sentence1.split(" ");
        String[] list2 = sentence2.split(" ");
        String[] longer = list1.length >= list2.length ? list1 : list2;
        String[] shorter = list1.length < list2.length ? list1 : list2;

        int left = -1;
        final int m = longer.length;
        final int n = shorter.length;
        for (int i = 0; i < n; i++) {
            if (shorter[i].equals(longer[i])) {
                left = i;
            } else {
                break;
            }
        }

        int right = n;
        for (int i = 1; i <= n; i++) {
            if (shorter[n - i].equals(longer[m - i])) {
                right = n - i;
            } else {
                break;
            }
        }

        return left == right || right - left == 1 || (left == n - 1 && right == 0);
    }
}
