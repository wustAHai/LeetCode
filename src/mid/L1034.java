package mid;

/**
 * @author chenz at 22:24 on 2021/12/7 .
 */
public class L1034 {
    int [][] next = {{0,1},{0,-1},{-1,0},{1,0}};
    int m ;
    int n ;
    boolean [][] visited;
    boolean [][] board;
    int[][] myGrid;
    int orgCol;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        if (color == grid[row][col]){
            return grid;
        }
        orgCol = grid[row][col];
        m = grid.length;
        n = grid[0].length;
        myGrid = grid;
        visited = new boolean[m][n];
        board = new boolean[m][n];
        dfs(row,col);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]){
                    grid[i][j] = color;
                }
            }
        }
        return  grid;
    }

    void dfs(int row, int col){
        if (row<0||row>=m||col<0||col>=n||visited[row][col]||orgCol!=myGrid[row][col]){
            return;
        }
        visited[row][col] = true;
        board[row][col] = isBoard(row,col);
        for (int i = 0; i < next.length; i++) {
            int newRow = row + next[i][0];
            int newCol = col + next[i][1];
            dfs(newRow,newCol);
        }
    }

    boolean isBoard(int row,int col){
        for (int i = 0; i < next.length; i++) {
            int newRow = row + next[i][0];
            int newCol = col + next[i][1];
            if (newRow<0||newRow>=m||newCol<0||newCol>=n||orgCol!=myGrid[newRow][newCol]){
                return true;
            }
        }
        return false;
    }


}
