package mid;

/**
 * @author chenz at 19:00 on 2022/9/9 .
 */
public class L2401 {
    public int longestNiceSubarray(int[] nums) {
         int  ans  = 1;
         int a = 0;
         int i = 0;
         int j = 0;
        for (; j<nums.length ;) {
            if ((a&nums[j])==0){
                ans=Math.max(ans,j-i+1);
                a|=nums[j];
                j++;
            }else {
                while ((a&nums[j])!=0){
                    a^=nums[i];
                    i++;
                }
            }
        }
         return ans;
    }
}
