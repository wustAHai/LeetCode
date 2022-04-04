package contest.The278;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 10:29 on 2022/1/30 .
 */
public class S2 {
    public List<Integer> maxScoreIndices(int[] nums) {
        int[] dp = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                count++;
            }
            dp[i] = count;
        }
        int count1 = nums.length-dp[nums.length-1];
        int max = count1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = dp[i]+ count1-(i+1-dp[i]);
            max=Math.max(max,dp[i]);
        }
        List<Integer> ans = new ArrayList<>();
        if (max==count1){
            ans.add(0);
        }
        for (int i = 0; i < dp.length; i++) {
            if (max==dp[i]){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
