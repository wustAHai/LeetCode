package easy;

import java.util.Arrays;

/**
 * @author chenz at 20:28 on 2022/2/11 .
 */
public class L1984 {
    public int minimumDifference(int[] nums, int k) {
        if (k==1){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = k-1; i < nums.length; i++) {
            ans = Math.min(ans,nums[i]-nums[i-k+1]);
        }
        return ans;
    }
}
