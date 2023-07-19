package mid;

/**
 * @author chenz at 13:04 on 2023/2/22 .
 */
public class L1140 {
    public int stoneGameII(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length+1];
        int sum = 0;
        for (int i = length-1; i >=0 ; i--) {
            sum+=piles[i];
            for (int j = 1; j <=length; j++) {
                if (j*2>=length-i){
                    dp[i][j]=sum;
                }else {
                    for (int k = 1; k <= 2*j; k++) {
                        dp[i][j] = Math.max(dp[i][j],sum-dp[i+k][Math.max(k,j)]);
                    }
                }
            }
        }
        return dp[0][1];
    }

}
