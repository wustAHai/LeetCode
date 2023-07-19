package easy;

import java.util.Arrays;

/**
 * @author chenz at 18:50 on 2022/9/14 .
 */
public class L1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int d = arr.length/20;
        double sum = 0.0;
        for (int i = d; i < arr.length-d; i++) {
            sum+=arr[i];
        }
        return  sum/(arr.length-d-d);
    }
}
