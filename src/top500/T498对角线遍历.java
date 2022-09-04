package top500;

/**
 * @author chenz at 19:24 on 2022/6/14 .
 */
public class T498对角线遍历 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int cnt = m + n - 1;
        int i = 0;
        int x = 0;
        int y = 0;
        //00 01 02 12
        int total = 0;
        while (i < cnt) {
            if (i%2==0){
                x = Math.min(i,m-1);
                y = i-x;
                while (x>=0 && y>=0 && x<m &&y<n){
                    ans[total++]=mat[x][y];
                    x--;
                    y++;
                }
            }else {
                y = Math.min(i, n - 1);
                x = i-y;
                while (x>=0 && y>=0 && x<m &&y<n){
                    ans[total++]=mat[x][y];
                    x++;
                    y--;
                }
            }
            i++;
        }
        return ans;
    }
}
