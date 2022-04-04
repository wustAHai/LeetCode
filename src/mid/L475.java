package mid;

import java.util.Arrays;

/**
 * @author chenz at 18:49 on 2021/12/20 .
 */
public class L475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int j = 0;
        int ans = -1;
        for (int i = 0; i < houses.length; i++) {
            int distance = Math.abs(houses[i]-heaters[j]);
            while (j<heaters.length-1 && distance>=Math.abs(houses[i]-heaters[j+1])){
                j++;
                distance = Math.abs(houses[i]-heaters[j]);
            }
            ans = Math.max(ans,distance);
        }
        return ans;
    }
}
