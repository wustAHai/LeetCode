package contest.The276;

import java.util.PriorityQueue;

/**
 * @author chenz at 10:18 on 2022/1/16 .
 */
public class S4 {
    public long maxRunTime(int n, int[] batteries) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add((long) batteries[i]);
        }
        for (int i = n; i < batteries.length; i++) {
            Long poll = queue.poll();
            queue.offer(poll+batteries[i]);
        }
        return queue.peek();
    }
}
