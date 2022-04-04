package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class L502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] item = new int[n][2];
        for (int i = 0; i < n; i++) {
            item[i][0] = profits[i];
            item[i][1] = capital[i];
        }
        Arrays.sort(item, (o1, o2) -> o1[1]-o2[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        int cur = 0;
        for (int i = 0; i < k; i++) {
            while (cur<n&&item[cur][1]<=w){
                queue.offer(item[cur][0]);
                cur++;
            }
            if (!queue.isEmpty()){
                w+=queue.poll();
            }else {
                return w;
            }
        }
        return  w;
    }

}
