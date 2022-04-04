package easy;

/**
 * @author chenz at 20:49 on 2022/2/26 .
 */
public class L2016 {
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int min =  nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min>=nums[i]){
                min=nums[i];
            }else {
                ans = Math.max(ans,nums[i]-min);
            }
        }
        return ans;
    }
}
