package mid;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenz at 0:45 on 2022/10/8 .
 */
public class L870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans,-1);
        int[][] arr = new int[nums1.length][2];
        for (int i = 0; i < nums2.length; i++) {
            arr[i][0]=nums2[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        Arrays.sort(nums1);
        for (int i = 0,j=0; i < nums1.length&&j<arr.length;) {
            if (nums1[i]>arr[j][0]){
                ans[arr[j][1]]=nums1[i];
                nums1[i]=-1;
                i++;
                j++;
            }else {
                i++;
            }
        }
        for (int i = 0,j=0; i < nums1.length&&j<nums1.length;) {
            if (nums1[i]!=-1&&ans[j]==-1){
                ans[j]=nums1[i];
                i++;
                j++;
                continue;
            }
            if (nums1[i]==-1){
                i++;
            }
            if (ans[j]!=-1){
                j++;
            }
        }
        return ans;
    }
}
