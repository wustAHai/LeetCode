package contest;

import java.util.Arrays;

/**
 * Created by chenz at 10:58 on 2021/1/24
 */


// 1 2 3
// 4 5 6
// 7 8 9
public class C5663 {
    public int kthLargestValue(int[][] matrix, int k) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] myMatrix = new int[r][c];
        int[] result = new int[r * c];
        int n = 0;
        myMatrix[0][0] = matrix[0][0];
        result[n++] = matrix[0][0];
        for (int j = 1; j < c; j++) {
            myMatrix[0][j] = matrix[0][j] ^ myMatrix[0][j - 1];
            result[n++] = myMatrix[0][j];
        }
        for (int i = 1; i < r; i++) {
            myMatrix[i][0] = matrix[i][0] ^ myMatrix[i - 1][0];
            result[n++] = myMatrix[i][0];
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                myMatrix[i][j] = matrix[i][j] ^ myMatrix[i - 1][j - 1] ^ myMatrix[i - 1][j] ^ myMatrix[i][j - 1];
                result[n++] = myMatrix[i][j];
            }
        }
        Arrays.sort(result);
        return result[r * c - k];
    }
}
