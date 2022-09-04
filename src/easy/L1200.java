package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenz at 23:28 on 2022/7/4 .
 */
public class L1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int minGap = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minGap = Math.min(arr[i]-arr[i-1],minGap);
        }
        for (int i = 1; i < arr.length ; i++) {
            if (minGap == arr[i]-arr[i-1]){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i-1]);
                list.add(arr[i]);
                ans.add(list);
            }
        }
        return ans;
    }
}
