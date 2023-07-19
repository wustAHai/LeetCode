package easy;

/**
 * @author chenz at 10:34 on 2022/10/7 .
 */
public class L1800 {
    public int maxAscendingSum(int[] nums) {
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>nums[i-1]){
                pre+=nums[i];
            }else {
                pre = nums[i];
            }
            max = Math.max(max,pre);
        }
        return max;
    }
}
