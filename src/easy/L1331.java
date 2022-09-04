package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenz at 22:09 on 2022/7/28 .
 */
public class L1331 {
    public int[] arrayRankTransform(int[] arr) {
        if(arr == null || arr.length==0){
            return arr;
        }
        int[] ints = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        Map<Integer,Integer> Map = new HashMap<>();
        int i = 1;
        Map.put(arr[0],i);
        for(int j=1;j<arr.length;j++){
            if(arr[j]>arr[j-1]){
                Map.put(arr[j],++i);
            }
        }
        for (int i1 = 0; i1 < ints.length; i1++) {
            ints[i1] = Map.get(ints[i1]);
        }
        return ints;
    }
}
