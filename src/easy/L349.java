package easy;

import java.util.*;

/**
 * Created by chenz on 2020/12/31 20:32
 */
public class L349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> set2 = new TreeSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        int[] a = new int[set2.size()];
        int i = 0;
        Iterator<Integer> iterator = set2.iterator();
        while (iterator.hasNext()) {
            a[i] = iterator.next();
            i++;
        }
        return a;
    }
}
