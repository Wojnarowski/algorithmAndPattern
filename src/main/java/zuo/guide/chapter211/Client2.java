package zuo.guide.chapter211;

/**
 * dp
 *
 */
public class Client2 {

    int lineCount;
    int[][] inputData;

    private void calculate(){
        int max =getSumMax(0,0);
        System.out.println("从底到顶的最大值为 "+max);
    }

    private int getSumMax(int i, int j) {
        if(i== lineCount -1){
                return  inputData[i][j];
        }
        int x=getSumMax(i+1,j);
        int y=getSumMax(i+1,j+1);
        return Math.max(x,y)+inputData[i][j];
    }
}
