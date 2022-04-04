package mid;

import org.junit.Test;

/**
 * Created by chenz at 7:59 on 2021/2/1
 */
public class JZ04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int r = n - 1;
        int c = 0;
        while (r >= 0 && c < m) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                c++;
            } else {
                r--;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 21;
        System.out.println(findNumberIn2DArray(matrix, target));
    }
}
