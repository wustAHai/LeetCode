package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by chenz at 23:05 on 2021/1/21
 */
public class L506 {
    public String[] findRelativeRanks(int[] nums) {
        String[] strings = new String[nums.length];
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums2);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums2[i], nums.length - i);
        }
        for (int i = 0; i < nums.length; i++) {
            int index = hashMap.get(nums[i]);
            switch (index) {
                case 1:
                    strings[i] = "Gold Medal";
                    break;
                case 2:
                    strings[i] = "Silver Medal";
                    break;
                case 3:
                    strings[i] = "Bronze Medal";
                    break;
                default:
                    strings[i] = "" + index;
                    break;
            }
        }
        return strings;
    }
}
