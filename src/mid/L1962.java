package mid;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class L1962 {
    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            queue.offer(piles[i]);
            sum += piles[i];
        }
        while (k>0){
            int q = queue.poll();
            sum -= q/2;
            queue.offer((q+1)/2);
            k--;
        }
        return sum;
    }
}
