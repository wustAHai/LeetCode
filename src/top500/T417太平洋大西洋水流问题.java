package top500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenz at 20:25 on 2022/4/27 .
 */
public class T417太平洋大西洋水流问题 {
    int [][] dir = {{-1,0},{0,-1},{0,1},{1,0}};
    boolean[][] visited;
    boolean[][] toPacific;
    boolean[][] toAtlantic;
    int[][] heights;
    int m ;
    int n ;
    int i0;int j0;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        this.heights=heights;
        m  = heights.length;
        n  = heights[0].length;
        toPacific = new boolean[m][n];
        toAtlantic = new boolean[m][n];
        visited  = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                i0=i;
                j0=j;
                gotoPacific(i,j);
                gotoAtlantic(i,j);
                if (toPacific[i][j]&&toAtlantic[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    void gotoPacific(int i,int j){
        visited[i][j] =true;
        if (i==0||j==0||toPacific[i][j]){
            toPacific[i][j] =true;
            toPacific[i0][j0] = true;
        }
        for (int k = 0; k < 4; k++) {
            int ni = dir[k][0] +i;
            int nj = dir[k][1] +j;
            if (0<=ni&&ni<m&&0<=nj&&nj<n&&heights[i][j]>=heights[ni][nj]&&!visited[ni][nj]&&!toPacific[i0][j0]){
                gotoPacific(ni,nj);
            }
        }
        if (toPacific[i0][j0]){
            toPacific[i][j] =true;
        }
        visited[i][j] = false;
    }
    void gotoAtlantic(int i,int j){
        visited[i][j] =true;
        if (i==m-1||j==n-1||toAtlantic[i][j]){
            toAtlantic[i][j] = true;
            toAtlantic[i0][j0] =true;
        }
        for (int k = 3; k >=0 ; k--) {
            int ni = dir[k][0] +i;
            int nj = dir[k][1] +j;
            if (0<=ni&&ni<m&&0<=nj&&nj<n&&heights[i][j]>=heights[ni][nj]&&!visited[ni][nj]&&!toAtlantic[i0][j0]){
                gotoAtlantic(ni,nj);
            }
        }
        if (toAtlantic[i0][j0]){
            toAtlantic[i][j] =true;
        }
        visited[i][j] = false;
    }
}
