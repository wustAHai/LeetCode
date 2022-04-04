package mid;

import java.util.Arrays;

public class L1968 {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[nums.length];
        int  i = 0;
        int  j = nums.length - 1;
        int k = 0;
        for (;k<nums.length;k++){
            if (k%2==0){
                ans[k] = nums[i];
                i++;
            }else {
                ans[k] = nums[j];
                j--;
            }
        }
        return ans;
    }
}
