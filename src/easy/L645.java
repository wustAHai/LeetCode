package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenz at 11:41 on 2021/1/30
 */
public class L645 {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> integers = new HashSet<>();
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (integers.contains(nums[i])) {
                k = nums[i];
                break;
            } else {
                integers.add(nums[i]);
            }
        }
        int miss = (1 + nums.length) * nums.length / 2 + k - Arrays.stream(nums).sum();
        return new int[]{k, miss};
    }
}
