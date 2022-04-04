package hard;

import java.util.*;

/**
 * @author chenz at 12:39 on 2022/4/1 .
 */
public class L1606 {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[k];
        int max = 0;
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < arrival.length; i++) {
            int index = arrival[i];
            while (!priorityQueue.isEmpty()){
                if (priorityQueue.peek()[0]<=index){
                    available.add(priorityQueue.poll()[1]) ;
                }else {
                    break;
                }
            }
            if (available.isEmpty()){
                continue;
            }
            index = i%k;
            Integer ceiling = available.ceiling(index);
            int find;
            if (ceiling == null){
                find = available.pollFirst();
            }else {
                find=ceiling;
                available.remove(ceiling);
            }
            ++count[find];
            max = Math.max(max,count[find]);
            priorityQueue.add(new int[]{arrival[i]+load[i],find});
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i]==max){
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int k = 3;
        int [] arr = new int[]{1,2,3,4,5};
        int [] load = new int[]{5,2,3,3,3};
        new L1606().busiestServers(k,arr,load);
    }
}
