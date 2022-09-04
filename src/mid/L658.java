package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenz at 19:31 on 2022/8/25 .
 */
public class L658 {
    /*    public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int p = 0;
            int q = k-1;
            while (q+1<arr.length&&Math.abs(arr[q+1]-x)<Math.abs(arr[p]-x)){
                q++;
                p++;
            }
            List<Integer> list = new ArrayList<>(k);
            for (int i = p; i <=q ; i++) {
                list.add(arr[i]);
            }
            return list;
        }*/
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>(k);
        int i = 0;
        while (i<arr.length&&arr[i]<x){
            i++;
        }
        if (i==0){
            for(;i<k;i++){
                list.add(arr[i]);
            }
        }else if (i==arr.length){
            for (int j = arr.length-k; j < arr.length; j++) {
                list.add(arr[j]);

            }
        }else {
            if (arr[i]>x){
                if (x-arr[i-1]<=arr[i]-x){
                    i--;
                }
            }
            int p = i;
            int q = i;
            while (q-p+1<k){
                if (p>0&&q<arr.length-1){
                    if (Math.abs(x-arr[p-1])<=Math.abs(x-arr[q+1])){
                        p--;
                    }else {
                        q++;
                    }
                }else if (p==0){
                    q++;
                }else {
                    p--;
                }
            }
            for (int j = p; j <=q ; j++) {
                list.add(arr[j]);
            }
        }
        return list;
    }
}
