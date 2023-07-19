package easy;

import java.util.Arrays;

/**
 * @author chenz at 21:20 on 2022/10/18 .
 */
public class L922 {
    public int[] sortArrayByParityII(int[] nums) {
        //11 22
        //0 1 2 3 4 5
        //1 1 1 2 2 2
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i]&1)==1){
                nums[i]=-nums[i];
            }
        }
        Arrays.sort(nums);
        int k = nums.length>>1;
        for (int i = 0; i < k; i++) {
            nums[i]=-nums[i];
        }
        int j = nums.length-1;
        if ((j&1)==0){
            j--;
        }
        for (int i = 0; i < k ; i+=2,j-=2) {
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        return nums;
    }
}
