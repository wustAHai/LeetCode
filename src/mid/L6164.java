package mid;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author chenz at 14:48 on 2022/7/17 .
 */
public class L6164 {
    public int maximumSum(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int num : nums) {
            int i =  func(num);
            int[] ints = map.get(i);
            if (ints == null){
                ints = new int[2];
                ints[0] = num;
                map.put(i,ints);
            }else {
                if (ints[1]==0){
                    ints[1] = num;
                }else {
                    int max = Math.max(ints[0],ints[1]);
                    int min = Math.min(ints[0],ints[1]);
                    if (num>min){
                        ints[0] = max;
                        ints[1] = num;
                    }
                }
            }
        }
        int ans = -1;
        for (int[] value : map.values()) {
            if (value[1]!=0){
                ans = Math.max(value[0]+value[1],ans);
            }
        }
        return ans;
    }

    int func(int n){
        int ans = 0;
        while (n>0){
            ans+=n%10;
            n/=10;
        }
        return ans;
    }
}
