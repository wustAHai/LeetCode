package mid;

import java.util.*;

/**
 * @author chenz at 20:01 on 2021/12/24 .
 */
public class L1705 {
    public String[] findLongestSubarray(String[] array) {
        int sum = 0;
        int length = 0;
        int l = -1;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i = 0; i < array.length; i++) {
            if (Character.isDigit(array[i].charAt(0))){
                sum++;
            }else {
                sum--;
            }
            if (map.containsKey(sum)){
                Integer integer = map.get(sum);
                if (i-integer>length){
                    length = i-integer;
                    l=integer;
                }else if(i-integer == length){
                    l=Math.min(l,integer);
                }
            }else {
                map.put(sum,i);
            }
        }
       if (length==0){
           return  new String[0];
       }
       String [] arr = new String[length];
       System.arraycopy(array,l+1,arr,0,length);
       return arr;
    }


    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int ans = 0;
        for (int i = 0; i < apples.length; i++) {
            if (apples[i]>0){
                if (priorityQueue.isEmpty()){
                    ans++;
                    apples[i]--;
                    if (apples[i]>0){
                        priorityQueue.offer(new int[]{i+days[i],apples[i]});
                    }
                }else {
                    int[] poll = new int[2];
                    while (!priorityQueue.isEmpty()){
                         poll= priorityQueue.poll();
                         if (poll[0]>i){
                             break;
                         }
                    }
                    if (poll[0]<=i){
                        ans++;
                        apples[i]--;
                        if (apples[i]>0){
                            priorityQueue.offer(new int[]{i+days[i],apples[i]});
                        }
                    }else {
                        int left = i + days[i];
                        if (left<poll[0]){
                            apples[i]--;
                            ans++;
                            if (apples[i]>0){
                                priorityQueue.offer(new int[]{left,apples[i]});
                            }
                            priorityQueue.offer(poll);
                        }else if (left == poll[0]){
                            ans++;
                            poll[1]--;
                            poll[1]+=apples[i];
                            priorityQueue.offer(poll);
                        }else {
                            ans++;
                            poll[1]--;
                            if (poll[1]>0){
                                priorityQueue.offer(poll);
                            }
                            priorityQueue.offer(new int[]{left,apples[i]});
                        }
                    }
                }
            }else {
                while (!priorityQueue.isEmpty()){
                    int[] poll = priorityQueue.poll();
                    if (poll[0]>i){
                        poll[1]--;
                        if (poll[1]>0){
                            priorityQueue.offer(poll);
                        }
                        ans++;
                        break;
                    }
                }
            }
        }
        int i = apples.length;
        while (!priorityQueue.isEmpty()){
            int[] poll = priorityQueue.poll();
            if (poll[0]>i){
                int a = Math.min(poll[0]-i,poll[1]);
                ans += a;
                i +=a;
            }
        }
        return ans;
    }

}
