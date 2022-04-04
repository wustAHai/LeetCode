package contest.Th60;

import java.util.ArrayList;

public class L5847 {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        boolean[][] visited = new boolean[m][n];
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]&&land[i][j]==1){
                    visited[i][j]=true;
                    int sr = i;
                    int sc = j;
                    int er = i;
                    int ec = j;
                    while (er+1<m&&land[er+1][j]==1){
                        er++;
                    }
                    while (ec+1<n&&land[i][ec+1]==1){
                        ec++;
                    }
                    fill(visited,sr,sc,er,ec);
                    arrayList.add(new int[]{sr,sc,er,ec});
                }
            }
        }
        int[][] ans = new int[arrayList.size()][];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = arrayList.get(i);
        }
        return ans;
    }

    private void fill(boolean[][] visited, int sr, int sc, int er, int ec) {
        for (int i = sr; i <= er; i++) {
            for (int j = sc; j <= ec ; j++) {
                visited[i][j] = true;
            }
        }
    }
}
