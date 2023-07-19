package mid;

/**
 * @author chenz at 11:08 on 2022/10/7 .
 */
public class L2425 {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int a = 0;
        int b = 0;
        if ((nums1.length&1)!=0){
            for (int i : nums2) {
                b^=i;
            }
        }
        if ((nums2.length&1)!=0){
            for (int i : nums1) {
                a^=i;
            }
        }
        return  a^b;
    }
}
