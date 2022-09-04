package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenz at 22:19 on 2022/5/6 .
 */
public class L933 {
    class RecentCounter {
        Queue<Integer> queue = new LinkedList<>();
        public RecentCounter() {

        }

        public int ping(int t) {
            queue.add(t);
            while (queue.peek()<t-3000){
                queue.poll();
            }
            return queue.size();
        }
    }
}
