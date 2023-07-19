package easy;

/**
 * @author chenz at 12:11 on 2022/9/4 .
 */
public class L1582 {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowCnt = new int[m];
        int[] colCnt = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j]==1){
                    rowCnt[i]++;
                    colCnt[j]++;
                }
            }
        }
        int  ans = 0;
        for (int i = 0; i < m; i++) {
            if (rowCnt[i]==1){
                for (int j = 0; j < n; j++) {
                    if (mat[i][j]==1&&colCnt[j]==1){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
