package mid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenz at 18:55 on 2022/9/20 .
 */
public class L698 {
    int [] nums;
    int n,per;
    boolean[]dp;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        this.n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum%k!=0){
            return false;
        }
        per = sum/k;
        Arrays.sort(nums);
        if (nums[n-1]>per){
            return false;
        }
        dp = new boolean[1<<n];
        Arrays.fill(dp,true);
        return  dfs((1<<n)-1,0);
    }

    private boolean dfs(int s, int p) {
        if (!dp[s]){
            return dp[s];
        }
        if (s==0){
            return true;
        }
        dp[s] = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] + p > per){
                break;
            }
            if (((s>>i)&1)==1){
                if (dfs((s^(1<<i)),(p+nums[i])%per)){
                    return true;
                }
            }
        }
        return false;
    }
}
