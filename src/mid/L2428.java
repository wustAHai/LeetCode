package mid;

/**
 * @author chenz at 17:43 on 2022/10/6 .
 */
public class L2428 {
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m-2; i++) {
            for (int j = 0; j < n-2; j++) {
                max = Math.max(max,grid[i][j]+grid[i][j+1]+grid[i][j+2]
                +grid[i+1][j+1]+grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2]);
            }
        }
        return  max;
    }
}
