package hard;

/**
 * @author chenz at 22:27 on 2022/10/10 .
 */
public class L801 {
    public int minSwap(int[] nums1, int[] nums2) {
        int a = 0;
        int b = 1;
        for (int i = 1; i < nums1.length; i++) {
            int ta = a;
            int tb = b;
            if (nums1[i]>nums1[i-1]&&nums2[i]>nums2[i-1]&&nums1[i]>nums2[i-1]&&nums2[i]>nums1[i-1]){
                a=Math.min(ta,tb);
                b=a+1;
            }else if (nums1[i]>nums1[i-1]&&nums2[i]>nums2[i-1]){
                //a=ta;
                b=tb+1;
            }else {
               a=tb;
               b=ta+1;
            }
        }
        return Math.min(a,b);
    }
}
