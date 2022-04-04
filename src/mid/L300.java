package mid;

public class L300 {
    public int lengthOfLIS(int[] nums) {
        int len = 1;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>dp[len]){
                len++;
                dp[len] = nums[i];
            }else {
                int l = 1;
                int r = len;
                int pos = 0;
                while (l<=r){
                    int mid = (l+r)/2;
                    if (dp[mid]<nums[i]){
                        l=mid+1;
                        pos = mid;
                    }else {
                        r=mid-1;
                    }
                }
                dp[pos+1] = nums[i];
            }
        }
        return len;
    }
}
