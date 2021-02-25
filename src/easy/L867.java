package easy;

/**
 * Created by chenz at 8:27 on 2021/2/25
 */
public class L867 {
    public int[][] transpose(int[][] matrix) {
        int m=matrix.length;
        int n= matrix[0].length;
        int [][] ans = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }
}
