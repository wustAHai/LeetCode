package mid;

/**
 * Created by chenz at 10:18 on 2021/1/8
 */
public class L189 {
    public void rotate0(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] temp = new int[k];

        for (int i = n - k, j = 0; i < n; i++, j++) {
            temp[j] = nums[i];
        }
        for (int i = n - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums,0, nums.length - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, k -1);
    }

    private void reverse(int[] nums, int left, int right){
        int temp;
        while (left<right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
