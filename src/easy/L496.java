package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenz at 13:52 on 2021/1/19
 */
public class L496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            hashMap.put(nums2[i], i);
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[n1];
        for (int i = 0; i < n1; i++) {
            int index = hashMap.get(nums1[i]);
            boolean isFind = false;
            int temp = -1;
            for (int j = index + 1; j < n2; j++) {
                if (nums2[j] > nums1[i]) {
                    temp = nums2[j];
                    break;
                }
            }
            res[i] = temp;
        }
        return res;
    }
}
