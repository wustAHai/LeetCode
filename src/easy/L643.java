package easy;

/**
 * Created by chenz at 11:25 on 2021/1/30
 */
public class L643 {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length - k + 1;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            max += nums[i];
        }
        sum = max;
        for (int i = 1; i < n; i++) {
            sum = sum - nums[i - 1] + nums[i + k - 1];
            max = max > sum ? max : sum;
        }
        return (double) max / k;
    }
}
