package easy;

import java.util.Arrays;

/**
 * @author chenz at 13:15 on 2022/9/12 .
 */
public class L1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        for(int i=1,j=0;i<=nums.length;i++){
            while (j<nums.length){
                if (nums[j]<i){
                    j++;
                }else {
                    break;
                }
            }
            if (i==l-j){
                return i;
            }
        }
        return -1;
    }
}
