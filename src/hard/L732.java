package hard;

import java.util.TreeMap;

/**
 * @author chenz at 19:27 on 2022/6/6 .
 */
public class L732 {
    class MyCalendarThree {

        private TreeMap<Integer,Integer> map;
        private int max;
        public MyCalendarThree() {
            map = new TreeMap<>();
        }

        public int book(int start, int end) {
            map.put(start,map.getOrDefault(start,0)+1);
            map.put(end,map.getOrDefault(end,0)-1);
            int sum = 0;
            for (Integer value : map.values()) {
                sum+=value;
                max = Math.max(sum,max);
            }
            return max;
        }
    }
}
