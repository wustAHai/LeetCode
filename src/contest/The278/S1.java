package contest.The278;

import java.util.Arrays;

/**
 * @author chenz at 10:28 on 2022/1/30 .
 */
public class S1 {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for (int num : nums) {
            if (num==original){
                original*=2;
            }
        }
        return original;
    }
}
