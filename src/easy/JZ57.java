package easy;

import java.util.Arrays;

/**
 * Created by chenz at 8:07 on 2021/3/5
 */
public class JZ57 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int a = Arrays.binarySearch(nums,target-nums[i]);
            if (a>=0&&a!=i){
                return  new int[]{nums[i],nums[a]};
            }
        }
        return  null;
    }
}
