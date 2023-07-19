package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenz at 14:11 on 2022/9/10 .
 */
public class L2402 {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<int[]> work = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]==o2[1]?o1[0]-o2[0]:o1[1]-o2[1];
            }
        });
        PriorityQueue<Integer> room = new PriorityQueue<>();
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            room.add(i);
        }
        for (int[] meeting : meetings) {
            while (!work.isEmpty()&&work.peek()[1]<=meeting[0]){
                room.add(work.poll()[0]);
            }
            if (!room.isEmpty()){
                Integer poll = room.poll();
                cnt[poll]++;
                work.add(new int[]{poll,meeting[1]});
            }else {
                int[] poll = work.poll();
                cnt[poll[0]]++;
                poll[1]=poll[1]-meeting[0]+meeting[1];
                work.add(poll);
            }
        }
        int asInt = Arrays.stream(cnt).max().getAsInt();
        for (int i = 0; i < n; i++) {
            if (cnt[i]==asInt){
                return i;
            }
        }
        return 0;
    }
}
