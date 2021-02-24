package contest;

import org.junit.Test;

import java.util.HashMap;

public class c5630 {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            int k = hashMap.getOrDefault(nums[i], -1);
            if (k == -1) {
                hashMap.put(nums[i], i);
                temp += nums[i];
                sum = Math.max(sum, temp);
            } else {
                i = k;
                hashMap.clear();
                temp = 0;
            }
        }
        return sum;
    }

    @Test
    public void test() {
        int[] nums = {4, 2, 4, 5, 6};
        System.out.println(maximumUniqueSubarray(nums));
    }
}
