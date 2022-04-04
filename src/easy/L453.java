package easy;

import java.util.Arrays;

/**
 * Created by chenz at 22:27 on 2021/1/15
 */
public class L453 {
    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int sum = Arrays.stream(nums).sum();
        return sum - min * nums.length;
    }

}
