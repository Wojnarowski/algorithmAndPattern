package leetcode.everyday.commit2022.september;

import java.util.Arrays;

/**
 * 1592    重新排列单词间的空格
 *
 *
 *
 */
public class Solution_20220907_1592 {

    public String reorderSpaces(String text) {
        int spaces = 0, words = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaces++;
            } else if (i - 1 < 0 || text.charAt(i - 1) == ' ') {
                words++;
            }
        }

        // 计算平均空格数，注意单词为一个的时候的边界值处理
        int average = words - 1 == 0 ? 0 : spaces / (words - 1);

        // 构造结果
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                sb.append(text.charAt(i));

                // 如果后面一个为空格，说明本单词结束，放置中间的空格
                if (i + 1 < text.length() && text.charAt(i + 1) == ' ' && --words > 0) {
                    for (int j = 0; j < average; j++) {
                        sb.append(' ');
                        spaces--;
                    }
                }
            }
        }

        // 剩余空格的处理
        while (spaces-- > 0) {
            sb.append(' ');
        }

        // 返回结果
        return sb.toString();

    }
}
