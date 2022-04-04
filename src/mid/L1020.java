package mid;

/**
 * @author chenz at 20:14 on 2022/2/12 .
 */
public class L1020 {
    boolean[][] isVisited;
    int m;
    int n;
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numEnclaves(int[][] grid) {
         m = grid.length;
         n = grid[0].length;
        isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i,0,grid);
            dfs(i,n-1,grid);
        }
        for (int j = 0; j < n; j++) {
            dfs(0,j,grid);
            dfs(m-1,j,grid);
        }
        int ans = 0;
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (!isVisited[i][j]&&grid[i][j]==1){
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j, int[][] grid) {
        if (i<0||i>=m||j<0||j>=n||isVisited[i][j]||grid[i][j]==0){
            return;
        }
        isVisited[i][j]=true;
        for (int[] dir : dirs) {
            dfs(i+dir[0],j+dir[1],grid);
        }
    }


}
