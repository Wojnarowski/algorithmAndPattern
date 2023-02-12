package leetcode.everyday.commit2023.february;

import java.util.Arrays;

/**
 * 1138. 字母板上的路径
 */
public class Solution_202230212_1138 {

    public String alphabetBoardPath(String target) {
        StringBuilder res = new StringBuilder();
        int nx = 0;
        int ny = 0;
        for (int i = 0; i < target.length(); i++) {
            char t = target.charAt(i);
            int ty = (t - 'a') / 5;
            int tx = (t - 'a') % 5;
            if (tx < nx){
                for (int i1 = 0; i1 < nx - tx; i1++) {
                    res.append("L");
                }
            }
            if (ty < ny){
                for (int i1 = 0; i1 < ny - ty; i1++) {
                    res.append("U");
                }
            }
            if (ty > ny){
                for (int i1 = 0; i1 < ty - ny; i1++) {
                    res.append("D");
                }
            }
            if (tx > nx) {
                for (int i1 = 0; i1 < tx - nx; i1++) {
                    res.append("R");
                }
            }
            res.append("!");
            nx = tx;
            ny = ty;
        }
        return res.toString();
    }
}
