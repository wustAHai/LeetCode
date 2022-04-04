package mid;

import java.util.Arrays;

/**
 * @author chenz at 12:30 on 2022/3/27 .
 */
public class L2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = mean*(n+rolls.length);
        for (int roll : rolls) {
            sum -= roll;
        }
        if (sum<n||sum>6*n){
            return new int[0];
        }
        int[] ans = new int[n];
        int evg = sum/n;
        Arrays.fill(ans,evg);
        int left = sum%n;
        int i=0;
        while (left>0){
            int min = Math.min(6 - evg, left);
            ans[i]+=min;
            left-=min;
            i++;
        }
        return ans;
    }
}
