package mid;

import java.util.Arrays;

/**
 * @author chenz at 10:10 on 2022/7/16 .
 */
public class L1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int neg = sum/2;
        boolean[][] dp = new boolean[stones.length+1][neg+1];
        dp[0][0] = true;
        for (int i = 1; i <=stones.length ; i++) {
            dp[i][0] = true;
            int weight = stones[i-1];
            for (int j = 1; j < neg+1; j++) {
                if (weight>j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j-weight] || dp[i-1][j];
                }
            }
        }
        for (int i = neg;  ; i--) {
            if (dp[stones.length][i]){
                return  sum -2*i;
            }
        }
    }
    public int lastStoneWeightII1(int[] stones) {
        int sum = 0;
        for (int weight : stones) {
            sum += weight;
        }
        int n = stones.length, m = sum / 2;
        boolean[] dp = new boolean[m+1];
        dp[0] = true;
        for (int stone : stones) {
            for (int j = m; j>=0; j--) {
                if (stone<=j){
                    dp[j] = dp[j] || dp[j-stone];
                }
            }
        }
        for (int i = m;  ; i--) {
            if (dp[i]){
                return sum - 2*i;
            }
        }
    }
}
