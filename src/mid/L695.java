package mid;

public class L695 {
    int ans = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] isVisited = new boolean[r][c];
        int num = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                search(grid,isVisited,i,j);
                num = Math.max(num,ans);
                ans = 0;
            }
        }
        return num;
    }

    private void search(int[][] grid, boolean[][] isVisited, int i, int j) {
        if (i<0||i>=grid.length||j<0||j>=grid[i].length||isVisited[i][j]){
            return;
        }
        if (grid[i][j]==0){
            isVisited[i][j]=true;
        }else {
            ans++;
            isVisited[i][j]=true;
            search(grid,isVisited,i+1,j);
            search(grid,isVisited,i,j+1);
            search(grid,isVisited,i,j-1);
            search(grid,isVisited,i-1,j);
        }
    }
}
