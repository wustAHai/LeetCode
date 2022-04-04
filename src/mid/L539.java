package mid;

import java.util.Arrays;
import java.util.List;

/**
 * @author chenz at 22:33 on 2022/1/18 .
 */
public class L539 {
    public int findMinDifference(List<String> timePoints) {
        int max = 24*60;
        if (timePoints.size()>=max){
            return 0;
        }
        int[] arr = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String[] split = timePoints.get(i).split(":");
            int  time = Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
            arr[i] =time;
        }
        Arrays.sort(arr);
        int ans = max;
        for (int i = 1; i < arr.length; i++) {
            ans = Math.min(arr[i]-arr[i-1],ans);
        }
        return Math.min(ans,max-(arr[arr.length-1]-arr[0]));
    }
}
