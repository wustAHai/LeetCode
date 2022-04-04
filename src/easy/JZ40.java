package easy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by chenz at 8:43 on 2021/2/12
 */
public class JZ40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i :
                arr) {
            queue.offer(i);
            if (queue.size() > 0) {
                queue.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}
