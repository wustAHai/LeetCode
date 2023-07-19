package hard;

/**
 * @author chenz at 21:21 on 2022/9/26 .
 */
public class 消失的两个数字 {
    // 0001 1111 0010 1110 0011 1101
    public int[] missingTwo(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        int sum = (n+3)*n>>1;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            leftSum+=abs;
            int idx =abs-1;
            if (idx<n){
                nums[idx]=-nums[idx];
            }
        }
        for (int i = 0; i < n; i++) {
            if(nums[i]>0){
                ans[0]=i+1;
                ans[1]=leftSum-i-1;
                break;
            }
        }
        if (ans[0]==0){
            ans[0]=n+1;
            ans[1]=n+2;
        }
        return ans;
    }
}
