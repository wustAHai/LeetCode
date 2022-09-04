package easy;

import java.util.Arrays;

/**
 * @author chenz at 13:07 on 2022/8/28 .
 */
public class L6160 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] ans  = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i]+=nums[i-1];
        }
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < nums.length && nums[j] <= queries[i]; j++) {
                ans[i]=j;
            }
        }
        return ans;
    }
}
