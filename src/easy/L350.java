package easy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by chenz at 20:57 on 2020/12/31
 */
public class L350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], hashMap.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            hashMap1.put(nums2[i], hashMap1.getOrDefault(nums2[i], 0) + 1);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer integer : hashMap.keySet()) {
            int times = Math.min(hashMap.get(integer), hashMap1.getOrDefault(integer, 0));
            for (int i = 0; i < times; i++) {
                arrayList.add(integer);
            }
        }
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            arr[i] = arrayList.get(i);
        }
        return arr;
    }
}
