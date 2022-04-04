package mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 21:49 on 2022/1/14 .
 */
public class L373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k){
        int a = 0;
        int b = 0;
        while (a<nums1.length&&b< nums2.length){
            if (nums1[a]<nums2[b]){
                a++;
            }else {
                b++;
            }
            if (a*b>=k){
                break;
            }
        }
        return null;
    }
}
