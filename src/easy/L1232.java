package easy;

/**
 * Created by chenz at 21:29 on 2021/1/17
 */
public class L1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        int length = coordinates.length;
        if (length == 2) {
            return true;
        }
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        for (int i = 2; i < length; i++) {
            if ((coordinates[i][1] - y2) * (x1 - x2) != (y1 - y2) * (coordinates[i][0] - x2)) {
                return false;
            }
        }
        return true;
    }
}
