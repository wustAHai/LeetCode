package contest.The272;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenz at 10:54 on 2021/12/19 .
 */
public class L5959 {
    public int kIncreasing(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;
        int l = n/k + 2;
        for (int i = 0; i < k; i++) {
            int size = 0;
            int[] d = new int[l];
            int len = 1;
            d[len] =  arr[i];
            for (int j = i; j < n; j+=k) {
                size++;
                if (j!=i){
                    if (arr[j]>=d[len]){
                        d[++len] = arr[j];
                    }else {
                        int low = 1;
                        int high = len;
                        int mid = (low + high)/2;
                        while (low<=high){
                            if (d[mid]>arr[j]){
                                high = mid -1;
                            }else {
                                low = mid + 1;
                            }
                            mid = (low + high)/2;
                        }
                        d[mid+1]=arr[j];
                    }
                }
            }
            ans += size - len;
        }
        return ans;
    }
}
