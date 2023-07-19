package mid;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenz at 19:27 on 2023/1/14 .
 */
public class L2530 {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            priorityQueue.add(num);
        }
        long sum = 0;
        for (int i = 0; i < k; i++) {
            int val = priorityQueue.poll();
            sum+=val;
            priorityQueue.add((val+2)/3);
        }
        return sum;
    }
}
