package mid;

import java.util.Arrays;

/**
 * @author chenz at 10:25 on 2022/6/25 .
 */
public class JZII091 {
    public int minCost(int[][] costs) {
        int n  = costs.length;
        int[][] dp = new int[n][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+costs[i][2];
        }
        return Arrays.stream(dp[n-1]).min().getAsInt();
    }
}
