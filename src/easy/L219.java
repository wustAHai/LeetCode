package easy;

import java.util.HashMap;
import java.util.Map;

public class L219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int index = hm.getOrDefault(nums[i], -k - 1);
            if (index + k > 0) {
                return false;
            }
            hm.put(nums[i], i);
        }
        return true;
    }

}
