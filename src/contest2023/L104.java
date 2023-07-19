package contest2023;

import java.util.*;

/**
 * @author chenz at 22:29 on 2023/5/13 .
 */
public class L104 {
    public int countSeniors(String[] details) {
        int cnt = 0 ;
        for (String detail : details) {
            if (Integer.parseInt(detail.substring(11,13))>60){
                cnt++;
            }
        }
        return  cnt;
    }

    public int matrixSum(int[][] nums) {
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        int sum = 0;
        for(int i = 0;i<nums[0].length;i++){
            int max = nums[0][i];
            for (int j = 1; j < nums.length; j++) {
                max = Math.max(max,nums[j][i]);
            }
            sum+=max;
        }
        return sum;
    }
    // 1100 1001

    public long maximumOr(int[] nums, int k) {
        int[] cnt = new int[30+k];
        int maxNum =  0;
        for (int i = 0; i < nums.length; i++) {
            int t=0;
            int num = nums[i];
            maxNum = Math.max(maxNum,num);
            while (num>0){
                cnt[t++]+=num%2;
                num/=2;
            }
        }
        long max  = 0;
        int temp = maxNum;
        int bit = 0;
        while (temp>0){
            temp/=2;
            bit++;
        }
        temp = 1<<(bit-1);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=temp){
                set.add(nums[i]);
            }
        }
        for (Integer integer : set) {
            long t = 0;
            temp = integer;
            int idx = 0;
            while (temp>0){
                int mod = temp%2;
                temp/=2;
                cnt[idx]-=mod;
                cnt[idx+k]+=mod;
                idx++;
            }
            for (int i = cnt.length-1; i >=0; i--) {
                t*=2;
                if (cnt[i]>0){
                    t+=1;
                }
            }
            max = Math.max(max,t);
            temp = integer;
            idx = 0;
            while (temp>0){
                int mod = temp%2;
                temp/=2;
                cnt[idx]+=mod;
                cnt[idx+k]-=mod;
                idx++;
            }
        }
        return max;
    }

    //1 2 3 4
    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        int MOD = 1000000007;
        long ans = 0;
        ans += (((long) nums[0] *nums[0])%MOD*nums[0])%MOD;
        long preSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            long num = nums[i];
            long sqt = num*num%MOD;
            ans+= sqt*((preSum+num)%MOD)%MOD;
            preSum= (preSum*2 +num)%MOD;
        }
        return (int) (ans%MOD);
    }



    public static void main(String[] args) {
        L104 l104 = new L104();
        System.out.println(l104.maximumOr(new int[]{12,9},1));
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        //112 121 122  1223333 3132313
        int cnt[] = new  int[10001];
        for (int i = 0; i < barcodes.length; i++) {
            cnt[i]++;
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diff = o2[1] - o1[1];
                return diff==0?o1[0]-o2[0]:diff;
            }
        });
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i]>0){
                priorityQueue.add( new int[]{i,cnt[i]});
            }
        }
        int index = 0;
        int[] ret = new  int[barcodes.length];
        while (priorityQueue.size()>=2){
            int[] poll = priorityQueue.poll();
            int[] poll1 = priorityQueue.poll();
            ret[index++]=poll[0];
            ret[index++]=poll1[0];
            if (--poll[1]>0){
                priorityQueue.add(poll);
            }
            if (--poll1[1]>0){
                priorityQueue.add(poll1);
            }
        }
        if (!priorityQueue.isEmpty()){
            ret[index]=priorityQueue.peek()[0];
        }
        return ret;
    }


}
