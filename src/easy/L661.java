package easy;

/**
 * @author chenz at 0:21 on 2022/3/24 .
 */
public class L661 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int [][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int si = i-1;
                int sj = j-1;
                int ei = i+1;
                int ej = j+1;
                int sum = 0;
                int count = 0;
                for (int k = si; k <=ei; k++) {
                    for (int l = sj; l <= ej ; l++) {
                        if (k<0||k>=m||l<0||l>=n){
                            continue;
                        }
                        sum+=img[k][l];
                        count++;
                    }
                }
                ans[i][j]=sum/count;
            }
        }
        return ans;
    }
}
