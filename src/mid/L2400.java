package mid;

/**
 * @author chenz at 20:54 on 2022/9/5 .
 * <a href="https://leetcode.cn/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/solution/by-tsreaper-qzp3/">求阶乘</a>
 */

public class L2400 {
    int mod = (int) (1e9+7);
    public int numberOfWays(int startPos, int endPos, int k) {
        int abs = Math.abs(endPos - startPos);
        if (k<abs||(k-abs)%2!=0){
            return 0;
        }
        int n = k-abs>>1;
       //CKN
/*        int[][] arr = new int[k+1][k+1];
        for (int i = 0; i < k+1; i++) {
            arr[i][0]=1;
            for (int j = 1; j <=i &&j<=n; j++) {
                arr[i][j]= (arr[i-1][j] + arr[i-1][j-1])%mod;
            }
        }
        return arr[k][n];*/
        int[] arr = new int[k+1];
        arr[0]=1;
        for (int i = 1; i < k+1; i++) {
            for (int j = Math.min(i,n) ; j>=1; j--) {
                arr[j] = (arr[j]+arr[j-1])%mod;
            }
        }
        return arr[n];
    }
}
