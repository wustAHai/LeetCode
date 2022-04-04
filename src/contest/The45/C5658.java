package contest.The45;

/**
 * Created by chenz at 22:37 on 2021/2/6
 */
public class C5658 {
    public int maxAbsoluteSum(int[] nums) {
        int preMax = nums[0];
        int preMin = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preMax = Math.max(preMax + nums[i], nums[i]);
            max = Math.max(max, preMax);
            preMin = Math.min(preMin + nums[i], nums[i]);
            min = Math.min(preMin, min);
        }
        return Math.max(Math.abs(max), Math.abs(min));
    }
}
