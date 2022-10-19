package leetcode.everyday.commit2022.october;

/**
 * 1700. 无法吃午餐的学生数量
 *
 */
public class Solution_20221019_1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        int[] c = new int[2];
        for (int stu : students) {
            c[stu]++;
        }
        int p = 0;
        while (p < sandwiches.length && (c[1] >= 0 && c[0] >= 0)) {
            c[sandwiches[p++]]--;
        }
        return c[1] == 0 && c[0] == 0 ? 0 : sandwiches.length - p + 1;
    }
}
