package contest.The275;

import java.util.Arrays;

/**
 * @author chenz at 10:26 on 2022/1/9 .
 */
public class S1 {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit,false);
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]<=0||matrix[i][j]>n){
                    return false;
                }
                if (visit[matrix[i][j] - 1]){
                    return false;
                }
                visit[matrix[i][j]-1] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit,false);
            for (int j = 0; j < n; j++) {
                if (matrix[j][i]<=0||matrix[j][i]>n){
                    return false;
                }
                if (visit[matrix[j][i]-1]){
                    return false;
                }
                visit[matrix[j][i]-1] = true;
            }
        }
        return  true;
    }
}
