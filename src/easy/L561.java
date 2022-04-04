package easy;

import java.util.Arrays;

/**
 * Created by chenz at 14:39 on 2021/1/25
 */
public class L561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
