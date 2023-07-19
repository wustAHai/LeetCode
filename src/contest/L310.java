package contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chenz at 10:06 on 2022/9/11 .
 */
public class L310 {
    public int mostFrequentEven(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxtime = 0;
        int max = -1;
        for (int num : nums) {
            if (num%2==0){
                int a = map.getOrDefault(num,0)+1;
                if (a>maxtime){
                    max=num;
                    maxtime  = a;
                }else if (maxtime==a){
                    max = Math.min(max,num);
                }
                map.put(num,a);
            }
        }
        return max;
    }
    public int partitionString(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        int len = chars.length;
        Set<Character> ch = new HashSet<>();
        int j = 0;
        while (j<len){
            if (ch.isEmpty()){
                ans++;
                j++;
                ch.add(chars[j]);
            }else {
                if (ch.contains(chars[j])){
                    ch.clear();
                }else {
                    ch.add(chars[j]);
                    j++;
                }
            }
        }
        return ans;
    }

    public int minGroups(int[][] intervals) {
        int [] arr = new int[(int) (10e6+2)];
        for (int[] interval : intervals) {
            arr[interval[0]]++;
            arr[interval[1]+1]--;
        }
        int max = 0;
        int sum = 0;
        for (int i : arr) {
            sum+=i;
            max=Math.max(sum,i);
        }
        return max;
    }

    public int lengthOfLIS(int[] nums, int k) {
        // TODO: 2022/9/11
        return 0;
    }
}
