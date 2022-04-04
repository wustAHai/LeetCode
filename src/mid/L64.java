package mid;

import org.junit.Test;

/**
 * Created by chenz at 11:12 on 2021/1/1
 */
public class L64 {
    public int minPathSum(int[][] grid) {
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    @Test
    public void test() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}};
        minPathSum(arr);
    }
}
