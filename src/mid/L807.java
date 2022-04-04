package mid;

/**
 * @author chenz at 21:02 on 2021/12/13 .
 */
public class L807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] col = new int[n];
        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
            int max = -1;
            int max1 = -1;
            for (int j = 0; j < n; j++) {
                max = Math.max(max,grid[i][j]);
                max1 = Math.max(max1,grid[j][i]);
            }
            row[i] = max;
            col[i] = max1;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.min(row[i],col[j])  - grid[i][j];
            }
        }
        return sum;
    }
}
