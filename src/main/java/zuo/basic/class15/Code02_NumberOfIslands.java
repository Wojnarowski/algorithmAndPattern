package zuo.basic.class15;

/**
 * @ClassName Code02_NumberOfIslands
 * @Description TODO
 * @Author paul
 * @Date 2021/8/26 16:48
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
 *
 *https://leetcode.com/problems/number-of-islands/
 */
public class Code02_NumberOfIslands {

    /**
     * 每次感染一遍是1的
     * @param board
     * @return
     */
    public static int numIslands3(char[][] board) {

        int ans=0;
        int n=board[0].length;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='1'){
                    ans++;
                    infect(board,i,j);
                }
            }
        }

        return ans;

    }

    private static void infect(char[][] board, int i, int j) {

        //返回条件
        if(i<0 || i==board.length  ||  j<0 || j==board[0].length  || board[i][j] !='1'){
            return;
        }
        board[i][j]='2';
        infect(board,i-1,j);
        infect(board,i+1,j);
        infect(board,i,j-1);
        infect(board,i,j+1);
    }
}
