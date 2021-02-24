package easy;

/**
 * Created by chenz at 23:06 on 2021/1/16
 */
public class L463 {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int circle = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    if (i + 1 == row) {
                        circle++;
                    } else if (grid[i + 1][j] == 0) {
                        circle++;
                    }
                    if (i == 0) {
                        circle++;
                    } else if (grid[i - 1][j] == 0) {
                        circle++;
                    }
                    if (j + 1 == col) {
                        circle++;
                    } else if (grid[i][j + 1] == 0) {
                        circle++;
                    }
                    if (j == 0) {
                        circle++;
                    } else if (grid[i][j - 1] == 0) {
                        circle++;
                    }
                }
            }
        }
        return circle;
    }
}
