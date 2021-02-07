package mid;

/**
 * Created by chenz at 10:18 on 2021/1/8
 */
public class L189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k%=n;
        int [] temp = new int[k];

        for (int i = n-k,j=0; i < n; i++,j++) {
            temp[j] = nums[i];
        }
        for (int i = n-k-1; i >=0; i--) {
            nums[i+k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i]=temp[i];
        }
    }
}
