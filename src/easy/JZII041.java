package easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenz at 9:24 on 2022/7/16 .
 */
public class JZII041 {
    class MovingAverage {
        long sum;
        int maxLen;
        Deque<Integer> list;


        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            maxLen = size;
            list = new LinkedList<>();
        }

        public double next(int val) {
            sum += val;
            if (list.size() == maxLen) {
                Integer first = list.pollFirst();
                sum -= first;
            }
            list.add(val);

            return (double) sum / list.size();
        }
    }
}
