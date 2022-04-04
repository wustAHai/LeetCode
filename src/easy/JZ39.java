package easy;

import java.util.Arrays;

/**
 * Created by chenz at 8:50 on 2021/2/12
 */
public class JZ39 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
