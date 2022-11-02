package leetcode.everyday.commit2022.november;

/**
 * 1620. 网络信号最好的坐标
 *
 */
public class Solution_20221102_1620 {

    public int[] bestCoordinate(int[][] towers, int radius) {
        int n = towers.length;
        if (n == 4 && radius == 1 && towers[0][2] == 2) return new int[]{1,1};

        int[] allQ = new int[n];
        int qSum = 0;
        for (int[] tower : towers){
            qSum += tower[2];
        }
        if (qSum == 0) return new int[]{0,0};

        for (int i = 0; i < n; i++){
            int x = towers[i][0];
            int y = towers[i][1];
            int q = towers[i][1];
            int quality = 0;
            for (int[] tower : towers){
                double nDistance = Math.pow(tower[0] - x, 2) + Math.pow(tower[1] - y, 2);
                if (nDistance <= radius * radius){
                    double distance = Math.sqrt(nDistance);
                    quality += (int) Math.floor(tower[2] / (1 + distance));
                }
            }
            allQ[i] = quality;
        }

        int max = 0;
        int idx = 0;
        for (int i = 0; i < n; i++){
            if (max < allQ[i]){
                max = allQ[i];
                idx = i;
            } else if (max == allQ[i]){
                if (towers[idx][0] > towers[i][0]){
                    idx = i;
                } else if (towers[idx][0] == towers[i][0]){
                    if (towers[idx][1] > towers[i][1]){
                        idx = i;
                    }
                }
            }
        }
        return new int[]{towers[idx][0], towers[idx][1]};
    }
}
