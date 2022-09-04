package hard;

/**
 * @author chenz at 20:35 on 2022/6/29 .
 */
public class L2321 {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int sum1 = 0;
        int sum2 = 0;
        int[] diff12 = new int[nums1.length];
        int[] diff21 = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
            diff12[i] = nums1[i] - nums2[i];
            diff21[i] = nums2[i] - nums1[i];
        }
        int max12 = diff12[0];
        int max21 = diff21[0];
        for (int i = 1; i < nums1.length; i++) {
            diff12[i] = Math.max(diff12[i]+diff12[i-1] , diff12[i]);
            max12=Math.max(max12,diff12[i]);
            diff21[i] = Math.max(diff21[i]+diff21[i-1] , diff21[i]);
            max21=Math.max(max21,diff21[i]);
        }
        return Math.max(Math.max(sum1,sum1+max21),Math.max(sum2,sum2+max12));
    }
}
