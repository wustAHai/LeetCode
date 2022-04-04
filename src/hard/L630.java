package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenz at 22:14 on 2021/12/14 . 优先队列加贪心
 */
public class L630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        int time = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> b-a);
        for (int i = 0; i < courses.length; i++) {
            int duration  = courses[i][0];
            int lastDay = courses[i][1];
            if (duration > lastDay){
                continue;
            }
            if (duration + time <= lastDay){
                queue.add(duration);
                time+=duration;
            }else {
                if (!queue.isEmpty()){
                    Integer peek = queue.peek();
                    if (peek>duration){
                        queue.poll();
                        queue.add(duration);
                        time+=duration-peek;
                    }
                }
            }
        }
        return queue.size();
    }
}
