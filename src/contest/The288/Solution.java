package contest.The288;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author chenz at 10:24 on 2022/4/10 .
 */
public class Solution {
    public int largestInteger(int num) {
        List<Boolean> booleans = new ArrayList<>();
        List<Integer> ji = new ArrayList<>();
        List<Integer> ou = new ArrayList<>();
        while (num > 0) {
            int temp = num % 10;
            num /= 10;
            if (temp % 2 == 0) {
                booleans.add(true);
                ou.add(temp);
            } else {
                booleans.add(false);
                ji.add(temp);
            }
        }
        int jindex = 0;
        int oindex = 0;
        int n = 1;
        int ans = 0;
        ji.sort(null);
        ou.sort(null);
        for (int i = 0; i < booleans.size(); i++) {
            if (booleans.get(i)) {
                ans+=ou.get(oindex++)*n;
            } else {
                ans+=ji.get(jindex++)*n;
            }
            n *= 10;
        }
        return ans;
    }


    public int maximumProduct(int[] nums, int k) {
        int mod = 1000000007;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.add(num);
        }
        while (k>0){
            Integer poll = priorityQueue.poll();
            priorityQueue.add(poll+1);
            k--;
        }
        long ans = 1l;
        while (!priorityQueue.isEmpty()){
            ans*= (priorityQueue.poll()%mod);
            ans%=mod;
        }
        return (int) (ans%mod);
    }


    public String minimizeResult(String expression) {
        String[] split = expression.split("\\+");
        int l = split[0].length();
        int r = split[1].length();
        int min = Integer.MAX_VALUE;
        int[] minIJ=new int[2];
        for (int i = 0; i < l; i++) {
            for (int j = 1; j <=r ; j++) {
                int[] left = getString(split[0], i);
                int[] right = getString(split[1],j);
                int value = left[0]*(left[1]+right[0])*right[1];
                if (min>value){
                    min =value;
                    minIJ[0]=i;
                    minIJ[1]=j;
                }
            }
        }
        StringBuilder sl = new StringBuilder(split[0]);
        StringBuilder sr = new StringBuilder(split[1]);
        sl.insert(minIJ[0],'(');
        sr.insert(minIJ[1],')');
        sl.append('+').append(sr);
        return sl.toString();
    }

    int[] getString(String a,int i){
        if (i==0){
            return new int[]{1, Integer.parseInt(a)};
        }else if (i==a.length()){
            return new int[]{Integer.parseInt(a),1};
        }else {
            return new int[]{Integer.parseInt(a.substring(0,i)),Integer.parseInt(a.substring(i))};
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.minimizeResult("247+38");
        System.out.println(s);
    }

    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        int good = 0;
        return 0;
    }
}
