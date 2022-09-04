package mid;

/**
 * @author chenz at 18:11 on 2022/5/5 .
 */
public class L713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0){
            return 0;
        }
        int n  = nums.length;
        int prev = 0;
        long product = 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (prev == 0){
                product = 1;
            }
            if (nums[i]>=k){
                prev =0;
                continue;
            }
            product*=nums[i];
            if (product<k){
                prev++;
                ans+=prev;
            }else {
                while (prev>0&&product>=k){
                    product/=nums[i-prev];
                    prev--;
                }
                if (product<k){
                    prev++;
                    ans+=prev;
                }else {
                    prev=0;
                }
            }
        }
        return ans;
    }

}
