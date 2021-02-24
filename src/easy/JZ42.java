package easy;

/**
 * Created by chenz at 19:12 on 2021/2/13
 */
public class JZ42 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int preMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preMax = Math.max(nums[i], nums[i] + preMax);
            max = Math.max(max, preMax);
        }
        return max;
    }
}
