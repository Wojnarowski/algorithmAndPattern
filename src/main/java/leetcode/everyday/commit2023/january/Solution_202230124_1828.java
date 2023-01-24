package leetcode.everyday.commit2023.january;

/**
 * 2303. 计算应缴税款总额
 */
public class Solution_202230124_1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int i=0,n=queries.length,x1,x2,y1,y2,r,res[]=new int[n];
        for(int q[]:queries){
            x1=q[0];y1=q[1];r=q[2]*q[2];n=0;
            for(int p[]:points){
                x2=x1-p[0];y2=y1-p[1];x2*=x2;y2*=y2;
                ++n;n+=r-x2-y2>>31;
            }
            res[i++]=n;
        }
        return res;
    }

}
