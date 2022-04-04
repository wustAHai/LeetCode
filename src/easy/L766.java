package easy;

/**
 * Created by chenz at 21:14 on 2021/2/22
 */
public class L766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            int temp = matrix[0][i];
            int n = 1;
            while (n + 0 < matrix.length && n + i < matrix[0].length) {
                if (temp != matrix[n + 0][n + i]) {
                    return false;
                }
                n++;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            int temp = matrix[i][0];
            int n = 1;
            while (n < matrix[0].length && n + i < matrix.length) {
                if (temp != matrix[n + i][n]) {
                    return false;
                }
                n++;
            }
        }
        return true;
    }
}
