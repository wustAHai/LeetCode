package hard;

/**
 * @author chenz at 20:21 on 2021/12/8 .
 */
public class L689 {
    public int[] maxSumOfOneSubarrays(int[] nums, int k) {
        int tempMax  = 0;
        int max = Integer.MIN_VALUE;
        int[] ans = new int[1];
        for (int i = 0; i < nums.length; i++) {
            tempMax += nums[i];
            if (i>=k-1){
                if (tempMax>max){
                    max=tempMax;
                    ans[0] = i-k+1;
                }
                tempMax-=nums[i-k+1];
            }
        }
        return ans;
    }

    public int[] maxSumOfTwoSubarrays(int[] nums, int k) {
        int[] ans = new int[2];
        int sum1 = 0, maxSum1 = 0, maxSum1Idx = 0;
        int sum2 = 0, maxSum12 = 0;
        for (int i = k; i < nums.length; i++) {
            sum1+=nums[i-k];
            sum2+=nums[i];
            if (i>=2*k-1){
                if (sum1>maxSum1){
                    maxSum1 = sum1;
                    maxSum1Idx=i-2*k+1;
                }
                if (maxSum1+sum2>maxSum12){
                    ans[0] = maxSum1Idx;
                    ans[1] = i-k+1;
                    maxSum12 = maxSum1+sum2;
                }
                sum1-=nums[i-2*k+1];
                sum2-=nums[i-k+1];
            }
        }
        return ans;
    }
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = new int[3];
        int sum1 = 0, maxSum1 = 0, maxSum1Idx = 0;
        int sum2 = 0, maxSum12 = 0, maxSum12Idx1 = 0, maxSum12Idx2 = 0;
        int sum3 = 0, maxTotal = 0;
        for (int i = 2*k; i < nums.length; i++) {
            sum1+=nums[i-2*k];
            sum2+=nums[i-k];
            sum3+=nums[i];
            if (i>=3*k-1){
                if (sum1>maxSum1){
                    maxSum1 = sum1;
                    maxSum1Idx=i-3*k+1;
                }
                if (maxSum1+sum2>maxSum12){
                     maxSum12Idx1= maxSum1Idx;
                     maxSum12Idx2= i-2*k+1;
                     maxSum12 = maxSum1+sum2;
                }
                if (maxSum12+sum3>maxTotal){
                    maxTotal = maxSum12 + sum3;
                    ans[0] =maxSum12Idx1;
                    ans[1] = maxSum12Idx2;
                    ans[2] = i-k+1;
                }
                sum1-=nums[i-3*k+1];
                sum2-=nums[i-2*k+1];
                sum3-=nums[i-k+1];
            }
        }
        return ans;
    }
}
