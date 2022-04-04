package easy;

/**
 * Created by chenz at 18:54 on 2021/2/11
 */
public class L268 {
    public int missingNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += (i - nums[i] + 1);
        }
        return ans;
    }
}
