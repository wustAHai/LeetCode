package contest;

import java.util.*;

/**
 * @author chenz at 22:26 on 2022/9/3 .
 */
public class L86 {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            if (set.contains(nums[i]+nums[i-1])){
                return true;
            }
            set.add(nums[i]+nums[i-1]);
        }
        return false;
    }

    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n-2; i++) {
            int temp = n;
            List<Integer> list = new ArrayList<>();
            while (temp>0){
                list.add(temp%i);
                temp/=i;
            }
            int size = list.size();
            for (int j = 0; j < size/2; j++) {
                if (!list.get(j).equals(list.get(size-1-j))){
                    return false;
                }
            }
        }
        return true;
    }
    long[] arr;
    int max = 0;
    public int maximumRows(int[][] mat, int cols) {
        int m  = mat.length;
        int n  = mat[0].length;
        if (cols == n){
            return  m;
        }
        arr  = new long[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i]<<=1;
                arr[i]+=mat[i][j];
            }
        }
        int left0 = n-cols;
        fun(cols,left0,0l);
        return max;
    }
   void fun(int num1,int num0,long val){
       if (num0==0&&num1==0){
           int temp = 0;
           for (long l : arr) {
               if ((l&val)==l){
                   temp++;
               }
           }
           max = Math.max(temp,max);
       }
       val<<=1;
       if (num1>0){
           fun(num1-1,num0,val+1);
       }
       if (num0>0){
           fun(num1,num0-1,val);
       }
    }

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int max = 0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o2[0];
            }
        });
        int i =0;
        int j = 0;
        long sum =0;
        while (j<chargeTimes.length){
            if (i==j){
                if (chargeTimes[j]+runningCosts[j]<=budget){
                    priorityQueue.add(new int[]{j,chargeTimes[j]});
                    max = Math.max(1,max);
                    sum+=runningCosts[j];
                    j++;
                }else {
                    i++;
                    j++;
                }
            }else {
                while (priorityQueue.peek()[0]<i){
                    priorityQueue.poll();
                }
                if (Math.max(priorityQueue.peek()[1],chargeTimes[j])+ (sum+runningCosts[j])*(j-i+1)<=budget){
                    priorityQueue.add(new int[]{j,chargeTimes[j]});
                    sum+=runningCosts[j];
                    max = Math.max(j-i+1,max);
                    j++;
                }else {
                    sum-=runningCosts[i];
                    i++;
                }
            }
        }
        return max;
    }
}
