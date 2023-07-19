package contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenz at 22:28 on 2022/11/12 .
 */
public class L91 {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        Set<Integer> set = new HashSet<>();
        while (i<j){
            set.add(nums[i]+nums[j]);
            i++;
            j--;
        }
        return set.size();
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high+1];
        dp[0]= 1;
        for (int i = 1; i <= high; i++) {
            if (i-zero>=0){
                dp[i]+=dp[i-zero];
            }
            if (i-one>=0){
                dp[i]+=dp[i-one];
            }
        }
        long ans = 0;
        for (int i =low; i <=high ; i++) {
            ans+=dp[i]+dp[i];
        }
        return (int) (ans%1000000007);
    }
}
